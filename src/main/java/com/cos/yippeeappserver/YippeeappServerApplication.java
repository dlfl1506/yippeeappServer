package com.cos.yippeeappserver;

import com.cos.yippeeappserver.web.Yippeeapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class YippeeappServerApplication {

    public static void main(String[] args) {

        Yippeeapp app = new Yippeeapp();
        app.TextFieldEx();
        SpringApplication.run(YippeeappServerApplication.class, args);
    }
}
