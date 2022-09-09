package com.example.thithuchanh.sevice.impl;

import com.example.thithuchanh.model.Province;
import com.example.thithuchanh.reponsitory.ProvinceRepository;
import com.example.thithuchanh.sevice.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Province save(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
provinceRepository.deleteById(id);
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Page<Province> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }
}
