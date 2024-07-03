package com.bee.and.more.beeapi.api.controller;

import com.bee.and.more.beeapi.api.model.Bee;
import com.bee.and.more.beeapi.service.BeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BeeController {

    private final BeeService beeService;

    @Autowired
    public BeeController(BeeService beeService) {
        this.beeService = beeService;
    }

    @GetMapping
    public Bee getBee(@RequestParam UUID id){
        return beeService.getBeeById(id);
    }
}
