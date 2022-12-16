package tests;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileFormatException;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaveDataTest {

    static TaxpayerManager taxpayerManager = new TaxpayerManager();
    static int taxpayerRegistrationNumber = 123456789;

    @BeforeAll
    static void addTaxpayer() {
        try {
            taxpayerManager.loadTaxpayer("123456789_INFO.txt");
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    /**
     * Save TXT log
     */
    @org.junit.jupiter.api.Test
    void saveDataTXT() {
        try {
            taxpayerManager.saveLogFile(taxpayerRegistrationNumber, "txt");
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    /**
     * Save XML log
     */
    @org.junit.jupiter.api.Test
    void saveDataXML() {
        try {
            taxpayerManager.saveLogFile(taxpayerRegistrationNumber, "xml");
        } catch (Exception e) {
            fail(e.toString());
        }
    }
}