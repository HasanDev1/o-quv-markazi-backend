package com.example.oquv_markazi.servise;

import com.example.oquv_markazi.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentServise {
    public void SaveAttachment(MultipartFile multipartFile);
    public boolean deleteAttachment(String hashId);

}
