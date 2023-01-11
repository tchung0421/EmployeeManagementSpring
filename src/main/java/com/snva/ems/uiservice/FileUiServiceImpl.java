package com.snva.ems.uiservice;

import com.snva.ems.service.IFileService;
import com.snva.ems.util.ReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileUiServiceImpl implements IFileUiService {

    @Autowired
    ReadUtil readUtil;

    @Autowired
    IFileService fileService;

    /*public FileUiServiceImpl(){
        //readUtil= new ReadUtil();
        iFileService= new FileServiceImpl();
    }*/






    @Override
    public void processFile() throws IOException {
       String filePath= readUtil.readString("Please enter a file path","Error could not read the input ");
       // check if this file path exists
        File isValidPath= new File(filePath);
        if (isValidPath.exists()){
            String savePath= fileService.saveToFile(fileService.processFile(isValidPath));
            System.out.println("The file was created at  "+savePath);
        }else{
            System.out.println("The path "+filePath+" doeas not exist");
        }

    }
}
