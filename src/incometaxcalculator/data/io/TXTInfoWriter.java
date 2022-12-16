package incometaxcalculator.data.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import incometaxcalculator.data.management.Receipt;

public class TXTInfoWriter extends InfoWriter {
    public TXTInfoWriter() {
        outputFormat = "_INFO.txt";
        nameFormat = "Name: %s";
        afmFormat = "AFM: %d";
        statusFormat = "Status: %s";
        incomeFormat = "Income: %s";
        receiptsFormat = "Receipts:";
        receiptIdFormat = "Receipt ID: %d";
        dateFormat = "Date: %s";
        kindFormat = "Kind: %s";
        amountFormat = "Amount: %s";
        companyFormat = "Company: %s";
        countryFormat = "Country: %s";
        cityFormat = "City: %s";
        streetFormat = "Street: %s";
        numberFormat = "Number: %d";
    }
}