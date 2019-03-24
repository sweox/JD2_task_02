package hibernate.xml.model;

import java.io.Serializable;
import java.util.Objects;

public class CompanyAddress implements Serializable {

    private Company company;
    private Address address;

    public CompanyAddress() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyAddress that = (CompanyAddress) o;
        return Objects.equals(company, that.company) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, address);
    }
}
