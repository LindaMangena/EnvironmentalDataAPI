package com.enviro.assessment.grad001.LindaMangena.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enviro.assessment.grad001.LindaMangena.models.FileData;
import com.enviro.assessment.grad001.LindaMangena.repositories.FileRepository;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public void processFile(MultipartFile file) {
        try {
            @SuppressWarnings("resource")
			String content = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

            FileData fileData = new FileData();
            fileData.setData(content);
            fileRepository.save(fileData);
        } catch (Exception e) {
            throw new RuntimeException("Error processing file", e);
        }
    }

    public String getResults() {
        return fileRepository.findAll()
                .stream()
                .map(FileData::getData)
                .collect(Collectors.joining("\n"));
    }
}