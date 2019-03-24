package hibernate.xml.model;

import java.io.Serializable;
import java.util.Objects;

public class CompanyEmployee implements Serializable {

    private CompanyEmployeeMapping id;
    private String position;

    public CompanyEmployee() {
    }

    public CompanyEmployeeMapping getId() {
        return id;
    }

    public void setId(CompanyEmployeeMapping id) {
        this.id = id;
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return position != null ? position.equals(that.position) : that.position == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
