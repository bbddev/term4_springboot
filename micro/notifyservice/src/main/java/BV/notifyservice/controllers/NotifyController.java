package BV.notifyservice.controllers;

import BV.notifyservice.models.Notify;
import BV.notifyservice.repositories.NotifyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/notify")
    @RequiredArgsConstructor
    public class NotifyController {
        //DI
        //Autowired (khong khuyen khich)
        //Constructor
        // @RequiredArgsConstructor
        private final NotifyRepository notifyRepository;
        @GetMapping("/all")
        public List<Notify> findAll() {
            return notifyRepository.findAll();
        }
        @PostMapping("/send")
        public Notify send(@RequestBody Notify notify) {
            return notifyRepository.save(notify);
        }
        @GetMapping("/user/{userId}")
        public List<Notify> getUserNotifications(
                @PathVariable Long userId) {
            return notifyRepository.findByUserId(userId);
        }
    }
