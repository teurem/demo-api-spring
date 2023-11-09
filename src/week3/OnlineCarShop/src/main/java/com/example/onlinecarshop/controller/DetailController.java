package com.example.onlinecarshop.controller;

import com.example.onlinecarshop.dto.DetailDTO;
import com.example.onlinecarshop.entity.DetailEntity;
import com.example.onlinecarshop.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/{detailId}")
    public DetailDTO getDetailById(@PathVariable Long detailId) {
        DetailDTO detail = detailService.getDetailById(detailId);
        System.out.println("detailId: " +detailId+ "detail: " +detail);
        return detail;
    }

    @PostMapping
    public String saveDetail(@RequestBody DetailEntity detail) {
        detailService.saveDetail(detail);
        return "saved successfuly";
    }
}
