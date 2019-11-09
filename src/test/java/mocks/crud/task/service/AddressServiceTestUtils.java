package mocks.crud.task.service;

import mocks.crud.task.model.Address;

public class AddressServiceTestUtils {
    public static final Address NULL_ADDRESS;
    public static final Address NULL_ID_ADDRESS;

    public static final Long OK_ADDRESS_ID;
    public static final Address OK_ADDRESS;

    public static final Address EXIST_ID_ADDRESS;

    public static final Long OK_NOT_EXIST_ADDRESS_ID;
    public static final Address EXIST_ADDRESS_ADDRESS;

    public static final Long OK_ADDRESS_ID_UPDATE;
    public static final Address OK_ADDRESS_UPDATE;

    static {
        NULL_ADDRESS = null;
        NULL_ID_ADDRESS = new Address(null, "NULL_ID_ADDRESS");

        OK_ADDRESS_ID = 1l;
        OK_ADDRESS = new Address(OK_ADDRESS_ID, "OK_ADDRESS");

        EXIST_ID_ADDRESS = new Address(OK_ADDRESS_ID, "EXIST_ID_ADDRESS");

        OK_NOT_EXIST_ADDRESS_ID = 2l;
        EXIST_ADDRESS_ADDRESS = new Address(OK_NOT_EXIST_ADDRESS_ID, "OK_ADDRESS");

        OK_ADDRESS_ID_UPDATE = 3l;
        OK_ADDRESS_UPDATE = new Address(OK_ADDRESS_ID_UPDATE, "OK_ADDRESS_UPDATE");
    }
}
