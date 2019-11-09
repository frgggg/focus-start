package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static mocks.crud.task.service.AddressServiceTestUtils.*;
import static org.junit.Assert.*;

public class AddressServiceTest {
    private AddressService addressService;
    @Before
    public void init() {
        addressService = new AddressService();
        addressService.save(NULL_ADDRESS);
        addressService.save(NULL_ID_ADDRESS);
        addressService.save(OK_ADDRESS);
        addressService.save(EXIST_ID_ADDRESS);
        addressService.save(EXIST_ADDRESS_ADDRESS);
    }

    @Test
    public void addressServiceSaveAndFindAllTest() {
        ArrayList<Address> sample = new ArrayList<>();
        sample.add(OK_ADDRESS);
        assertEquals(sample, addressService.findAll());
    }

    @Test
    public void findByIdOkId()
    {
        assertEquals(addressService.findById(OK_ADDRESS_ID), OK_ADDRESS);
    }

    @Test
    public void findByIdNullId()
    {
        assertNull(addressService.findById(null));
    }

    @Test
    public void findByIdNotExistId()
    {
        assertNull(addressService.findById(OK_NOT_EXIST_ADDRESS_ID));
    }

    @Test
    public void updateNullAddress()
    {
        assertNull(addressService.update(null));
    }

    @Test
    public void updateNullIdAddress()
    {
        assertNull(addressService.update(NULL_ADDRESS));
    }

    @Test
    public void updateNotExistIdAddress()
    {
        assertNull(addressService.update(EXIST_ADDRESS_ADDRESS));
    }

    @Test
    public void updateOk()
    {
        addressService.save(new Address(OK_ADDRESS_ID_UPDATE, null));

        Address updateAddress = addressService.update(OK_ADDRESS_UPDATE);

        assertEquals(updateAddress.getId(), OK_ADDRESS_UPDATE.getId());
        assertEquals(updateAddress.getAddress(), OK_ADDRESS_UPDATE.getAddress());
    }
}