package fpt.aptech.day5server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Day5serverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day5serverApplication.class, args);
    }

}
