package hibernate.xml.model;

import java.io.Serializable;

public class CompanyEmployeeMapping implements Serializable {
    private Company company;
    private Employee employee;

    public CompanyEmployeeMapping() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyEmployeeMapping that = (CompanyEmployeeMapping) o;

        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        return employee != null ? employee.equals(that.employee) : that.employee == null;
    }

    @Override
    public int hashCode() {
        int result = company != null ? company.hashCode() : 0;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
