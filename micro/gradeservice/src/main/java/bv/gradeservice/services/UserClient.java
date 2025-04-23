package bv.gradeservice.services;

import bv.gradeservice.models.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice")
public interface UserClient {
    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable Long userId);
}
