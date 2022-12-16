package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

public class TXTLogWriter extends LogWriter {
  public TXTLogWriter() {
    outputFormat = "%s_LOG.txt";
    nameFormat = "Name: %s";
    afmFormat = "AFM: %d";
    statusFormat = "Status: %s";
    incomeFormat = "Income: %s";
    basicTaxFormat = "Basic Tax: %f";
    taxIncreaseFormat = "Tax Increase: %f";
    taxDecreaseFormat = "Tax Decrease: %f";
    totalTaxFormat = "Total Tax: %f";
    totalReceiptsGatheredFormat = "TotalReceiptsGathered: %d";
    entertainmentFormat = "Entertainment: %f";
    basicFormat = "Basic: %f";
    travelFormat = "Travel: %f";
    healthFormat = "Health: %f";
    otherFormat = "Other: %f";
  }
}
