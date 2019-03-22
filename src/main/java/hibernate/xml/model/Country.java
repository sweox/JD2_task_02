package hibernate.xml.model;

import java.util.List;
import java.util.Objects;

public class Country {

    private int idCountry;
    private String country;

    private List<City> cities;

    public Country() {
    }

    public Country(int idCountry, String country) {
        this.idCountry = idCountry;
        this.country = country;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return idCountry == country1.idCountry &&
                Objects.equals(country, country1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry, country);
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", country='" + country + '\'' +
                ", cities=" + cities +
                '}';
    }
}
