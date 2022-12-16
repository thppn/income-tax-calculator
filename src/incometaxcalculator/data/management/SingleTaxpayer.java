package incometaxcalculator.data.management;

public class SingleTaxpayer extends Taxpayer {

  public SingleTaxpayer(String fullname, int taxRegistrationNumber, float income) {
    super(fullname, taxRegistrationNumber, income);
    taxLimits = new double[][]{
            {24680,   0,        0.0535},
            {81080,   1320.38,  0.0705},
            {90000,   5296.58,  0.0785},
            {152540,  5996.80,  0.0785},
            {0,       10906.19, 0.0985}
    };
  }
}