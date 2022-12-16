package incometaxcalculator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import incometaxcalculator.data.management.Receipt;
import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.ReceiptAlreadyExistsException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;

public class ReceiptData extends JFrame {
    private JPanel contentPane;

    public ReceiptData(Receipt receipt) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(200, 100, 450, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtpnId = new JTextPane();
        txtpnId.setEditable(false);
        txtpnId.setText("Receipt ID:");
        txtpnId.setBounds(10, 34, 92, 20);
        contentPane.add(txtpnId);

        JTextPane txtpnDate = new JTextPane();
        txtpnDate.setEditable(false);
        txtpnDate.setText("Date: ");
        txtpnDate.setBounds(10, 65, 92, 20);
        contentPane.add(txtpnDate);

        JTextPane txtpnKind = new JTextPane();
        txtpnKind.setEditable(false);
        txtpnKind.setText("Kind :");
        txtpnKind.setBounds(10, 96, 92, 20);
        contentPane.add(txtpnKind);

        JTextPane txtpnAmount = new JTextPane();
        txtpnAmount.setEditable(false);
        txtpnAmount.setText("Amount :");
        txtpnAmount.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnAmount);

        JTextPane txtpnCompany = new JTextPane();
        txtpnCompany.setEditable(false);
        txtpnCompany.setText("Amount :");
        txtpnCompany.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnCompany);

        JTextPane txtpnCountry = new JTextPane();
        txtpnCountry.setEditable(false);
        txtpnCountry.setText("Amount :");
        txtpnCountry.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnCountry);

        JTextPane txtpnCity = new JTextPane();
        txtpnCity.setEditable(false);
        txtpnCity.setText("Amount :");
        txtpnCity.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnCity);

        JTextPane txtpnStreet = new JTextPane();
        txtpnStreet.setEditable(false);
        txtpnStreet.setText("Amount :");
        txtpnStreet.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnStreet);

        JTextPane txtpnNumber = new JTextPane();
        txtpnNumber.setEditable(false);
        txtpnNumber.setText("Amount :");
        txtpnNumber.setBounds(10, 127, 92, 20);
        contentPane.add(txtpnNumber);

        JTextArea receiptId = new JTextArea();
        receiptId.setFont(new Font("Tahoma", Font.PLAIN, 11));
        receiptId.setEditable(false);
        receiptId.setBounds(110, 34, 213, 20);
        receiptId.setText(String.valueOf(receipt.getId()));
        contentPane.add(receiptId);

        JTextArea receiptDate = new JTextArea();
        receiptDate.setFont(new Font("Tahoma", Font.PLAIN, 11));
        receiptDate.setEditable(false);
        receiptDate.setBounds(110, 65, 213, 20);
        receiptDate.setText(receipt.getIssueDate());
        contentPane.add(receiptDate);

        JTextArea receiptKind = new JTextArea();
        receiptKind.setFont(new Font("Tahoma", Font.PLAIN, 11));
        receiptKind.setEditable(false);
        receiptKind.setBounds(110, 96, 213, 20);
        receiptKind.setText(receipt.getKind());
        contentPane.add(receiptKind);

        JTextArea receiptAmount = new JTextArea();
        receiptAmount.setFont(new Font("Tahoma", Font.PLAIN, 11));
        receiptAmount.setEditable(false);
        receiptAmount.setBounds(112, 127, 213, 20);
        receiptAmount.setText(String.valueOf(receipt.getAmount()));
        contentPane.add(receiptAmount);

        JTextArea receiptCompany = new JTextArea();
        receiptCompany.setFont(new Font("Tahoma", Font.PLAIN, 11));
        receiptCompany.setEditable(false);
        receiptCompany.setBounds(112, 127, 213, 20);
        receiptCompany.setText(String.valueOf(receipt.getCompany().getName()));
        contentPane.add(receiptCompany);

        JTextArea companyCountry = new JTextArea();
        companyCountry.setFont(new Font("Tahoma", Font.PLAIN, 11));
        companyCountry.setEditable(false);
        companyCountry.setBounds(112, 127, 213, 20);
        companyCountry.setText(String.valueOf(receipt.getCompany().getCountry()));
        contentPane.add(companyCountry);

        JTextArea companyCity = new JTextArea();
        companyCity.setFont(new Font("Tahoma", Font.PLAIN, 11));
        companyCity.setEditable(false);
        companyCity.setBounds(112, 127, 213, 20);
        companyCity.setText(String.valueOf(receipt.getCompany().getCity()));
        contentPane.add(companyCity);

        JTextArea companyStreet = new JTextArea();
        companyStreet.setFont(new Font("Tahoma", Font.PLAIN, 11));
        companyStreet.setEditable(false);
        companyStreet.setBounds(112, 127, 213, 20);
        companyStreet.setText(String.valueOf(receipt.getCompany().getStreet()));
        contentPane.add(companyStreet);

        JTextArea companyNumber = new JTextArea();
        companyNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
        companyNumber.setEditable(false);
        companyNumber.setBounds(112, 127, 213, 20);
        companyNumber.setText(String.valueOf(receipt.getCompany().getNumber()));
        contentPane.add(companyNumber);
    }
}