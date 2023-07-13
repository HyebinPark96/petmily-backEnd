package com.example.demo.controller.api;

import com.example.demo.dto.AnimalDTO;
import com.example.demo.service.AnimalService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

//    @GetMapping("/selectAnimalKindTree")
//    public ResponseEntity<List<KindDTO>> selectAnimalKindTree() throws ParseException, IOException, URISyntaxException {
//        UtilFunc util = new UtilFunc();
//        String API_KEY = util.getApiKey();
//
//        String url = API_URL + "/kind?up_kind_cd=417000&_type=json&serviceKey=" + API_KEY;
//        URI uri = new URI(url);
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            String responseStr = response.getBody();
//
//            List<KindDTO> kindDTOList = new ArrayList<>();
//
//            // JSON 형태의 String을 JSON 객체로 파싱
//            JSONParser parser = new JSONParser();
//            JSONObject object = (JSONObject) parser.parse(responseStr);
//            JSONObject responseObject = (JSONObject) object.get("response");
//            JSONObject body = (JSONObject) responseObject.get("body");
//            JSONObject items = (JSONObject) body.get("items");
//            JSONArray item = (JSONArray) items.get("item");
//            JSONObject test;
//
//            for (int i = 0; i < item.size(); i++) {
//                test = (JSONObject) item.get(i);
//                String kindCd = (String) test.get("kindCd");
//                String knm = (String) test.get("knm");
//
//                KindDTO kindDTO = new KindDTO();
//                kindDTO.setKindCd(kindCd);
//                kindDTO.setKnm(knm);
//                kindDTOList.add(i, kindDTO);
//            }
//            return ResponseEntity.ok(kindDTOList);
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }

    @GetMapping("/selectMissingAnimalList")
    public ResponseEntity<List<AnimalDTO>> selectMissingAnimalList(@ModelAttribute AnimalDTO animalDTO) throws ParseException, IOException, URISyntaxException {
        return animalService.selectMissingAnimalList(animalDTO);
    }

}
