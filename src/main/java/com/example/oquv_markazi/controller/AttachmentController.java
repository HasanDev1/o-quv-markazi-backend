package com.example.oquv_markazi.controller;


import com.example.oquv_markazi.entity.Attachment;
import com.example.oquv_markazi.model.Result;
import com.example.oquv_markazi.repository.AttachmentRepository;
import com.example.oquv_markazi.servise.AttachmentServise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api")
public class AttachmentController {
    @Value("${upload.folder}")
    private String uploadFolder;

    private final AttachmentServise attachmentServise;
    private final AttachmentRepository attachmentRepository;

    public AttachmentController(AttachmentServise attaachmentServise, AttachmentRepository attachmentRepository) {
        this.attachmentServise = attaachmentServise;
        this.attachmentRepository = attachmentRepository;
    }

    @PostMapping("/saveAttachment")
    public void savePost(@RequestParam(name = "file") MultipartFile multipartFile){
        attachmentServise.SaveAttachment(multipartFile);
    }

    @GetMapping("/preview/{hashId}")
    public ResponseEntity preview(@PathVariable String hashId) throws MalformedURLException {
        Attachment file = attachmentRepository.findByHashId(hashId);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; fileName=\""+ URLEncoder.encode(file.getName()))
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(new FileUrlResource(String.format("%s/%s",
                        uploadFolder,
                        file.getUploadPath())));
    }

    @GetMapping("/download/{hashId}")
    public ResponseEntity download(@PathVariable String hashId) throws MalformedURLException {
        Attachment file = attachmentRepository.findByHashId(hashId);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+ URLEncoder.encode(file.getName()))
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(new FileUrlResource(String.format("%s/%s",
                        uploadFolder,
                        file.getUploadPath())));
    }

    @DeleteMapping("/delete/{hashId}")
    public ResponseEntity delete(@PathVariable String hashId) throws MalformedURLException {
        boolean isDelete = attachmentServise.deleteAttachment(hashId);
        if (!isDelete){
            return new ResponseEntity(new Result(false, "not deleted"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(new Result(true,"deleted"));
    }
}
