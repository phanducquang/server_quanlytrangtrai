package tk.giaiphapchannuoi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.giaiphapchannuoi.server.DTO.Settings;
import tk.giaiphapchannuoi.server.services.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/settings")
public class SettingsController {

    @Autowired
    PregnancyStatusService pregnancyStatusService;

    @Autowired
    BreedsService breedsService;

    @Autowired
    BreedingTypeService breedingTypeService;

    @Autowired
    HealthStatusService healthStatusService;

    @Autowired
    DiseasesService diseasesService;

    @Autowired
    FarmTypesService farmTypesService;

    @Autowired
    FoodTypeService foodTypeService;

    @Autowired
    FoodsService foodsService;

    @Autowired
    MedicineTypeService medicineTypeService;

    @Autowired
    MedicineUnitsService medicineUnitsService;

    @Autowired
    MedicinesService medicinesService;

    @Autowired
    PriceCodesService priceCodesService;

    @Autowired
    FootTypeService footTypeService;

    @Autowired
    GentialTypeService gentialTypeService;

    @Autowired
    IssuesService issuesService;

    @Autowired
    RoundsService roundsService;

    @Autowired
    StatusService statusService;

    @Autowired
    RolesService rolesService;

    @Autowired
    FoodUnitsService foodUnitsService;

    @Autowired
    MatingRolesService matingRolesService;

    @Autowired
    WarehouseTypeService warehouseTypeService;

    @Autowired
    RegenciesService regenciesService;

    @GetMapping(value = "/list")
    public Settings findAll(){
        Settings settings = new Settings();
        settings.setBreeds(breedsService.findall());
        settings.setPregnancyStatus(pregnancyStatusService.findall());
        settings.setBreedingType(breedingTypeService.findall());
        settings.setHealthStatus(healthStatusService.findall());
        settings.setDiseases(diseasesService.findall());
        settings.setFarmTypes(farmTypesService.findall());
        settings.setFoodType(foodTypeService.findall());
        settings.setFoods(foodsService.findall());
        settings.setMedicineType(medicineTypeService.findall());
        settings.setMedicineUnits(medicineUnitsService.findall());
        settings.setMedicines(medicinesService.findall());
        settings.setPriceCodes(priceCodesService.findall());
        settings.setFootType(footTypeService.findall());
        settings.setGentialType(gentialTypeService.findall());
        settings.setIssues(issuesService.findall());
        settings.setRounds(roundsService.findall());
        settings.setStatus(statusService.findall());
        settings.setRoles(rolesService.findall());
        settings.setFoodUnits(foodUnitsService.findall());
        settings.setMatingRoles(matingRolesService.findall());
        settings.setWarehouseTypes(warehouseTypeService.findall());
        settings.setRegencies(regenciesService.findall());
        return settings;
    }
}
