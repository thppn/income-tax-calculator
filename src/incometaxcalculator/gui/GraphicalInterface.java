package incometaxcalculator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import incometaxcalculator.data.management.TaxpayerManager;
import incometaxcalculator.exceptions.WrongFileEndingException;
import incometaxcalculator.exceptions.WrongFileFormatException;
import incometaxcalculator.exceptions.WrongReceiptDateException;
import incometaxcalculator.exceptions.WrongReceiptKindException;
import incometaxcalculator.exceptions.WrongTaxpayerStatusException;

public class
GraphicalInterface extends JFrame {

  private JPanel contentPane;
  private TaxpayerManager taxpayerManager = new TaxpayerManager();
  private String taxpayersTRN = new String();
  private JTextField txtTaxRegistrationNumber;
  private static GraphicalInterface frame;

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          frame = new GraphicalInterface();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  public GraphicalInterface() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 500);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(204, 204, 204));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e2) {
      e2.printStackTrace();
    }

    JTextPane textPane = new JTextPane();
    textPane.setEditable(false);
    textPane.setBackground(new Color(153, 204, 204));
    textPane.setBounds(0, 21, 433, 441);

    JPanel fileLoaderPanel = new JPanel(new BorderLayout());
    JPanel boxPanel = new JPanel(new BorderLayout());
    JPanel taxRegistrationNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
    JLabel TRN = new JLabel("Give the tax registration number:");
    JTextField taxRegistrationNumberField = new JTextField(20);
    taxRegistrationNumberPanel.add(TRN);
    taxRegistrationNumberPanel.add(taxRegistrationNumberField);
    JPanel loadPanel = new JPanel(new GridLayout(1, 2));
    loadPanel.add(taxRegistrationNumberPanel);
    fileLoaderPanel.add(boxPanel, BorderLayout.NORTH);
    fileLoaderPanel.add(loadPanel, BorderLayout.CENTER);
    JCheckBox txtBox = new JCheckBox("Txt file");
    JCheckBox xmlBox = new JCheckBox("Xml file");

    txtBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        xmlBox.setSelected(false);
      }
    });

    xmlBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        txtBox.setSelected(false);
      }
    });
    txtBox.doClick();
    boxPanel.add(txtBox, BorderLayout.WEST);
    boxPanel.add(xmlBox, BorderLayout.EAST);

    DefaultListModel<String> taxRegisterNumberModel = new DefaultListModel<String>();

    JList<String> taxRegisterNumberList = new JList<String>(taxRegisterNumberModel);
    taxRegisterNumberList.setBackground(new Color(153, 204, 204));
    taxRegisterNumberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    taxRegisterNumberList.setSelectedIndex(0);
    taxRegisterNumberList.setVisibleRowCount(3);

    JScrollPane taxRegisterNumberListScrollPane = new JScrollPane(taxRegisterNumberList);
    taxRegisterNumberListScrollPane.setSize(300, 300);
    taxRegisterNumberListScrollPane.setLocation(70, 100);
    contentPane.add(taxRegisterNumberListScrollPane);

    JButton btnLoadTaxpayer = new JButton("Load Taxpayer");
    btnLoadTaxpayer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("info files",  "txt", "xml"));

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = fileChooser.getSelectedFile();
          String[] filePathList = selectedFile.getAbsolutePath().split("\\\\");
          String taxRegistrationNumberFile = filePathList[filePathList.length-1];
          String taxRegistrationNumber = taxRegistrationNumberFile.split("_")[0];
          try {
            int trn = Integer.parseInt(taxRegistrationNumber);

            if (taxpayerManager.containsTaxpayer(trn)) {
              JOptionPane.showMessageDialog(null, "This taxpayer is already loaded.");
            } else {
              taxpayerManager.loadTaxpayer(taxRegistrationNumberFile);
              taxRegisterNumberModel.addElement(taxRegistrationNumber);
            }
            // textPane.setText(taxpayersTRN);
          } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null,
                    "The tax registration number must have only digits.");
          } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "The file doesn't exists.");
          } catch (WrongFileFormatException e1) {
            JOptionPane.showMessageDialog(null, "Please check your file format and try again.");
          } catch (WrongFileEndingException e1) {
            JOptionPane.showMessageDialog(null, "Please check your file ending and try again.");
          } catch (WrongTaxpayerStatusException e1) {
            JOptionPane.showMessageDialog(null, "Please check taxpayer's status and try again.");
          } catch (WrongReceiptKindException e1) {
            JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
          } catch (WrongReceiptDateException e1) {
            JOptionPane.showMessageDialog(null,
                    "Please make sure your date is " + "DD/MM/YYYY and try again.");
          }

        }
      }
    });
    btnLoadTaxpayer.setBounds(0, 0, 146, 23);
    contentPane.add(btnLoadTaxpayer);
