package incometaxcalculator.data.management;

public class MarriedFilingSeparatelyTaxpayer extends Taxpayer {

  public MarriedFilingSeparatelyTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    taxLimits = new double[][]{
            {18040,   0,        0.0535},
            {71680,   965.14,   0.0705},
            {90000,   4746.76,  0.0785},
            {127120,  6184.88,  0.0785},
            {0,       9098.80,  0.0985}
    };
  }
}