package com.jasonhuang.controller;

import com.jasonhuang.controller.impl.MainControllerImpl;
import com.jasonhuang.model.LottoTypeEnum;
import com.jasonhuang.model.Result;
import com.jasonhuang.service.RandomGeneratorService;
import com.jasonhuang.service.impl.RandomGeneratorServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "MainController", description = "This is responsible for give the status of application")
@RestController
@RequestMapping(value = "/test")
public class MainController implements MainControllerImpl {

    @GetMapping("/generateRandomNumbers")
    public Result retrieveResult(@RequestParam(name = "seed") int seed,
                                 @RequestParam(name = "lottoType") LottoTypeEnum lottoTypeEnum) {
        RandomGeneratorServiceImpl randomGeneratorService = new RandomGeneratorService();
        return randomGeneratorService.generateRandomNumbers(seed, lottoTypeEnum);
    }
}