//
//    JButton btnSelectTaxpayer = new JButton("Load Folder");
//    btnSelectTaxpayer.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        JFileChooser folderChooser = new JFileChooser();
//        folderChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
//        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int result = folderChooser.showOpenDialog(frame);
//        if(result == JFileChooser.APPROVE_OPTION) {
//          File selectedFolder = folderChooser.getSelectedFile();
//          File filesList[] = selectedFolder.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//              return name.toLowerCase().endsWith("_info.txt") || name.toLowerCase().endsWith("_info.xml");
//            }
//          });
//          System.out.println(filesList.length);
//          for(File infoFile: filesList) {
//            String[] filePathList = infoFile.getAbsolutePath().split("\\\\");
//            String taxRegistrationNumberFile = filePathList[filePathList.length-1];
//            String taxRegistrationNumber = taxRegistrationNumberFile.split("_")[0];
//            try {
//              int trn = Integer.parseInt(taxRegistrationNumber);
//              if (taxpayerManager.containsTaxpayer(trn)) {
//                JOptionPane.showMessageDialog(null, "This taxpayer is already loaded.");
//              } else {
//                taxpayerManager.loadTaxpayer(taxRegistrationNumberFile);
//                taxRegisterNumberModel.addElement(taxRegistrationNumber);
//              }
//              // textPane.setText(taxpayersTRN);
//            } catch (NumberFormatException e1) {
//              JOptionPane.showMessageDialog(null,
//                      "The tax registration number must have only digits." + taxRegistrationNumberFile);
//            } catch (IOException e1) {
//              JOptionPane.showMessageDialog(null, "The file doesn't exists.");
//            } catch (WrongFileFormatException e1) {
//              JOptionPane.showMessageDialog(null, "Please check your file format and try again.");
//            } catch (WrongFileEndingException e1) {
//              JOptionPane.showMessageDialog(null, "Please check your file ending and try again.");
//            } catch (WrongTaxpayerStatusException e1) {
//              JOptionPane.showMessageDialog(null, "Please check taxpayer's status and try again.");
//            } catch (WrongReceiptKindException e1) {
//              JOptionPane.showMessageDialog(null, "Please check receipts kind and try again.");
//            } catch (WrongReceiptDateException e1) {
//              JOptionPane.showMessageDialog(null,
//                      "Please make sure your date is " + "DD/MM/YYYY and try again.");
//            }
//          }
//        }
//      }
//    });
//    btnSelectTaxpayer.setBounds(147, 0, 139, 23);
//    contentPane.add(btnSelectTaxpayer);
    //begin
    taxRegisterNumberList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent mouseEvent) {
        JList theList = (JList) mouseEvent.getSource();
        if (mouseEvent.getClickCount() == 2) {
          int index = theList.locationToIndex(mouseEvent.getPoint());
          if (index >= 0) {
            Object taxRegistrationNumberItem = theList.getModel().getElementAt(index);
            TaxpayerData taxpayerData = new TaxpayerData(Integer.parseInt(taxRegistrationNumberItem.toString()), taxpayerManager);
            taxpayerData.setVisible(true);
          }
        }
      }
    });
    //end
    JButton btnDeleteTaxpayer = new JButton("Delete Taxpayer");
    btnDeleteTaxpayer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if (taxpayerManager.containsTaxpayer()) {
          String trn = taxRegisterNumberList.getSelectedValue();
          int taxRegistrationNumber;
          try {
            taxRegistrationNumber = Integer.parseInt(trn);
            if (taxpayerManager.containsTaxpayer(taxRegistrationNumber)) {
              taxpayerManager.removeTaxpayer(taxRegistrationNumber);
              taxRegisterNumberModel.removeElement(trn);
            }
          } catch (NumberFormatException e) {

          }
        } else {
          JOptionPane.showMessageDialog(null,
              "There isn't any taxpayer loaded. Please load one first.");
        }
      }
    });
    btnDeleteTaxpayer.setBounds(287, 0, 146, 23);
    contentPane.add(btnDeleteTaxpayer);

    txtTaxRegistrationNumber = new JTextField();
    txtTaxRegistrationNumber.setEditable(false);
    txtTaxRegistrationNumber.setBackground(new Color(153, 204, 204));
    txtTaxRegistrationNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
    txtTaxRegistrationNumber.setText("Tax Registration Number:");
    txtTaxRegistrationNumber.setBounds(70, 80, 300, 20);
    contentPane.add(txtTaxRegistrationNumber);
    txtTaxRegistrationNumber.setColumns(10);

  }
}