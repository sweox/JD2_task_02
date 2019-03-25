package hibernate.annotation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city")
    private int idCity;

    @Column(name = "city")
    private String city;

    @ManyToOne()
    @JoinColumn(name = "fid_country")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    public City() {
    }

    public City(String city) {
        this.city = city;
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

    public void addAddress(Address address) {
        if (address == null ) {
            addresses = new ArrayList<>();
        }
        addresses.add(address);
        address.setCity(this);
    }

    public void removeAddress(Address address) {
        if(addresses != null) {
            addresses.remove(address);
            address.setCity(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city1 = (City) o;

        if (idCity != city1.idCity) return false;
        return Objects.equals(city, city1.city);
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", city='" + city + '\'' +
                '}';
    }
}
