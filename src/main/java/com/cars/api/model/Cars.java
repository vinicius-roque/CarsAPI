package com.cars.api.model;

import com.cars.api.dto.CarsDTO;
import com.cars.api.model.enums.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cars {
  public Cars(CarsDTO req) {
    this.nome = req.nome();
    this.modelo = req.modelo();
    this.fabricante = req.fabricante();
    this.dataFabricacao = req.dataFabricacao();
    this.valor = req.valor();
    this.anoModelo = req.anoModelo();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(length = 50, nullable = false)
  private String nome;

  @Column(nullable = false)
  private Model modelo;

  @Column(nullable = false)
  private String fabricante;

  @Column(nullable = false)
  private String dataFabricacao;

  @Column(nullable = false)
  private double valor;

  @Column(nullable = false)
  private int anoModelo;
}