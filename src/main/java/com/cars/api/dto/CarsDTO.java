package com.cars.api.dto;

import com.cars.api.model.enums.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CarsDTO(
    @NotBlank(message = "Insira um nome válido") String nome,

    Model modelo,

    @NotBlank(message = "Insira um fabricante válido") String fabricante,

    @NotBlank(message = "Insira uma data no formato AAAA-MM-DD") String dataFabricacao,

    @Positive(message = "Insira um valor válido") double valor,

    @Min(value = 1900, message = "Insira um ano válido") @Max(value = 2023, message = "Este ano de fabricação é maior que o ano atual") int anoModelo) {
}