package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;

public class XMLInfoWriter extends InfoWriter {
    public XMLInfoWriter() {
        outputFormat = "_INFO.xml";
        nameFormat = "<Name> %s </Name>";
        afmFormat = "<AFM> %d </AFM>";
        statusFormat = "<Status> %s </Status>";
        incomeFormat = "<Income> %s </Income>";
        receiptsFormat = "<Receipts>";
        receiptIdFormat = "<ReceiptID> %d </ReceiptID> ";
        dateFormat = "<Date> %s </Date>";
        kindFormat = "<Kind> %s </Kind>";
        amountFormat = "<Amount> %s </Amount>";
        companyFormat = "<Company> %s </Company>";
        countryFormat = "<Country> %s </Country>";
        cityFormat = "<City> %s </City>";
        streetFormat = "<Street> %s </Street>";
        numberFormat = "<Number> %d </Number>";
    }
}