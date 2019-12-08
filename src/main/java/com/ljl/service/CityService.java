package com.ljl.service;


import com.ljl.entity.City;

import java.util.List;

public interface CityService {
    void add(City city);

    List<City> queryAll();
}
