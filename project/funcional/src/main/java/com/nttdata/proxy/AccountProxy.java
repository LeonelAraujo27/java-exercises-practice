package com.nttdata.proxy;

import com.nttdata.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AccountProxy {
    public List<Account> accountsGet(){
        List<Account> accounts=new ArrayList<>();
        accounts.add(new Account(1,"123-4566321-9","Cuenta Free",1));
        accounts.add(new Account(2,"123-4566321-9","Cuenta Sueldo",1));
        accounts.add(new Account(3,"123-4566321-9","Cuenta Free",2));
        accounts.add(new Account(4,"123-4566321-9","Cuenta Clásica",3));
        accounts.add(new Account(5,"123-4566321-9","Cuenta Free",4));
        accounts.add(new Account(6,"123-4566321-9","Cuenta Clasica",4));
        accounts.add(new Account(7,"123-4566321-9","Cuenta Sueldo",4));

        return  accounts;
    }
}
