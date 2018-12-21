package com.learn.aws.springboots3.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.learn.aws.springboots3.service.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/storage/")
public class RestS3Controller {

    @Autowired
    private AmazonService amazonService;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonService.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonService.deleteFileFromS3Bucket(fileUrl);
    }

    @GetMapping("/getFileList")
    public List<String> getFileList() {
        return this.amazonService.listFiles();
    }

}
