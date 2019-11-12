package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static mocks.crud.task.service.AddressService.*;
import static mocks.crud.task.service.AddressServiceTestUtils.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AddressServiceTest {
    private AddressService addressService;
    @Before
    public void init() {
        addressService = new AddressService();
        addressService.save(OK_ADDRESS);
        addressService.save(ADDRESS_FOR_DELETE);
        addressService.save(ADDRESS_FOR_UPDATE);
    }

    @Rule
    public ExpectedException testException = ExpectedException.none();

    @Test
    public void saveTest()
    {
        //null arg element (Address)
        testException.expect(NullPointerException.class);
        testException.expectMessage(NULL_ARG_THROW_MSG);
        addressService.save(NULL_ADDRESS);
        testException = ExpectedException.none();

        //null id of arg element (Address)
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(NULL_ADDRESS_ID_THROW_MSG);
        addressService.save(NULL_ID_ADDRESS);
        testException = ExpectedException.none();

        //exist id of element (Address)
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(EXIST_ID_THROW_MSG);
        addressService.save(EXIST_ID_ADDRESS);
        testException = ExpectedException.none();

        //exist address of element (Address)
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(EXIST_ADDRESS_THROW_MSG);
        addressService.save(EXIST_ADDRESS_NOT_EXIST_ID);
        testException = ExpectedException.none();

        ArrayList<Address> sample = new ArrayList<>();
        sample.add(OK_ADDRESS);
        sample.add(ADDRESS_FOR_DELETE);
        sample.add(ADDRESS_FOR_UPDATE);
        assertEquals(sample, addressService.findAll());
        assertEquals(sample.size(), 333);
    }

    @Test
    public void deleteTest()
    {
        //null arg element (Address)
        testException.expect(NullPointerException.class);
        testException.expectMessage(NULL_ARG_THROW_MSG);
        addressService.delete(NULL_ADDRESS);
        testException = ExpectedException.none();

        //null id of arg element (Address)
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(NULL_ADDRESS_ID_THROW_MSG);
        addressService.delete(NULL_ID_ADDRESS);
        testException = ExpectedException.none();

        //set example list with OK_ADDRESS
        ArrayList<Address> sample = new ArrayList<>();
        sample.add(OK_ADDRESS);
        sample.add(ADDRESS_FOR_UPDATE);
        //delete OK_FOR_DELETE_ADDRESS from [OK_ADDRESS, ADDRESS_FOR_DELETE]
        addressService.delete(ADDRESS_FOR_DELETE);
        assertEquals(addressService.findAll(), sample);
    }

    @Test
    public void findByIdTest()
    {
        //null arg id
        testException.expect(NullPointerException.class);
        testException.expectMessage(NULL_ARG_THROW_MSG);
        addressService.findById(null);
        testException = ExpectedException.none();

        //no Address with NOT_EXIST_ID id in repo
        assertNull(addressService.findById(NOT_EXIST_ID));

        //find OK_ADDRESS
        assertEquals(addressService.findById(OK_ADDRESS_ID), OK_ADDRESS);
    }

    @Test
    public void updateTest()
    {
        //null arg Address
        testException.expect(NullPointerException.class);
        testException.expectMessage(NULL_ARG_THROW_MSG);
        addressService.update(NULL_ADDRESS);
        testException = ExpectedException.none();

        //null id of arg element (Address)
        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(NULL_ADDRESS_ID_THROW_MSG);
        addressService.update(NULL_ID_ADDRESS);
        testException = ExpectedException.none();

        testException.expect(IllegalArgumentException.class);
        testException.expectMessage(EXIST_ADDRESS_THROW_MSG);
        addressService.update(THROW_UPDATE_ADDRESS);
        testException = ExpectedException.none();

        assertNull(addressService.update(EXIST_ADDRESS_NOT_EXIST_ID));

        Address updateAddress = addressService.update(OK_UPDATE_ADDRESS);
        assertEquals(updateAddress.getId(), OK_UPDATE_ADDRESS_ID);
        assertEquals(updateAddress.getAddress(), OK_UPDATE_ADDRESS_ADDRESS);
    }
}