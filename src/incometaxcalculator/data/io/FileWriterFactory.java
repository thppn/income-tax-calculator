package incometaxcalculator.data.io;

import incometaxcalculator.exceptions.WrongFileFormatException;

import java.io.IOException;

public class FileWriterFactory {
    public static InfoWriter createInfo(String fileFormat) {
        switch(fileFormat) {
            case "xml":
                return new XMLInfoWriter();
            case "txt":
                return new TXTInfoWriter();
            default:
                return null;
        }
    }
    public static LogWriter createLog(String fileFormat) throws IOException, WrongFileFormatException {
        switch(fileFormat) {
            case "xml":
                return new XMLLogWriter();
            case "txt":
                return new TXTLogWriter();
            default:
                return null;
        }
    }
}
