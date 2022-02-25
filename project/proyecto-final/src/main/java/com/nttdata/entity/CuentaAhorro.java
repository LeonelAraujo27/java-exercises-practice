package com.nttdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaAhorro {
    private Integer id;
    private String propietario;
    private Integer numeroTarjeta;

    private String tipoCuenta;
    private Double saldo;
}
