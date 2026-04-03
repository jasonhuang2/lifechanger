package com.jasonhuang.controller;

import com.jasonhuang.controller.impl.MainControllerImpl;
import com.jasonhuang.model.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "MainController", description = "This is responsible for give the status of application")
@RestController
@RequestMapping(value = "/test")
public class MainController implements MainControllerImpl {

    @GetMapping
    @ResponseBody
    public Result retrieveResult(@RequestParam(name = "seed") int seed) {
        return new Result(UUID.randomUUID(), List.of(1));
    }
}
