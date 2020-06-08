package cn.org.dianjiu.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeeblogServerApplication {

    public static void main(String[] args) {
        //System.setProperty("cfg.env","local");
        SpringApplication.run(JeeblogServerApplication.class, args);
    }

}
