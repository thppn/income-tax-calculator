package tests;

import incometaxcalculator.data.management.TaxpayerManager;


import static org.junit.jupiter.api.Assertions.*;

class LoadTaxpayerTest {

    static TaxpayerManager taxpayerManager = new TaxpayerManager();
    /**
     * Read an invalid taxpayer
     */
    @org.junit.jupiter.api.Test
    void readInvalidTaxpayer() {
        int taxpayerRegistrationNumber = 987654321;
        String taxpayerFilename = taxpayerRegistrationNumber + "_OFNI.txt";
        try {
            taxpayerManager.loadTaxpayer(taxpayerFilename);
        } catch (Exception e) {
            assertTrue(true);
        }
        assertFalse(taxpayerManager.containsTaxpayer());
    }

    /**
     * Read a valid taxpayer from txt file
     */
    @org.junit.jupiter.api.Test
    void readValidTaxpayerTXT() {
        int taxpayerRegistrationNumber = 123456789;
        String taxpayerFilename = taxpayerRegistrationNumber + "_INFO.txt";
        try {
            taxpayerManager.loadTaxpayer(taxpayerFilename);
        } catch (Exception e) {
            fail();
        }
        assertTrue(taxpayerManager.containsTaxpayer(taxpayerRegistrationNumber));
    }
    /**
     * Read a valid taxpayer from xml file
     */
    @org.junit.jupiter.api.Test
    void readValidTaxpayerXML() {
        int taxpayerRegistrationNumber = 123456789;
        String taxpayerFilename = taxpayerRegistrationNumber + "_INFO.xml";
        try {
            taxpayerManager.loadTaxpayer(taxpayerFilename);
        } catch (Exception e) {
            fail();
        }
        assertTrue(taxpayerManager.containsTaxpayer(taxpayerRegistrationNumber));
    }

}