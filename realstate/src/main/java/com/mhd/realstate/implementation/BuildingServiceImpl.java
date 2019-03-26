package com.mhd.realstate.implementation;

import com.mhd.realstate.entity.Buildings;
import com.mhd.realstate.repo.BuilldingRepo;
import com.mhd.realstate.service.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingsService {
    @Autowired
    private BuilldingRepo builldingRepo;

    @Override
    public List<Buildings> getBuildingsList() {
        return builldingRepo.findAll();
    }

    @Override
    public Buildings getBuildingById(long id) {
        return builldingRepo.getOne(id);
    }
}
