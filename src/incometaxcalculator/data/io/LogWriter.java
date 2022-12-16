package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;

public class LogWriter extends FileWriter {
    protected String basicTaxFormat;
    protected String taxIncreaseFormat;
    protected String taxDecreaseFormat;
    protected String totalTaxFormat;
    protected String totalReceiptsGatheredFormat;
    protected String entertainmentFormat;
    protected String basicFormat;
    protected String travelFormat;
    protected String healthFormat;
    protected String otherFormat;


    private static final short ENTERTAINMENT = 0;
    private static final short BASIC = 1;
    private static final short TRAVEL = 2;
    private static final short HEALTH = 3;
    private static final short OTHER = 4;

    public void generateFile(int taxRegistrationNumber) throws IOException {
        PrintWriter outputStream = new PrintWriter(
                new java.io.FileWriter(String.format(outputFormat, taxRegistrationNumber)));
        outputStream.println(String.format(nameFormat, manager.getTaxpayerName(taxRegistrationNumber)));
        outputStream.println(String.format(afmFormat, taxRegistrationNumber));
        outputStream.println(String.format(incomeFormat, manager.getTaxpayerIncome(taxRegistrationNumber)));
        outputStream.println(String.format(basicFormat, manager.getTaxpayerBasicTax(taxRegistrationNumber)));
        if (manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber) > 0) {
            outputStream
                    .println(String.format(taxIncreaseFormat, manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber)));
        } else {
            outputStream
                    .println(String.format(taxDecreaseFormat, manager.getTaxpayerVariationTaxOnReceipts(taxRegistrationNumber)));
        }
        outputStream.println(String.format(totalTaxFormat, manager.getTaxpayerTotalTax(taxRegistrationNumber)));
        outputStream.println(String.format(totalReceiptsGatheredFormat, manager.getTaxpayerTotalReceiptsGathered(taxRegistrationNumber)));
        outputStream.println(String.format(entertainmentFormat, manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, ENTERTAINMENT)));
        outputStream.println(String.format(basicFormat, manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, BASIC)));
        outputStream.println(String.format(travelFormat, manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, TRAVEL)));
        outputStream.println(String.format(healthFormat, manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, HEALTH)));
        outputStream.println(String.format(otherFormat, manager.getTaxpayerAmountOfReceiptKind(taxRegistrationNumber, OTHER)));
        outputStream.close();
    }

}
