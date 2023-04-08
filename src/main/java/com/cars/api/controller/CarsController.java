package com.cars.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cars.api.dto.CarsDTO;
import com.cars.api.model.Cars;
import com.cars.api.service.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarsController {

  @Autowired
  private CarService service;

  @PostMapping
  @ResponseStatus(value = HttpStatus.CREATED)
  public void createCar(@RequestBody @Valid CarsDTO req) {
    service.createCar(new Cars(req));
  }

  @GetMapping
  @ResponseStatus(value = HttpStatus.OK)
  public List<Cars> findAllCars() {
    return service.findAllCars();
  }

  @GetMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public Optional<Cars> findCarById(@PathVariable int id) {
    return service.findCarById(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public void deleteCar(@PathVariable int id) {
    service.deleteCar(id);
  }

  @PutMapping("/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  public void updateCar(@PathVariable int id, @RequestBody @Valid CarsDTO req) {
    service.updateCar(id, req);
  }
}