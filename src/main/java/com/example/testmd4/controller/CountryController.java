package com.example.testmd4.controller;

import com.example.testmd4.model.Country;
import com.example.testmd4.sevice.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ICountryService iCountryService;

    @GetMapping("/listContry")
    private ResponseEntity<List<Country>> display() {

        return new ResponseEntity<>(iCountryService.findAll(), HttpStatus.OK);
    }
}
