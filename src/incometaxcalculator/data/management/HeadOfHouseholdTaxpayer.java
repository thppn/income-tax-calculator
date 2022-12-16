package incometaxcalculator.data.management;

import java.util.HashMap;

public class HeadOfHouseholdTaxpayer extends Taxpayer {

  public HeadOfHouseholdTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    taxLimits = new double[][]{
            {30390,   0,        0.0535},
            {90000,   1625.87,  0.0705},
            {122110,  5828.38,  0.0705},
            {203390,  8092.13,  0.0785},
            {0,       14472.61, 0.0985}
    };
  }
}
