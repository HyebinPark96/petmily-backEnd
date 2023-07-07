package com.example.demo.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UtilFunc {

    // API KEY 저장된 텍스트 파일 불러오기
    public String getApiKey() throws IOException {
        ClassPathResource file = new ClassPathResource("apiKey.txt");
        byte[] bytes = FileCopyUtils.copyToByteArray(file.getFile());
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
