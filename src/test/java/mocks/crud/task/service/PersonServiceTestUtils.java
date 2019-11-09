package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;

public class PersonServiceTestUtils {
    public static final Address FIND_BY_ID_PERSON_ADDRESS;
    public static final String FIND_BY_ID_PERSON_NAME = "FIND_BY_ID_PERSON_NAME";
    public static final Integer FIND_BY_ID_PERSON_AGE;
    public static final Long FIND_BY_ID_PERSON_ID;
    public static final Person FIND_BY_ID_PERSON;

    public static final Long FIND_BY_ID_NOT_EXIST_PERSON_ID;

    public static final Address FIND_ALL_ID_PERSON_ADDRESS;
    public static final String FIND_ALL_ID_PERSON_NAME = "FIND_ALL_ID_PERSON_NAME";
    public static final Integer FIND_ALL_ID_PERSON_AGE;
    public static final Long FIND_ALL_ID_PERSON_ID;
    public static final Person FIND_ALL_ID_PERSON;

    public static final Address PERSON_1_ADDRESS;
    public static final String PERSON_1_NAME = "PERSON_1_NAME";
    public static final Integer PERSON_1_AGE;
    public static final Long PERSON_1_ID;
    public static final Person PERSON_1;

    public static final Address PERSON_2_ADDRESS;
    public static final String PERSON_2_NAME = "PERSON_2_NAME";
    public static final Integer PERSON_2_AGE;
    public static final Long PERSON_2_ID;
    public static final Person PERSON_2;

    public static final Address PERSON_3_ADDRESS;
    public static final String PERSON_3_NAME = "PERSON_3_NAME";
    public static final Integer PERSON_3_AGE;
    public static final Long PERSON_3_ID;
    public static final Person PERSON_3;

    public static final Address PERSON_4_ADDRESS;
    public static final String PERSON_4_NAME = "PERSON_4_NAME";
    public static final Integer PERSON_4_AGE;

    static
    {
        FIND_BY_ID_PERSON_ID = 1l;
        FIND_BY_ID_PERSON_AGE = 1;
        FIND_BY_ID_PERSON_ADDRESS = new Address(1l, "address 1");
        FIND_BY_ID_PERSON = new Person(FIND_BY_ID_PERSON_NAME, FIND_BY_ID_PERSON_AGE, FIND_BY_ID_PERSON_ADDRESS);

        FIND_BY_ID_NOT_EXIST_PERSON_ID = 2l;

        FIND_ALL_ID_PERSON_ID = 3l;
        FIND_ALL_ID_PERSON_AGE = 3;
        FIND_ALL_ID_PERSON_ADDRESS = new Address(3l, "address 3");
        FIND_ALL_ID_PERSON = new Person(FIND_ALL_ID_PERSON_NAME, FIND_ALL_ID_PERSON_AGE, FIND_ALL_ID_PERSON_ADDRESS);

        PERSON_1_ID = 1l;
        PERSON_1_AGE = 1;
        PERSON_1_ADDRESS = new Address(1l, "PERSON_1_ADDRESS");
        PERSON_1 = new Person(PERSON_1_NAME, PERSON_1_AGE, PERSON_1_ADDRESS);

        PERSON_2_ID = 2l;
        PERSON_2_AGE = 2;
        PERSON_2_ADDRESS = PERSON_1_ADDRESS;//new Address(2l, "PERSON_2_ADDRESS");
        PERSON_2 = new Person(PERSON_2_NAME, PERSON_2_AGE, PERSON_2_ADDRESS);

        PERSON_3_ID = 3l;
        PERSON_3_AGE = 3;
        PERSON_3_ADDRESS = new Address(3l, "PERSON_3_ADDRESS");
        PERSON_3 = new Person(PERSON_3_NAME, PERSON_3_AGE, PERSON_3_ADDRESS);

        PERSON_4_AGE = 4;
        PERSON_4_ADDRESS = new Address(4l, "PERSON_4_ADDRESS");
    }
}
