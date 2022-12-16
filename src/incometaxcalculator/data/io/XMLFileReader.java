package incometaxcalculator.data.io;

public class XMLFileReader extends FileReader {
  public XMLFileReader() { receiptIndex = 1; }
  protected boolean receiptIdExists(String values[]) {
    return values[0].equals("<ReceiptID>");
  }
  protected String buildFieldValue(String values) throws NullPointerException {
    String valueWithTail[] = values.split(" ", 2);
    String valueReversed[] = new StringBuilder(valueWithTail[1]).reverse().toString().trim()
            .split(" ", 2);
    return new StringBuilder(valueReversed[1]).reverse().toString();
  }
}
