package com.softuni.petselect.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    public String uploadImage(MultipartFile multipartFile) throws IOException;
}
