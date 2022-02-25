package com.nttdata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoBancario {
    private Integer id;
    private Date fechaMovimiento;
    private Double saldoInicial;
    private Double saldoFinal;
    private Double retiro;
    private Double deposito;


}
