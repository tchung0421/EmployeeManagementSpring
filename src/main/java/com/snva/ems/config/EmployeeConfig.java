package com.snva.ems.config;

import com.snva.ems.Runner;
import com.snva.ems.bean.Employee;
import com.snva.ems.service.EmployeeServiceImpl;
import com.snva.ems.service.FileServiceImpl;
import com.snva.ems.uiservice.EmployeeUIServiceImpl;
import com.snva.ems.uiservice.FileUiServiceImpl;
import com.snva.ems.uiservice.IFileUiService;
import com.snva.ems.util.ReadUtil;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeConfig {

    @Bean(name="reader")
    public BufferedReader getBufferedReader(){
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    @Bean(name="readUtil")
    public ReadUtil getReadUtil(){
        return new ReadUtil();
    }

    @Bean(name="fileService")
    public FileServiceImpl getFileService(){
        return new FileServiceImpl();
    }

    @Bean(name="fileUiService")
    public FileUiServiceImpl getFileUiService(){
        return new FileUiServiceImpl();
    }

    @Bean(name="employeeUiService")
    public EmployeeUIServiceImpl getEmployeeUiService(){
        return new EmployeeUIServiceImpl();
    }

    @Bean(name="employeeService")
    public EmployeeServiceImpl getEmployeeService(){
        return new EmployeeServiceImpl();
    }
    @Bean(name="employeeList")
    public List<Employee> getEmployees(){
        return new ArrayList<Employee>();
    }

    @Bean(name="runner")
    public Runner getRunner(){
        return new Runner();
    }
}
