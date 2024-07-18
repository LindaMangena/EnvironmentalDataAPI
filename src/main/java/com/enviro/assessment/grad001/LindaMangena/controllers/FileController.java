package com.enviro.assessment.grad001.LindaMangena.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.enviro.assessment.grad001.LindaMangena.services.FileService;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.processFile(file);
        return ResponseEntity.ok("File uploaded successfully");
    }

    @GetMapping("/results")
    public ResponseEntity<String> getResults() {
        String results = fileService.getResults();
        return ResponseEntity.ok(results);
    }
}