package mocks.crud.task.service;

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

    @Override
    public void save(Address element) {
        if(element != null)
            if(element.getId() != null)
                if(!addressMap.containsKey(element.getId()))
                    if(!isAddressExist(element.getAddress()))
                        addressMap.put(element.getId(), element);
    }

    @Override
    public Address findById(Long id) {
        if(id == null)
            return null;
        return addressMap.get(id);
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(addressMap.values());
    }

    @Override
    public Address update(Address element) {
        Address ret = null;
        if(element != null)// not null
            if(element.getId() != null)//not null id
            {
                ret = findById(element.getId());//find cur Address in rep
                if(ret != null)
                    if(!isAddressExist(element.getAddress()))//can't update for existing val!!!
                        ret.setAddress(element.getAddress());
            }
        return ret;
    }

    @Override
    public void delete(Address element) {
        if(element != null)
            if(element.getId() != null)
                addressMap.remove(element.getId());
    }
}
