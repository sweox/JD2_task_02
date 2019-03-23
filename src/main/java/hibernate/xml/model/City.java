package hibernate.xml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {

    private int idCity;
    private String city;
    private Country country;

    private List<Address> addresses;

    public City() {
    }

    public City(int idCity, String city, Country country) {
        this.idCity = idCity;
        this.city = city;
        this.country = country;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }
        addresses.add(address);

        address.setCity(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return idCity == city1.idCity &&
                Objects.equals(city, city1.city) &&
                Objects.equals(country, city1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, city, country);
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", city='" + city + '\'' +
                ", country=" + country +
                '}';
    }
}
