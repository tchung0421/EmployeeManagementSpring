package com.snva.ems.service;

import com.snva.ems.bean.CallSummary;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IFileService {

    List<CallSummary> processFile(File path) throws IOException;

    String saveToFile(List<CallSummary> processFile) throws IOException;
}
