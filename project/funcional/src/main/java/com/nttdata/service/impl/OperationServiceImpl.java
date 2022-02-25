package com.nttdata.service.impl;

import com.nttdata.model.Account;
import com.nttdata.model.Person;
import com.nttdata.proxy.AccountProxy;
import com.nttdata.repository.PersonRepository;
import com.nttdata.service.OperationService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OperationServiceImpl implements OperationService {

    private PersonRepository personRepository;
    private AccountProxy accountProxy;

    public OperationServiceImpl(){
        this.personRepository=new PersonRepository();
        this.accountProxy=new AccountProxy();
    }
    @Override
    public void getPeople() {
        List<Person> people=personRepository.getAll();

        //clasica
       /* for (Person person:people){
            System.out.println(person);
        }*/

        //lamda 1
       // people.forEach(person-> System.out.println(person));

        //lamda 2
       /* int edad=Integer.parseInt("180");
        people.forEach(person->{
            System.out.print(person.getId()+" "+String.valueOf(edad)+" ");
            System.out.println(person.getLastName());
        });*/

        //lamda 3
        people.forEach(System.out::println);
    }

    @Override
    public void getPersonById(Integer id) {
        personRepository.getAll().stream()
                .filter(person -> person.getId().equals(id))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Override
    public void getAccount() {
        accountProxy.accountsGet().stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Override
    public void getAccountById(Integer id) {
        accountProxy.accountsGet().stream()
                .filter(person->person.getId().equals(id))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Override
    public void getAccountByPersonId(Integer id) {
        accountProxy.accountsGet().stream()
                .filter(account -> account.getPersonId().equals(id))
                .filter(account -> account.getDescriptionAccount().length()>11)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    @Override
    public List<Integer> getLengthLastNamePerson() {
        return personRepository.getAll().stream()
                .map(Person::getLastName)
                .map(String::length)
                .map(integer -> integer+1)
                .filter(integer -> integer>11)
                .collect(Collectors.toList());

    }

    @Override
    public void getConcatPerson() {
        personRepository.getAll().stream()
                .map(OperationServiceImpl::concatPerson)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    @Override
    public String concatName(String firstName, String lastName) {

        return String.join(" ",firstName,lastName);
    }

    public static String concatPerson(Person person){
        return  String.join(" ",person.getFirstName(),person.getLastName());
    }

    Comparator<Account> comparator=(Account a1,Account a2)->a1.getNumberAccount().compareTo(a2.getNumberAccount());
    @Override
    public void getNumberAccountOrder() {
        accountProxy.accountsGet().stream()
                .sorted(comparator)
                .map(OperationServiceImpl::getNumberAccountPersonId)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static String getNumberAccountPersonId(Account account){
        return String.join(" ",account.getPersonId().toString(),account.getNumberAccount());
    }

    @Override
    public void getAccountGroupingByPerson() {

    }

    @Override
    public void getAccountSummaryByPerson(Integer id) {

    }

    @Override
    public void getSumAccount() {

    }
}
