package hibernate.xml.model;

import java.util.Objects;

public class Company {

    private int idCompany;
    private String nameCompany;

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
}
