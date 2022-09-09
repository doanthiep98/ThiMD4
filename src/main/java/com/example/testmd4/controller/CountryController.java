package com.example.testmd4.controller;

import com.example.testmd4.service.ICityService;
import com.example.testmd4.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")@RequestMapping("city")
public class CityController {
    @Autowired
    private ICityService iCityService;

    @GetMapping
    private ResponseEntity<List<City>> display() {
        return new ResponseEntity<>(ICityService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> createProduct(@RequestBody City city) {
        return new ResponseEntity<>(ICityService.save(city), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<City> findById(@PathVariable("id") Long id) {
        Optional<City> city = ICityService.findById(id);
        if (city.isPresent()) {
            return new ResponseEntity<>(city.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    private ResponseEntity<City> update(@RequestBody City city) {
        Optional<City> optionalCity = ICityService.findById(city.getId());
        if (optionalCity.isPresent()) {
            return new ResponseEntity<>(ICityService.save(city), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<City> create(@RequestPart("city") City city)  {
        return new ResponseEntity<>(ICityService.save(city), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<City> delete(@PathVariable("id") Long id) {
        Optional<City> optionalCity = ICityService.findById(id);
        if (optionalCity.isPresent()) {
            ICityService.delete(id);
            return new ResponseEntity<>(optionalCity.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }}
