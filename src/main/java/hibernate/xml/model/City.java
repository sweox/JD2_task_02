package hibernate.xml.model;

import java.util.Objects;

public class City {

    private int idCity;
    private String city;
    private Country country;

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
