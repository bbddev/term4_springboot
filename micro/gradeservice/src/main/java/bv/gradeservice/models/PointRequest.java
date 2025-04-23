package bv.gradeservice.models;

import lombok.Data;

@Data
public class PointRequest {
    private Long userId;
    private Integer point;
}