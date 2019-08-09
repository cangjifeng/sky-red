package org.jerfan.red;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyRedApplication {

    /**
     * http://localhost:8080/start
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(SkyRedApplication.class, args);
    }

}
