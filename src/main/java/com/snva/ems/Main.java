package com.snva.ems;

import com.snva.ems.config.EmployeeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(EmployeeConfig.class);
        applicationContext.refresh();
        BufferedReader bufferedReader = (BufferedReader) applicationContext.getBean("reader");
        Runner runner = (Runner) applicationContext.getBean("runner");
        runner.checkUserOptions();
    }
}