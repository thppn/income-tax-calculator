package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

public class XMLLogWriter extends LogWriter {
  public XMLLogWriter() {
    outputFormat = "%s_LOG.xml";
    nameFormat = "<Name> %s </Name>";
    afmFormat = "<AFM> %d </AFM>";
    statusFormat = "<Status> %s </Status>";
    incomeFormat = "<Income> %s </Income>";
    basicTaxFormat = "<BasicTax> %f </BasicTax>";
    taxIncreaseFormat = "<TaxIncrease> %f </TaxIncrease>";
    taxDecreaseFormat = "<TaxDecrease> %f </TaxDecrease>";
    totalTaxFormat = "<TotalTax> %f </TotalTax>";
    totalReceiptsGatheredFormat = "<Receipts> %d </Receipts>";
    entertainmentFormat = "<Entertainment> %f </Entertainment>";
    basicFormat = "<Basic> %f </Basic>";
    travelFormat = "<Travel> %f </Travel>";
    healthFormat = "<Health> %f </Health>";
    otherFormat = "<Other> %f </Other>";
  }
}
