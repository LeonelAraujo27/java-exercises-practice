package com.nttdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaCorriente {
    private Integer id;
    private String nombre;
    private Integer numeroTarjeta;
    private String apellido;
    private String tipoCuenta;
    private Double saldo;
}
