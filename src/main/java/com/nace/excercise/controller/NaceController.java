package com.nace.excercise.controller;

import com.nace.excercise.dto.NaceDataDto;
import com.nace.excercise.entity.NaceData;
import com.nace.excercise.service.NaceDataService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/nace")
@Slf4j
public class NaceController {

    @Autowired
    private NaceDataService naceDataService;

    @PostMapping(path = "/create", consumes = "application/json", produces = "application/json" )
    @ResponseStatus(HttpStatus.CREATED)
    public NaceData create(@Valid @RequestBody NaceDataDto request) {

        log.info("Controller ...");
        return naceDataService.create(naceDataService.convertFromDto(request));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<NaceData>> getAll() {

        return ResponseEntity.ok(naceDataService.retrieveAll());
    }

    @GetMapping(path = "/get/{orderNumber}")
    public ResponseEntity<NaceData> getByOrderNumber(@PathVariable("orderNumber") Long orderNumber) {

        return ResponseEntity.ok(naceDataService.findByOrderNumber(orderNumber));
    }
}
