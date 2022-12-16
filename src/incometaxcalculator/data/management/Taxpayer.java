package incometaxcalculator.data.management;

import java.util.HashMap;

import incometaxcalculator.exceptions.WrongReceiptKindException;

public abstract class Taxpayer {

  protected final String fullname;
  protected final int taxRegistrationNumber;
  protected final float income;

  protected double[][] taxLimits;
  private float amountPerReceiptsKind[] = new float[5];
  private int totalReceiptsGathered = 0;
  private HashMap<Integer, Receipt> receiptHashMap = new HashMap<Integer, Receipt>(0);

  private static final String receiptKind[] = {"Entertainment", "Basic", "Travel", "Health", "Other"};

  public double calculateBasicTax() {
    for (int i = 0; i < 4; i++)
      if (taxLimits[i][0] > income)
        return taxLimits[i][1] + taxLimits[i][2] * (income - (i == 0 ? 0 : taxLimits[i - 1][0]));
    return taxLimits[4][1] + taxLimits[4][2] * (income - taxLimits[3][0]);
  }

  protected Taxpayer(String fullname, int taxRegistrationNumber, float income) {
    this.fullname = fullname;
    this.taxRegistrationNumber = taxRegistrationNumber;
    this.income = income;
  }

  public void addReceipt(Receipt receipt) throws WrongReceiptKindException {
    for(int i=0;i<5;i++) {
      if (receipt.getKind().equals(receiptKind[i])) {
        amountPerReceiptsKind[i] += receipt.getAmount();
        receiptHashMap.put(receipt.getId(), receipt);
        totalReceiptsGathered++;
        return;
      }
    }
    throw new WrongReceiptKindException();
  }

  public void removeReceipt(int receiptId) throws WrongReceiptKindException {
    Receipt receipt = receiptHashMap.get(receiptId);
    for(int i=0;i<5;i++) {
      if (receipt.getKind().equals(receiptKind[i])) {
        amountPerReceiptsKind[i] += receipt.getAmount();
        totalReceiptsGathered--;
        receiptHashMap.remove(receiptId);
        return;
      }
    }
    throw new WrongReceiptKindException();
  }

  public String getFullname() {
    return fullname;
  }

  public int getTaxRegistrationNumber() {
    return taxRegistrationNumber;
  }

  public float getIncome() {
    return income;
  }

  public HashMap<Integer, Receipt> getReceiptHashMap() {
    return receiptHashMap;
  }

  public double getVariationTaxOnReceipts() {
    float totalAmountOfReceipts = getTotalAmountOfReceipts();
    double taxRemission;
    if (totalAmountOfReceipts < 0.2 * income) {
      taxRemission = 0.08;
    } else if (totalAmountOfReceipts < 0.4 * income) {
      taxRemission = 0.04;
    } else if (totalAmountOfReceipts < 0.6 * income) {
      taxRemission = -0.15;
    } else {
      taxRemission = -0.3;
    }
    return calculateBasicTax() * taxRemission;
  }

  private float getTotalAmountOfReceipts() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      sum += amountPerReceiptsKind[i];
    }
    return sum;
  }

  public int getTotalReceiptsGathered() {
    return totalReceiptsGathered;
  }

  public float getAmountOfReceiptKind(short kind) {
    return amountPerReceiptsKind[kind];
  }

  public double getTotalTax() {
    return calculateBasicTax() + getVariationTaxOnReceipts();
  }

  public double getBasicTax() {
    return calculateBasicTax();
  }

}