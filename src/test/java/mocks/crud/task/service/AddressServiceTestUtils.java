package mocks.crud.task.service;

import mocks.crud.task.model.Address;

public class AddressServiceTestUtils {
    public static final Address NULL_ADDRESS;
    public static final Address NULL_ID_ADDRESS;

    public static final Long OK_ADDRESS_ID;
    public static final String OK_ADDRESS_ADDRESS = "OK_ADDRESS";
    public static final Address OK_ADDRESS;

    public static final Long EXIST_ID_ADDRESS_ID;
    public static final Address EXIST_ID_ADDRESS;

    public static final Long NOT_EXIST_ID;
    public static final Address EXIST_ADDRESS_NOT_EXIST_ID;

    public static final Long ADDRESS_FOR_DELETE_ID;
    public static final Address ADDRESS_FOR_DELETE;

    public static final Long ADDRESS_FOR_UPDATE_ID;
    public static final String ADDRESS_FOR_UPDATE_ADDRESS = "ADDRESS_FOR_UPDATE";
    public static final Address ADDRESS_FOR_UPDATE;

    public static final Long THROW_UPDATE_ADDRESS_ID;
    public static final Address THROW_UPDATE_ADDRESS;

    public static final Long OK_UPDATE_ADDRESS_ID;
    public static final String OK_UPDATE_ADDRESS_ADDRESS = "ADDRES_AFTER_UPDATE";
    public static final Address OK_UPDATE_ADDRESS;

    static {
        NULL_ADDRESS = null;
        NULL_ID_ADDRESS = new Address(null, "NULL_ID_ADDRESS");

        OK_ADDRESS_ID = 1l;
        OK_ADDRESS = new Address(OK_ADDRESS_ID, OK_ADDRESS_ADDRESS);

        EXIST_ID_ADDRESS_ID = OK_ADDRESS_ID;
        EXIST_ID_ADDRESS = new Address(EXIST_ID_ADDRESS_ID, "EXIST_ID_ADDRESS");

        NOT_EXIST_ID = 2l;
        EXIST_ADDRESS_NOT_EXIST_ID = new Address(NOT_EXIST_ID, "OK_ADDRESS");

        ADDRESS_FOR_DELETE_ID = 3l;
        ADDRESS_FOR_DELETE = new Address(ADDRESS_FOR_DELETE_ID, "OK_FOR_DELETE_ADDRESS");

        ADDRESS_FOR_UPDATE_ID = 4l;
        ADDRESS_FOR_UPDATE = new Address(ADDRESS_FOR_UPDATE_ID, ADDRESS_FOR_UPDATE_ADDRESS);

        THROW_UPDATE_ADDRESS_ID = ADDRESS_FOR_UPDATE_ID;
        THROW_UPDATE_ADDRESS = new Address(THROW_UPDATE_ADDRESS_ID, OK_ADDRESS_ADDRESS);

        OK_UPDATE_ADDRESS_ID = ADDRESS_FOR_UPDATE_ID;
        OK_UPDATE_ADDRESS = new Address(OK_UPDATE_ADDRESS_ID, OK_UPDATE_ADDRESS_ADDRESS);
    }
}
