package mocks.crud.task.model;

public class Address {

    private Long id;
    private String address;

    void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Address(Long id, String address)
    {
        this.id = id;
        this.address = address;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Address address = (Address) o;
        if(!getAddress().equals(address.getAddress()))
            return false;
        if(getId().equals(address.getId()))
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        Long id = getId();
        String address = getAddress();
        return ((address == null)?0:address.hashCode()) + Long.hashCode(id);
    }*/
}
