package tests;

import incometaxcalculator.data.management.TaxpayerManager;
import org.junit.jupiter.api.BeforeAll;



import static org.junit.jupiter.api.Assertions.*;

class DeleteTaxpayerTest {

    static TaxpayerManager taxpayerManager = new TaxpayerManager();

    @BeforeAll
    static void addTaxpayer() {
        try {
            taxpayerManager.loadTaxpayer("123456789_INFO.txt");
        } catch (Exception e) {
            fail();
        }
    }
    /**
     * Delete a valid taxpayer
     */
    @org.junit.jupiter.api.Test
    void DeleteValidTaxpayer() {
        int taxpayerRegistrationNumber = 123456789;
        taxpayerManager.removeTaxpayer(taxpayerRegistrationNumber);
        assertFalse(taxpayerManager.containsTaxpayer(taxpayerRegistrationNumber));
    }
    /**
     * Delete an invalid taxpayer
     */
//    @org.junit.jupiter.api.Test
//    void DeleteInvalidTaxpayer() {
//        int taxpayerRegistrationNumber = 987654321;
//        taxpayerManager.removeTaxpayer(taxpayerRegistrationNumber);
//        assertFalse(taxpayerManager.containsTaxpayer(taxpayerRegistrationNumber));
//    }


}