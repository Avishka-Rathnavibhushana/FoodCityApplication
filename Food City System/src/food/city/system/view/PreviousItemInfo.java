/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.view;

import food.city.system.controller.ItemInfoController;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.SupplierItemsDetailsDTO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class PreviousItemInfo extends javax.swing.JFrame {

    /**
     * Creates new form PreviousItemInfo
     */
    
    private ItemInfoController ItemInfoController;
    private int START_YEAR = 2020;
    private String[] monthList;
    private int comboMonth=1;
    private int comboYear=2020;
    private int comboDay=1;
    
    private Main main;
    
    public PreviousItemInfo(Main main) {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.main = main;
        main.setVisible(false);
        this.ItemInfoController = new ItemInfoController();
        
        String date = LocalDate.now().toString();
        int currYear = Integer.parseInt(date.substring(0, 4));
        monthList = new DateFormatSymbols().getMonths();
        
        for (int i = START_YEAR; i <= currYear; i++) {
            yearComboBox.addItem(currYear+"");
        }

        for (String string : monthList) {
            if (string.equals("")) {
                continue;
            }
            monthComboBox.addItem(string);
        }
        
        setDaysComboBox(31);
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                main.setVisible(true);
                e.getWindow().dispose();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemInfoTable = new javax.swing.JTable();
        jlabel = new javax.swing.JLabel();
        yearComboBox = new javax.swing.JComboBox<>();
        monthComboBox = new javax.swing.JComboBox<>();
        dayComboBox = new javax.swing.JComboBox<>();
        searchbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainLabel.setFont(new java.awt.Font("Droid Sans", 1, 24)); // NOI18N
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel.setText("Daily Item Information History");

        itemInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Bought Items", "Selled Items"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemInfoTable);

        jlabel.setFont(new java.awt.Font("Droid Sans", 0, 18)); // NOI18N
        jlabel.setText("Date : ");

        yearComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        monthComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        dayComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dayComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayComboBoxActionPerformed(evt);
            }
        });

        searchbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        if (dayComboBox.getSelectedItem()!=null) {
            comboDay = Integer.parseInt((String) dayComboBox.getSelectedItem());
        }
        
        String date;
        if (comboMonth<10 && comboDay<10) {
            date = comboYear+"-0"+comboMonth+"-0"+comboDay;
        }else if (comboMonth<10) {
            date = comboYear+"-"+comboMonth+"-"+comboDay;
        }else if (comboDay<10) {
            date = comboYear+"-"+comboMonth+"-0"+comboDay;
        }else{
            date = comboYear+"-"+comboMonth+"-"+comboDay;
        }
        LoadAllItemsOnDay(date);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        comboMonth = monthComboBox.getSelectedIndex()+1;
        YearMonth yearMonthObject = YearMonth.of(comboYear, comboMonth);
        int daysInMonth = yearMonthObject.lengthOfMonth(); 
        setDaysComboBox(daysInMonth);
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        comboYear = Integer.parseInt((String) yearComboBox.getSelectedItem());
        YearMonth yearMonthObject = YearMonth.of(comboYear, comboMonth);
        int daysInMonth = yearMonthObject.lengthOfMonth(); 
        setDaysComboBox(daysInMonth);
    }//GEN-LAST:event_yearComboBoxActionPerformed

    private void dayComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayComboBoxActionPerformed

    }//GEN-LAST:event_dayComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PreviousItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreviousItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreviousItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreviousItemInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerIdTxt;
    private javax.swing.JTextField customerIdTxt1;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JTable itemInfoTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JButton searchbtn;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables

    private void setDaysComboBox(int i) {
        dayComboBox.removeAllItems();
        for (int j = 1; j <= i; j++) {
            dayComboBox.addItem(j+"");
        }
    }

    private void LoadAllItemsOnDay(String date) {
        try {
            ArrayList<ItemDTO> allItems = ItemInfoController.getALLItems();
            SupplierItemsDetailsDTO supplierItemsDetailsDTO = ItemInfoController.getSupplierItemsDetailOnDay(date);
            ArrayList<Object> orderItemDetailsDTO = ItemInfoController.getOrderItemsDetailOnDay(date);
            DefaultTableModel dtm = (DefaultTableModel) itemInfoTable.getModel();
            dtm.setRowCount(0);
            
            ArrayList<String> Iids = supplierItemsDetailsDTO.getIids();
            ArrayList<Integer> noOfItemsList = supplierItemsDetailsDTO.getNoItems();
            ArrayList<String> selledIids = (ArrayList<String>) orderItemDetailsDTO.get(0);
            ArrayList<Integer> sellednoOfItemsList = (ArrayList<Integer>) orderItemDetailsDTO.get(1);;
            
            for (ItemDTO itemDTO  : allItems) {
                String Iid = itemDTO.getIid();
                int boughtItems = 0;
                int selledItems = 0;
                int index = 0;
                if (Iids.contains(Iid)) {
                    index = Iids.indexOf(Iid);
                    boughtItems = noOfItemsList.get(index);
                }
                if (selledIids.contains(Iid)) {
                    index = selledIids.indexOf(Iid);
                    selledItems = sellednoOfItemsList.get(index);
                    
                }
                
                Object[] rowData = {
                    itemDTO.getIid(),
                    itemDTO.getName(),
                    boughtItems,
                    selledItems
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
