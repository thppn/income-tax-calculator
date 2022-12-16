package tests;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import org.junit.jupiter.api.BeforeAll;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AddReceiptTest {

    static TaxpayerManager taxpayerManager = new TaxpayerManager();
    static int taxpayerRegistrationNumber = 123456789;

    @BeforeAll
    static void addTaxpayer() {
        try {
            taxpayerManager.loadTaxpayer("123456789_INFO.txt");
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Add a valid receipt
     */
    @org.junit.jupiter.api.Test
    void addNewValidReceipt() {
        int newReceiptId = 11;
        try {
            taxpayerManager.addReceipt(newReceiptId, "16/11/2022", (float) 6.66, "Basic", "UoI", "Greece","Ioannina", "Panepisthmiou", 1, taxpayerRegistrationNumber);
        } catch (Exception e) {
        }
        assertTrue(taxpayerManager.containsReceipt(newReceiptId));
    }
    /**
     * Add an invalid receipt
     */
//    @org.junit.jupiter.api.Test
//    void addInvalidReceipt() {}
}