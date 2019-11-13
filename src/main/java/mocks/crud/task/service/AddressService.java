package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//TODO is new throw class for AddressService needed?
public class AddressService implements CrudRepository<Long, Address> {
    public static final String NULL_ARG_THROW_MSG = "Arg is null.";
    public static final String NULL_ADDRESS_ID_THROW_MSG = "Id of Address arg is null.";
    public static final String EXIST_ID_THROW_MSG = "Address with current id is already exist.";
    public static final String EXIST_ADDRESS_THROW_MSG = "Address with current address is already exist.";

    private HashMap<Long, Address> addressMap;

    public AddressService()
    {
        addressMap = new HashMap<>();
    }

    /**
     *
     * @param address for check in repo
     * @return true, if element with current address is in repo, else false
     */
    private boolean isAddressExist(String address)
    {
        for(Address a: addressMap.values())
                if(a.getAddress().equals(address))
                    return true;
        return false;
    }

    private void checkElementArg(Address element)
    {
        if(element == null)
            throw new NullPointerException(NULL_ARG_THROW_MSG);

        if(element.getId() == null)
            throw new IllegalArgumentException(NULL_ADDRESS_ID_THROW_MSG);
    }

    /**
     *
     * @param element new element for repo
     */
    @Override
    public void save(Address element)
    {
        checkElementArg(element);

        if(addressMap.containsKey(element.getId()))
            throw new IllegalArgumentException(EXIST_ID_THROW_MSG);

        if(isAddressExist(element.getAddress()))
            throw new IllegalArgumentException(EXIST_ADDRESS_THROW_MSG);
        else
            addressMap.put(element.getId(), element);
    }

    /**
     *
     * @param id check repo for Address with current id
     * @return Address with current id
     */
    @Override
    public Address findById(Long id)
    {
        if(id == null)
            throw new NullPointerException(NULL_ARG_THROW_MSG);
        return addressMap.get(id);
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(addressMap.values());
    }

    /**
     *
     * @param element check repo for Address with id of element and update address
     * @return Address with id of element and new address
     */
    @Override
    public Address update(Address element)
    {
        checkElementArg(element);

        Address ret = findById(element.getId());//find cur Address in repo

        if(ret != null) {
            String address = element.getAddress();
            if(ret.getAddress().equals(address))
                return ret;

            if (!isAddressExist(address)) {
                ret.setAddress(address);
                return ret;
            }
            else
                throw new IllegalArgumentException(EXIST_ADDRESS_THROW_MSG);
        }
        return null;
    }

    /**
     *
     * @param element for delete from repo by id
     */
    @Override
    public void delete(Address element)
    {
        checkElementArg(element);

        addressMap.remove(element.getId());
    }
}
