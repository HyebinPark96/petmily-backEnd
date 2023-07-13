package com.example.demo.common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

    public JSONArray getResponse(String responseStr) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(responseStr);
        JSONObject responseObject = (JSONObject) object.get("response");
        JSONObject body = (JSONObject) responseObject.get("body");
        JSONObject items = (JSONObject) body.get("items");
        return (JSONArray) items.get("item");
    }

}
