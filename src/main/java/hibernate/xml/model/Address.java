package hibernate.xml.model;

import java.util.Objects;
import java.util.Set;

public class Address {

    private int idAddress;
    private String street;
    private City city;
    private Set<Company> companies;

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

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return idAddress == address.idAddress &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(companies, address.companies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, street, city, companies);
    }
}
