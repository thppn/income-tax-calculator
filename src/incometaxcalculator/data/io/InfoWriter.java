package incometaxcalculator.data.io;

import incometaxcalculator.data.management.Receipt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InfoWriter extends FileWriter {
    protected String receiptsFormat;
    protected String receiptIdFormat;
    protected String dateFormat;
    protected String kindFormat;
    protected String amountFormat;
    protected String companyFormat;
    protected String countryFormat;
    protected String cityFormat;
    protected String streetFormat;
    protected String numberFormat;
    private void generateTaxpayerReceipts(int taxRegistrationNumber, PrintWriter outputStream) {

        HashMap<Integer, Receipt> receiptsHashMap = manager.getReceiptHashMap(taxRegistrationNumber);
        Iterator<HashMap.Entry<Integer, Receipt>> iterator = receiptsHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Receipt> entry = iterator.next();
            Receipt receipt = entry.getValue();
            outputStream.println(String.format(receiptIdFormat, receipt.getId()));
            outputStream.println(String.format(dateFormat, receipt.getIssueDate()));
            outputStream.println(String.format(kindFormat, receipt.getKind()));
            outputStream.println(String.format(amountFormat, receipt.getAmount()));
            outputStream.println(String.format(companyFormat, receipt.getCompany().getName()));
            outputStream.println(String.format(countryFormat, receipt.getCompany().getCountry()));
            outputStream.println(String.format(cityFormat, receipt.getCompany().getCity()));
            outputStream.println(String.format(streetFormat, receipt.getCompany().getStreet()));
            outputStream.println(String.format(numberFormat, receipt.getCompany().getNumber()));
            outputStream.println();
        }
    }
    public void generateFile(int taxRegistrationNumber) throws IOException {

        PrintWriter outputStream = new PrintWriter(
                new java.io.FileWriter(taxRegistrationNumber + outputFormat));
        outputStream.println(String.format(nameFormat, manager.getTaxpayerName(taxRegistrationNumber)));
        outputStream.println(String.format(afmFormat, taxRegistrationNumber));
        outputStream.println(String.format(statusFormat, manager.getTaxpayerStatus(taxRegistrationNumber)));
        outputStream.println(String.format(incomeFormat, manager.getTaxpayerIncome(taxRegistrationNumber)));
        outputStream.println();// den mas emfanize to \n se aplo notepad
        outputStream.println(String.format(receiptsFormat));
        outputStream.println();
        generateTaxpayerReceipts(taxRegistrationNumber, outputStream);
        outputStream.close();
    }

}
