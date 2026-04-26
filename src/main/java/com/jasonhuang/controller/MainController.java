package com.jasonhuang.controller;

import com.jasonhuang.controller.impl.MainControllerImpl;
import com.jasonhuang.model.LottoTypeEnum;
import com.jasonhuang.model.Result;
import com.jasonhuang.service.RandomGeneratorService;
import com.jasonhuang.service.impl.RandomGeneratorServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "MainController", description = "This is responsible for give the status of application")
@RestController
@RequestMapping(value = "/test")
public class MainController implements MainControllerImpl {

    private final RandomGeneratorServiceImpl randomGeneratorService;

    public MainController(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @GetMapping("/generateRandomNumbers")
    public Result retrieveResult(@RequestParam(name = "lottoType") LottoTypeEnum lottoTypeEnum) {
        return randomGeneratorService.generateRandomNumbers(lottoTypeEnum);
    }
}