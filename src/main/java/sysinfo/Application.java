package sysinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sysinfo.repository.PenjualanEventHandler;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    PenjualanEventHandler penjualanEventHandler() {
        return new PenjualanEventHandler();
    }

}
