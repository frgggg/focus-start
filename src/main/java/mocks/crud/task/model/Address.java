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
}
