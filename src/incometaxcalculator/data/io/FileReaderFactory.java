package incometaxcalculator.data.io;

import incometaxcalculator.exceptions.WrongFileEndingException;

public class FileReaderFactory {
    public static FileReader create(String fileFormat) throws WrongFileEndingException {
        switch(fileFormat) {
            case "xml":
                return new XMLFileReader();
            case "txt":
                return new TXTFileReader();
            default:
                throw new WrongFileEndingException();
        }
    }
}
