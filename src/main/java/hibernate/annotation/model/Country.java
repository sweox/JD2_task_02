package hibernate.annotation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private int idCountry;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country() {
    }

    public Country(String country) {
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

    public void addCity(City city) {
        if(cities == null) {
            cities = new ArrayList<>();
        }
        cities.add(city);
        city.setCountry(this);
    }

    public void removeCity(City city) {
        if(cities != null) {
            cities.remove(city);
            city.setCountry(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country1 = (Country) o;

        if (idCountry != country1.idCountry) return false;
        return Objects.equals(country, country1.country);
    }

    @Override
    public int hashCode() {
        int result = idCountry;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", country='" + country + '\'' +
                '}';
    }
}
