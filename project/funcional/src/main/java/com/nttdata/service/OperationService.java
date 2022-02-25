package com.nttdata.service;

import java.util.List;

public interface OperationService {
    public void getPeople();

    public void getPersonById(Integer id);

    public void getAccount();

    public void getAccountById(Integer id);

    public void getAccountByPersonId(Integer Id);

    public List<Integer> getLengthLastNamePerson();

    public void getConcatPerson();

    public String concatName(String firstName,String lastName);

    public void getNumberAccountOrder();

    public void getAccountGroupingByPerson();

    public void getAccountSummaryByPerson(Integer id);

    public void getSumAccount();
}
