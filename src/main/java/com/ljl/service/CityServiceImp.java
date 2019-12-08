package com.ljl.service;


import com.ljl.dao.CityDao;
import com.ljl.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CityServiceImp implements CityService {
    @Autowired
    private CityDao cityDao;

    @Override
    public void add(City city) {
        city.setId(UUID.randomUUID().toString());
        cityDao.add(city);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<City> queryAll() {

        return cityDao.queryAll();
    }
}
