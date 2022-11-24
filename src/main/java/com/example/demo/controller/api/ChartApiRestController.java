package com.example.demo.controller.api;

import com.example.demo.dto.ChartDTO;
import com.example.demo.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartApiRestController {

    @Autowired
    ChartService chartService;

    @GetMapping("/chart")
    public ChartDTO getPostCntByWriteDate() {
        return chartService.getPostCntByWriteDate();
    }
}
