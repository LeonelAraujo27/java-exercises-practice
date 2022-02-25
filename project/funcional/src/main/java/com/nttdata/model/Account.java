package com.nttdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Integer id;

    private String numberAccount;

    private String descriptionAccount;

    private Integer personId;
}
