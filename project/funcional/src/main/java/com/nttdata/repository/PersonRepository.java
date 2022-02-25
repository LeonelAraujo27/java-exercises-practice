package com.nttdata.repository;

import com.nttdata.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    public List<Person> getAll(){
        List<Person> people=new ArrayList<>();
        people.add(new Person(1,"Chura Lopez","Jorge","123654785","789654"));
        people.add(new Person(2,"Mendes Quillcavilca","Maria","123654785","789654"));
        people.add(new Person(3,"Arias Lopez","Jesus","123654785","789654"));
        people.add(new Person(4,"Zavaleta Condemaita","Martin","123654785","789654"));

        return people;
    }
}
