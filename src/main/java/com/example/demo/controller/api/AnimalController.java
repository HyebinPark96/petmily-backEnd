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

    @GetMapping("/selectMissingAnimalList")
    public ResponseEntity<List<AnimalDTO>> selectMissingAnimalList(@ModelAttribute AnimalDTO animalDTO) throws ParseException, IOException, URISyntaxException {
        return animalService.selectMissingAnimalList(animalDTO);
    }

}
