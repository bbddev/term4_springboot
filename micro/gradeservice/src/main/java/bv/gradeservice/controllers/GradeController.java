package bv.gradeservice.controllers;

import bv.gradeservice.models.*;
import bv.gradeservice.repository.GradeRepository;
import bv.gradeservice.services.NotifyClient;
import bv.gradeservice.services.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserClient userClient;
    @Autowired
    private NotifyClient notifyClient;

    @GetMapping
    public List<Grade> getGrades() {
        return gradeRepository.findAll();
    }

    @PostMapping
    public Grade addUserGrade(@RequestBody PointRequest request) {
        Long userId = request.getUserId();
        Integer point = request.getPoint();
        Grade gr = gradeRepository.findByUserId(userId)
                .orElse(new Grade(null, userId, 0, LocalDateTime.now()));
        gr.setPoint(gr.getPoint() + point);
        gr.setTimestamp(LocalDateTime.now());
        NotifyDTO notify = null;
        if (gr.getPoint() >= 100) {
            notify = new NotifyDTO(userId, "MILESTONE_REACHED",
                    "Chúc mừng! Bạn đã đạt mốc score điểm!"
                            .replace("score", String.valueOf(gr.getPoint())),
                    LocalDateTime.now());
        } else {
            notify = new NotifyDTO(userId, "POINT_EARNED",
                    "Chúc mừng! Bạn đã đạt mốc score điểm!"
                            .replace("score", String.valueOf(gr.getPoint())),
                    LocalDateTime.now());
        }
        //kham pha notify, gui thong tin qua notift de lluu data
        notifyClient.sendNotify(notify);
        //save thong tin diem cho user
        gradeRepository.save(gr);
        return gr;
    }

    @GetMapping("/api/user/{userId}")
    public UserGradeDTO getUserGrade(@PathVariable Long userId) {
        UserDTO user = userClient.getUserById(userId);
        //Tim diem so cua user
        Optional<Grade> gradeUser = gradeRepository.findByUserId(userId);
        int point = gradeUser.map(Grade::getPoint).orElse(0);
        UserGradeDTO userGradeDTO = new UserGradeDTO(user.getId(), user.getName(), user.getEmail(), point);
        return userGradeDTO;
    }

}
