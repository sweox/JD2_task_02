package hibernate.xml.model;

public class Address {

    private int idAddress;
    private String street;
    private City city;

    public Address() {
    }

    public Address(int idAddress, String street, City city) {
        this.idAddress = idAddress;
        this.street = street;
        this.city = city;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
