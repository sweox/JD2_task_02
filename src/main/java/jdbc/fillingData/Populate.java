package jdbc.fillingData;

import jdbc.fillingData.FillingTable.FillingAddress;
import jdbc.fillingData.FillingTable.FillingCity;
import jdbc.fillingData.FillingTable.FillingCompany;
import jdbc.fillingData.FillingTable.FillingCompanyAddress;
import jdbc.fillingData.FillingTable.FillingCompanyEmployee;
import jdbc.fillingData.FillingTable.FillingCountry;
import jdbc.fillingData.FillingTable.FillingEmployee;

public class Populate {
    public static void main(String[] args) {
        new FillingCountry().fill();
        new FillingCity().fill();
        new FillingCompany().fill();
        new FillingAddress().fill();
        new FillingEmployee().fill();
        new FillingCompanyEmployee().fill();
        new FillingCompanyAddress().fill();
    }
}
