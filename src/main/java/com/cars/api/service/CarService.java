package com.cars.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.api.dto.CarsDTO;
import com.cars.api.model.Cars;
import com.cars.api.repository.CarsRepository;

@Service
public class CarService {

  @Autowired
  private CarsRepository repository;

  public void createCar(Cars req) {
    repository.save(req);

  }

  public List<Cars> findAllCars() {
    return repository.findAll();

  }

  public Optional<Cars> findCarById(int id) {
    return repository.findById(id);
  }

  public void deleteCar(int id) {
    repository.deleteById(id);
  }

  public void updateCar(int id, CarsDTO req) {
    repository.findById(id).map(car -> {
      car.setNome(req.nome());
      car.setModelo(req.modelo());
      car.setFabricante(req.fabricante());
      car.setDataFabricacao(req.dataFabricacao());
      car.setValor(req.valor());
      car.setAnoModelo(req.anoModelo());
      return repository.save(car);
    });
  }
}
