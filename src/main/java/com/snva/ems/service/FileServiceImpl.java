package com.snva.ems.service;

import com.snva.ems.bean.CallSummary;
import com.snva.ems.util.ReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    ReadUtil readUtil;



    /*public FileServiceImpl(){
        reader = new ReadUtil();
    }*/
    /**
     * @param path
     * @return
     */
    @Override
    public List<CallSummary> processFile(File path) throws IOException {
        List<CallSummary> callSummaryList = new ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(path.getAbsolutePath()), Charset.defaultCharset());
        allLines.forEach(x->{
            if (isValidLine(x)){
               CallSummary summary= buildCallSummary(x);
                if (summary!=null){
                    callSummaryList.add(summary);
                }
            }
        });
        return callSummaryList;
    }

    /**
     * @param processFile
     * @return
     */
    @Override
    public String saveToFile(List<CallSummary> processFile)  {
        StringBuffer stringBuffer= new StringBuffer();
        String savePath = readUtil.readString("Please enter the path where you want to save ","error");
        File file = new File(savePath);
        if (file.isDirectory()){
            processFile.forEach(x->{
                stringBuffer.append(x.toString());
            });

            try{
                Files.write(Paths.get(file.getAbsolutePath()+"\\"+ LocalDate.now()),stringBuffer.toString().getBytes() );
            }catch (Exception e){
                return "The file was not saved due to "+e.getMessage();
            }
        }

        return "The output file is saved at "+file.getAbsolutePath();
    }

    private CallSummary buildCallSummary(String x) {
        CallSummary callSummary=null;
        String [] cols = x.split("\\s+");
        if (cols.length==8){
            callSummary  = new CallSummary();
            callSummary.setSrNo(cols[0]);
            callSummary.setExt(cols[1]);
            callSummary.setJun(cols[2]);
            callSummary.setDirectoryNo(cols[3]);
            callSummary.setDate(cols[4]);
            callSummary.setTime(cols[5]);
            callSummary.setDuration(cols[6]);
            callSummary.setBillAmt(cols[7]);
        }
        // we will a few more cases later
        return callSummary;
    }

    private boolean isValidLine(String x) {
        try{
            Integer.parseInt(x.split("\\s+")[0]);
            return true;
        }catch (NumberFormatException nFe){
            return false;
        }
        catch (Exception nFe){
            return false;
        }
    }
}
