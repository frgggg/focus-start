package mocks.crud.task.service;

import mocks.crud.task.model.Address;

public class AddressServiceTestUtils {
    public static final Address NULL_ADDRESS;
    public static final Address NULL_ID_ADDRESS;

    static {
        NULL_ADDRESS = null;
        NULL_ID_ADDRESS = new Address(null, "NULL_ID_ADDRESS");
    }
}
