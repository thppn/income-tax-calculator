package incometaxcalculator.data.management;

public class MarriedFilingJointlyTaxpayer extends Taxpayer {

  public MarriedFilingJointlyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    taxLimits = new double[][]{
            {36080,   0,        0.0535},
            {90000,   1930.28,  0.0705},
            {122110,  5731.64,  0.0705},
            {254240,  9492.82,  0.0785},
            {0,       18197.69, 0.0985}
    };
  }
}