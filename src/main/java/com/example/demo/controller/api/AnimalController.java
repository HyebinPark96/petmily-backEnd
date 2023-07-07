package com.example.demo.controller.api;

import com.example.demo.common.UtilFunc;
import com.example.demo.dto.ResponseDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    private static final String API_URL = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/kind";

    @GetMapping("/selectMissingAnimalList")
    public ResponseEntity<List<ResponseDTO>> selectMissingAnimalList() throws ParseException, IOException, URISyntaxException {
        UtilFunc util = new UtilFunc();
        String API_KEY = util.getApiKey();

        String url = API_URL + "?up_kind_cd=417000&_type=json&serviceKey=" + API_KEY;
        URI uri = new URI(url);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseStr = response.getBody();

            List<ResponseDTO> responseDTOList = new ArrayList<>();

            // JSON 형태의 String을 JSON 객체로 파싱
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(responseStr);
            JSONObject responseObject = (JSONObject) object.get("response");
            JSONObject body = (JSONObject) responseObject.get("body");
            JSONObject items = (JSONObject) body.get("items");
            JSONArray item = (JSONArray) items.get("item");
            JSONObject test;

            for (int i = 0; i < item.size(); i++) {
                test = (JSONObject) item.get(i);
                String kindCd = (String) test.get("kindCd");
                String knm = (String) test.get("knm");

                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setKindCd(kindCd);
                responseDTO.setKnm(knm);
                responseDTOList.add(i, responseDTO);
            }
            return ResponseEntity.ok(responseDTOList);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
