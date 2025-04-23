package bv.gradeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserGradeDTO {
    private Long id;
    private String name;
    private String email;
    private int point;
}
