package mocks.crud.task.service;

import com.sun.istack.internal.NotNull;
import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddressService implements CrudRepository<Long, Address> {
    private HashMap<Long, Address> addressMap;

    public AddressService()
    {
        addressMap = new HashMap<>();
    }

    //check address in rep
    private boolean isAddressExist(String address)
    {
        String oldAddress;
        for(Address a: addressMap.values()) {
            oldAddress = a.getAddress();
            if(oldAddress == null) {
                if (address == null)
                    return true;
            }
            else
                if(oldAddress.equals(address))
                    return true;
        }
        return false;
    }

    /**
     *
     * @param element new element for repo
     * @throws NullPointerException if element is null
     * @throws IllegalArgumentException if id of element is null
     *                                     or element with current id is already exist
     *                                     or address of element is already exist
     */
    //TODO is new throws needed?
    @Override
    public void save(@NotNull Address element) throws NullPointerException, IllegalArgumentException
    {
        if(element == null)
            throw new NullPointerException("Element is null");

        if(element.getId() == null)
            throw new IllegalArgumentException("Id of element is null");

        if(addressMap.containsKey(element.getId()))
            throw new IllegalArgumentException("Element with current id is already exist");

        if(isAddressExist(element.getAddress()))
            addressMap.put(element.getId(), element);
        else
            throw new IllegalArgumentException("Element with current address is already exist");
    }

    /**
     *
     * @param id check repo for Address with current id
     * @throws NullPointerException if id is null
     * @return Address with current id
     */
    @Override
    public Address findById(@NotNull Long id) {
        if(id == null)
            throw new NullPointerException("Null id arg.");
        return addressMap.get(id);
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(addressMap.values());
    }

    /**
     *
     * @param element check repo for Address with id of element and update address
     * @throws NullPointerException if element is null
     * @throws IllegalArgumentException if id of element is null
     *                                     or new address of element is already exist in repo
     * @return Address with id of element and new address
     */
    @Override
    public Address update(@NotNull Address element) {
        if(element == null)
            throw new NullPointerException("Element is null");

        Long id = element.getId();
        if(id == null)
            throw new IllegalArgumentException("Id of element is null");

        Address ret = findById(id);//find cur Address in rep

        if(ret != null) {
            String address = element.getAddress();
            if(ret.getAddress().equals(address))
                return ret;

            if (!isAddressExist(address))
                ret.setAddress(address);
            else
                throw new IllegalArgumentException("Address with address of element is already exist");
        }
        return null;
    }

    /**
     *
     * @param element for delete from repo
     * @throws NullPointerException if element is null
     * @throws IllegalArgumentException if id of element is null
     */
    @Override
    public void delete(Address element) {
        if(element == null)
            throw new NullPointerException("Element is null");

        Long id = element.getId();
        if(id == null)
            throw new IllegalArgumentException("Id of element is null");

        addressMap.remove(id);
    }
}
