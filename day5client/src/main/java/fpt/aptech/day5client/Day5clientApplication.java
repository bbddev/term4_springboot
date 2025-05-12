package fpt.aptech.day5client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class Day5clientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day5clientApplication.class, args);
    }

}
