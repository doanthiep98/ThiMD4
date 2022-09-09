package com.example.testmd4.controller;

import com.example.testmd4.model.Province;
import com.example.testmd4.sevice.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private IProvinceService iProvinceService;
    @GetMapping
    private ResponseEntity<List<Province>> display() {
        return new ResponseEntity<>(iProvinceService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    private ResponseEntity<Province> findById(@PathVariable("id") Long id) {
        Optional<Province> province = iProvinceService.findById(id);
        if (province.isPresent()) {
            return new ResponseEntity<>(province.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Province> update(@RequestBody Province province) {
        Optional<Province> optionalProvince = iProvinceService.findById(province.getId());
        if (optionalProvince.isPresent()) {
            return new ResponseEntity<>(iProvinceService.save(province), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Province> create(@RequestBody Province province)  {
        return new ResponseEntity<>(iProvinceService.save(province), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Province> delete(@PathVariable("id") Long id) {
        Optional<Province> optionalProduct = iProvinceService.findById(id);
        if (optionalProduct.isPresent()) {
            iProvinceService.delete(id);
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}}
