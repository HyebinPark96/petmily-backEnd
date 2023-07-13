package com.example.demo.service;

import com.example.demo.common.UtilFunc;
import com.example.demo.dto.AnimalDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private static final String API_URL = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc";

    public ResponseEntity<List<AnimalDTO>> selectMissingAnimalList(AnimalDTO animalDTO) throws IOException, URISyntaxException, ParseException {
        UtilFunc util = new UtilFunc();
        String API_KEY = util.getApiKey();

        String url = API_URL;
        url += "/abandonmentPublic?_type=json&pageNo=" + animalDTO.getPageNo();
        url += "&numOfRows=" + animalDTO.getNumOfRows();
        url += "&serviceKey=" + API_KEY;

        URI uri = new URI(url);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String responseStr = response.getBody();

            List<AnimalDTO> animalList = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();

            // 파싱 로직 공통코드로 빼기
            // JSON 형태의 String을 JSON 객체로 파싱
//            JSONParser parser = new JSONParser();
//            JSONObject object = (JSONObject) parser.parse(responseStr);
//            JSONObject responseObject = (JSONObject) object.get("response");
//            JSONObject body = (JSONObject) responseObject.get("body");
//            JSONObject items = (JSONObject) body.get("items");
            JSONArray item = util.getResponse(responseStr);

            for (int i = 0; i < item.size(); i++) {
                JSONObject jsonObject = (JSONObject) item.get(i);
                AnimalDTO animal = objectMapper.convertValue(jsonObject, AnimalDTO.class);

                animalList.add(i, animal);
            }
            return ResponseEntity.ok(animalList);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
