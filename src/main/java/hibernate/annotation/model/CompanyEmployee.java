package hibernate.annotation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "company_employee")
public class CompanyEmployee implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Company company;

    @Id
    @ManyToOne
    @JoinColumn
    private Employee employee;

    @Column(name = "position")
    private String position;

    public CompanyEmployee() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEmployee that = (CompanyEmployee) o;
        return Objects.equals(company, that.company) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, employee, position);
    }

    @Override
    public String toString() {
        return "CompanyEmployee{" +
                "company=" + company +
                ", employee=" + employee +
                ", position='" + position + '\'' +
                '}';
    }
}
