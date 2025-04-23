package bv.gradeservice.services;

import bv.gradeservice.models.NotifyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notifyservice")
public interface NotifyClient {
    @PostMapping("/api/notify/send")
    void sendNotify(@RequestBody NotifyDTO notify);
}