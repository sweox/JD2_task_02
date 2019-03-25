package hibernate.annotation.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private int idAddress;

    @Column(name = "street")
    private String street;

    @ManyToOne()
    @JoinColumn(name = "fid_city")
    private City city;

    @ManyToMany(mappedBy = "addresses")
    private Set<Company> companies = new HashSet<>();





    public Address() {
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
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "idAddress=" + idAddress +
                ", street='" + street + '\'' +
                '}';
    }
}
