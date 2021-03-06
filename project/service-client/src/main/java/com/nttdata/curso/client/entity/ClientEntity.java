package com.nttdata.curso.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int documentType;

    private String documentNumber;

    private String name;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthday;
}
