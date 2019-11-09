package mocks.crud.task.service;

import mocks.LogicConsumer;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.CrudRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static mocks.crud.task.service.PersonServiceTestUtils.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @Mock
    CrudRepository<Long, Person> mockPersonRepository;
    AddressService addressService;
    PersonService personService;

    @Before
    public  void init() {
        MockitoAnnotations.initMocks(this);
        personService = new PersonService(mockPersonRepository, addressService);
    }

    @Test
    public void findByIdTest() {
        when(mockPersonRepository.findById(FIND_BY_ID_PERSON_ID)).thenReturn(FIND_BY_ID_PERSON);
        Person person = personService.findById(FIND_BY_ID_PERSON_ID);
        assertEquals(person.getAge(), FIND_BY_ID_PERSON.getAge());
        assertEquals(person.getName(), FIND_BY_ID_PERSON.getName());
        assertEquals(person.getAddress().getId(), FIND_BY_ID_PERSON.getAddress().getId());
        assertEquals(person.getAddress().getAddress(), FIND_BY_ID_PERSON.getAddress().getAddress());

        when(mockPersonRepository.findById(FIND_BY_ID_NOT_EXIST_PERSON_ID)).thenReturn(null);
        person = personService.findById(FIND_BY_ID_NOT_EXIST_PERSON_ID);
        assertNull(person);

        when(mockPersonRepository.findById(null)).thenReturn(null);
        person = personService.findById(null);
        assertNull(person);

    }

    @Test
    public void findAllTest()
    {
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(FIND_ALL_ID_PERSON);
        when(mockPersonRepository.findAll()).thenReturn(allPersons);
        assertEquals(personService.findAll(), allPersons);
    }

    @Test
    public void updateTest()
    {
        when(mockPersonRepository.update(null)).thenReturn(null);
        assertNull(personService.update(null));

        Person nullNamePerson = new Person(null, 1, null);
        when(mockPersonRepository.update(nullNamePerson)).thenReturn(null);
        assertNull(personService.update(nullNamePerson));

        Person nullAgePerson = new Person("Test Name", null, null);
        when(mockPersonRepository.update(nullAgePerson)).thenReturn(null);
        assertNull(personService.update(nullAgePerson));
    }

    @Test
    public void findAllRelativesTest()
    {
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(PERSON_1);
        allPersons.add(PERSON_2);//PERSON_2_ADDRESS = PERSON_1_ADDRESS
        allPersons.add(PERSON_3);
        when(mockPersonRepository.findAll()).thenReturn(allPersons);

        //bad person params
        assertNull(personService.findAllRelatives(null));
        assertNull(personService.findAllRelatives(new Person(null, 1, null)));
        assertNull(personService.findAllRelatives(new Person(PERSON_1_NAME, null, null)));

        //no person in rep
        assertNull(personService.findAllRelatives(new Person(PERSON_4_NAME, PERSON_4_AGE, PERSON_4_ADDRESS)));

        //person in rep, but no relatives
        assertEquals(
                personService.findAllRelatives(new Person(PERSON_3_NAME, PERSON_3_AGE, PERSON_3_ADDRESS)),
                new ArrayList<Person>()
                );

        //OK findAllRelatives
        ArrayList<Person> allRelOfPERSON_1 = new ArrayList<>();
        allRelOfPERSON_1.add(PERSON_2);
        assertEquals(personService.findAllRelatives(PERSON_1), allRelOfPERSON_1);
    }

    @Test
    public void getAddressTest()
    {
        ArrayList<Person> allPersons = new ArrayList<>();
        allPersons.add(PERSON_1);
        allPersons.add(PERSON_2);
        allPersons.add(PERSON_3);
        when(mockPersonRepository.findAll()).thenReturn(allPersons);

        //bad person params
        assertNull(personService.getAddress(null));
        assertNull(personService.getAddress(new Person(null, 1, null)));
        assertNull(personService.getAddress(new Person(PERSON_1_NAME, null, null)));
        //no person in rep
        assertNull(personService.getAddress(new Person(PERSON_4_NAME, PERSON_4_AGE, PERSON_4_ADDRESS)));

        assertEquals(personService.getAddress(PERSON_2), PERSON_2_ADDRESS);
    }
}