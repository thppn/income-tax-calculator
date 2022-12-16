package incometaxcalculator.data.io;


import java.io.IOException;
import incometaxcalculator.data.management.TaxpayerManager;

public abstract class FileWriter {
  protected String outputFormat;
  protected String nameFormat;
  protected String afmFormat;
  protected String statusFormat;
  protected String incomeFormat;

  TaxpayerManager manager = new TaxpayerManager();

  public abstract void generateFile(int taxRegistrationNumber) throws IOException;
}