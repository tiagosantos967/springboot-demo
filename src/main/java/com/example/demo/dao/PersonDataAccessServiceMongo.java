package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("mongoDao")
public class PersonDataAccessServiceMongo implements PersonDao {

    @Autowired
    private PersonMongoRepository personRepository;

    @Override
    public int insertPerson(Person person) {
        personRepository.save(person);

        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> selectPersonById(String id) {
        return personRepository.findById(id);
    }

    @Override
    public int deletePersonById(String id) {
        personRepository.deleteById(id);

        return 1;
    }

    @Override
    public int updatePersonById(String id, Person person) {
        personRepository.save(new Person(id, person.getName()));

        return 1;
    }
}
