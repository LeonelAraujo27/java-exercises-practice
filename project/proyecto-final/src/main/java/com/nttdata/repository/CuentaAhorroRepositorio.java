package com.nttdata.repository;

import com.nttdata.entity.CuentaAhorro;

import java.util.ArrayList;
import java.util.List;

public class CuentaAhorroRepositorio {

    List<CuentaAhorro> obtenerTodo(){
        List<CuentaAhorro> cuentaAhorros=new ArrayList<>();
       cuentaAhorros.add(new CuentaAhorro(1,"lione araujo",123654,"ahorro",2000.00));
       cuentaAhorros.add(new CuentaAhorro(2,"leydi neira",456321,"ahorro",2000.00));
       cuentaAhorros.add(new CuentaAhorro(3,"yensi sandoval",7412,"ahorro",2000.00));
       cuentaAhorros.add(new CuentaAhorro(4,"rosmmell huaman",96325,"ahorro",2000.00));
       cuentaAhorros.add(new CuentaAhorro(5,"Andres ospina",85621,"ahorro",2000.00));
       return cuentaAhorros;
    }
}
