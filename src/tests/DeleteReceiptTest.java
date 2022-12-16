package tests;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import org.junit.jupiter.api.BeforeAll;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DeleteReceiptTest {

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
     * Delete a valid receipt
     */
    @org.junit.jupiter.api.Test
    void DeleteValidReceipt() {
        int receiptId = 0;
        try {
            taxpayerManager.removeReceipt(receiptId);
        } catch (Exception e) {
        }
        assertFalse(taxpayerManager.containsReceipt(receiptId));
    }
    /**
     * Delete an invalid receipt
     */
//    @org.junit.jupiter.api.Test
//    void addInvalidReceipt() {}
}