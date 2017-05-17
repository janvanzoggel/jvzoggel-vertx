package io.vertx;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application
{
    @Bean
    public Vertx vertxBean(){
        return Vertx.vertx();
    }

    @Autowired
    private MyFirstVerticle myFirstVerticle;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(myFirstVerticle);
      }
}