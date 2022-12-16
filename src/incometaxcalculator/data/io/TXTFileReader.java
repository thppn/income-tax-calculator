package incometaxcalculator.data.io;

public class TXTFileReader extends FileReader {
  public TXTFileReader() { receiptIndex = 2; }

  protected boolean receiptIdExists(String values[]) {
    return values[0].equals("Receipt") && values[1].equals("ID:");
  }
  protected String buildFieldValue(String fieldsLine) throws NullPointerException {
    String values[] = fieldsLine.split(" ", 2);
    values[1] = values[1].trim();
    return values[1];
  }
}