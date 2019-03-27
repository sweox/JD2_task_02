package hibernate.annotation.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private int idCompany;

    @Column(name = "name_company")
    private String nameCompany;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<CompanyEmployee> companyEmployees = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "company_address",
            joinColumns = @JoinColumn(name = "fid_company", referencedColumnName = "id_company"),
            inverseJoinColumns = @JoinColumn(name = "fid_address", referencedColumnName = "id_address"))
    private Set<Address> addresses = new HashSet<>();

    public Company() {
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Set<CompanyEmployee> getCompanyEmployees() {
        return companyEmployees;
    }

    public void setCompanyEmployees(Set<CompanyEmployee> companyEmployees) {
        this.companyEmployees = companyEmployees;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return idCompany == company.idCompany &&
                Objects.equals(nameCompany, company.nameCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompany, nameCompany);
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", nameCompany='" + nameCompany + '\'' +
                '}';
    }
}
