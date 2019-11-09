package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.AdvancedRepository;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonService implements  AdvancedRepository {

    private AddressService addressService;

    private CrudRepository<Long, Person> personRepository;

    public PersonService(CrudRepository<Long, Person> personRepository, AddressService addressService) {
        this.addressService = addressService;
        this.personRepository = personRepository;
    }

    //person must have name, age and exist in rep
    private boolean isCorrectPerson(Person person)
    {
        if(person == null)
            return false;
        if(person.getName() == null)
            return false;
        if(person.getAge() == null)
            return false;
        for(Person p: personRepository.findAll()) {
            if(p.getAge().equals(person.getAge()))
                if(p.getName().equals(person.getName()))
                    return true;
        }
        return false;
    }

    @Override
    public List<Person> findAllRelatives(Person person) {

        if(!isCorrectPerson(person))
            return null;


        List<Person> ret = new ArrayList<>();
        boolean idEquals, addressEquals;
        for(Person p: personRepository.findAll()) {
            if(person.getName().equals(p.getName()) && person.getAge().equals(p.getAge()))
                continue;//it's cur person
            if(person.getAddress() == null)
            {
                if(p.getAddress() == null)
                    ret.add(p);
            }
            else
            {
                idEquals = false;
                addressEquals = false;

                if(person.getAddress().getId() == null)
                {
                    if(p.getAddress().getId() == null)
                        idEquals = true;
                }
                else
                {
                    if(person.getAddress().getId().equals(p.getAddress().getId()))
                        idEquals = true;
                }

                if(person.getAddress().getAddress() == null)
                {
                    if(p.getAddress().getAddress() == null)
                        addressEquals = true;
                }
                else
                {
                    if(person.getAddress().getAddress().equals(p.getAddress().getAddress()))
                        addressEquals = true;
                }

                if(idEquals && addressEquals)
                    ret.add(p);
            }
        }

        return ret;
    }

    @Override
    public Address getAddress(Person person) {
        if(!isCorrectPerson(person))//check person
            return null;

        for(Person p: personRepository.findAll()) {
            if(p.getAge().equals(person.getAge()))
                if(p.getName().equals(person.getName()))//find person with cur name and age in repo
                    return p.getAddress();
        }

        return null;
    }

    public void save(Person element) {
        personRepository.save(element);
    }

    public Person findById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Person element) {
        return personRepository.update(element);
    }

    public void delete(Person element) {
        personRepository.delete(element);
    }
}
