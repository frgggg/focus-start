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

    @Override
    public void save(Address element) {
        if(element != null)
            if(element.getId() != null)
                if(!addressMap.containsKey(element.getId()))
                    addressMap.put(element.getId(), element);
    }

    @Override
    public Address findById(Long id) {
        return addressMap.get(id);
    }

    @Override
    public List<Address> findAll() {
        return new ArrayList<>(addressMap.values());
    }

    @Override
    public Address update(Address element) {
        Address ret = null;
        if(element != null)
            if(element.getId() != null)
            {
                ret = findById(element.getId());
                if(ret != null)
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
