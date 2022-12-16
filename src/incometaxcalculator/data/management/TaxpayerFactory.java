package incometaxcalculator.data.management;

import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

public class TaxpayerFactory {
    public static Taxpayer create(String fullname, int taxRegistrationNumber, String status,
                                  float income) throws WrongTaxpayerStatusException {
        switch(status) {
            case "Married Filing Jointly":
                return new MarriedFilingJointlyTaxpayer(fullname, taxRegistrationNumber, income);
            case "Married Filing Separately":
                return new MarriedFilingSeparatelyTaxpayer(fullname, taxRegistrationNumber, income);
            case "Single":
                return new SingleTaxpayer(fullname, taxRegistrationNumber, income);
            case "Head of Household":
                return new HeadOfHouseholdTaxpayer(fullname, taxRegistrationNumber, income);
            default:
                throw new WrongTaxpayerStatusException();
        }
    }
}
