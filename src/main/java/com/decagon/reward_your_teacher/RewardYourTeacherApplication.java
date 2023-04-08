package com.decagon.reward_your_teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RewardYourTeacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardYourTeacherApplication.class, args);
    }

}
