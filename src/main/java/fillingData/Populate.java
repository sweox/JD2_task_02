package fillingData;

import fillingData.FillingTable.FillingAddress;
import fillingData.FillingTable.FillingCity;
import fillingData.FillingTable.FillingCompany;
import fillingData.FillingTable.FillingCompanyAddress;
import fillingData.FillingTable.FillingCompanyEmployee;
import fillingData.FillingTable.FillingCountry;
import fillingData.FillingTable.FillingEmployee;

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
