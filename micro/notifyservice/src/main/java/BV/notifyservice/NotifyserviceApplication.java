package BV.notifyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotifyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifyserviceApplication.class, args);
	}

}
