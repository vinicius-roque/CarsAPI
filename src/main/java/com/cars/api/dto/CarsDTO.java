package com.cars.api.dto;

import com.cars.api.model.Model;

public record CarsDTO(
    String nome,
    Model modelo,
    String fabricante,
    String dataFabricacao,
    double valor,
    int anoModelo) {
}