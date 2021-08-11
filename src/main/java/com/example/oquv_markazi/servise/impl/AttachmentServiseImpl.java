package com.example.oquv_markazi.servise.impl;

import com.example.oquv_markazi.entity.Attachment;
import com.example.oquv_markazi.repository.AttachmentRepository;
import com.example.oquv_markazi.servise.AttachmentServise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class AttachmentServiseImpl implements AttachmentServise {
    @Value("${upload.folder}")
    private String uploadPath;

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiseImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public void SaveAttachment(MultipartFile multipartFile) {
        Attachment attachment = new Attachment();
        attachment.setContentType(multipartFile.getContentType());
        attachment.setFileSize(multipartFile.getSize());
        attachment.setName(multipartFile.getOriginalFilename());
        attachment.setHashId(UUID.randomUUID().toString());
        attachment.setExtensions(getExtension(attachment.getName()));

        Date date = new Date();
        File uploadFolder = new File(String.format("%s/%d/%d/%d", this.uploadPath,
                1900+date.getYear(), 1+date.getMonth(), date.getDate()));

        if (!uploadFolder.exists()){
            uploadFolder.mkdirs();
        }

        System.out.println("uploadPath: "+uploadPath.toString());
        System.out.println("uploadFolder: "+uploadFolder.getAbsolutePath().toString());


        attachment.setUploadPath(String.format("upload/%d/%d/%d/%s.%s",
                1900 + date.getYear(),
                1 + date.getMonth(),
                date.getDate(),
                attachment.getHashId(),
                attachment.getExtensions()));
        attachmentRepository.save(attachment);

        File file = new File(uploadFolder.getAbsoluteFile(), String.format("%s.%s", attachment.getHashId(), attachment.getExtensions()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean deleteAttachment(String hashId) {
        try {
            Attachment post = attachmentRepository.findByHashId(hashId);
            File file = new File(String.format("%s/%s",this.uploadPath, post.getUploadPath()).substring(7));
            file.delete();
            attachmentRepository.delete(post);
            return  true;
        }catch (Exception e){

        }
        return  false;
    }

    public String getExtension(String fileName){
        String extension = null;
        if (fileName != null && !fileName.isEmpty()){
            int index = fileName.lastIndexOf(".");
            extension = fileName.substring(index+1);
        }
        return extension;
    }
}
