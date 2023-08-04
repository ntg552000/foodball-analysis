package com.fengshui.controller;

import com.fengshui.service.UpdateDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/test")
@RequiredArgsConstructor
public class TestController {

    final UpdateDataService updateDataService;

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createType() {
        updateDataService.callApiRealTimeData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
