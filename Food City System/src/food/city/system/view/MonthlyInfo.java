/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.view;

import food.city.system.controller.DailyInfoController;
import food.city.system.controller.MonthlyInfoController;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.OrderDetailDTO;
import food.city.system.dto.PaysheetDTO;
import food.city.system.dto.SupplyDeteilDTO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class MonthlyInfo extends javax.swing.JFrame {

    /**
     * Creates new form MonthlyInfo
     */
    
    private MonthlyInfoController monthlyInfoController;
    private float totRevenue = 0;
    private float totSupply = 0;
    private float totPayment = 0;
    private float tot = 0;
    private String thisMonth;
    private ArrayList<OrderDetailDTO> ordersDetails;
    private ArrayList<SupplyDeteilDTO> suppliersItemsDetails;
    private ArrayList<PaysheetDTO> paysheetDTOs;
    private boolean showAll = false;
    private Main main;
    
    public MonthlyInfo(Main main) {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.main = main;
        main.setVisible(false);
        
        LocalDate date=LocalDate.now();
        thisMonth = date.toString().substring(0, 7);
        
        this.monthlyInfoController = new MonthlyInfoController();
        
        try {
            this.ordersDetails = monthlyInfoController.getAllOrdersThisMonth(thisMonth);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DailyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        showAllOdersThisMonth(thisMonth);
        
        OrderDetailTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (OrderDetailTbl.getSelectedRow() == -1) {
                    return;
                }

                String Oid = (String) OrderDetailTbl.getValueAt(OrderDetailTbl.getSelectedRow(), 0);
                for (OrderDetailDTO ordersDetail : ordersDetails) {
                    if (ordersDetail.getOid().equals(Oid)) {
                        DefaultTableModel dtm = (DefaultTableModel) OrderItemsTbl.getModel();
                        dtm.setRowCount(0);
                        showOderItems(ordersDetail.getItemList());
                    }
                }
            }
        });
        
        try {
            this.suppliersItemsDetails = monthlyInfoController.getAllSuppliersThisMonth(thisMonth);
        } catch (SQLException ex) {
            Logger.getLogger(DailyInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DailyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        showAllSuppliersThisMonth(thisMonth);
        showAll = true;
        
        SupplierDetailTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (SupplierDetailTbl.getSelectedRow() == -1) {
                    return;
                }
                
                int srID = (int) SupplierDetailTbl.getValueAt(SupplierDetailTbl.getSelectedRow(), 3);
                for (SupplyDeteilDTO supplyDeteilDTO : suppliersItemsDetails) {
                    if (supplyDeteilDTO.getSrID() == srID) {
                        DefaultTableModel dtm = (DefaultTableModel) SupplyItemsTbl.getModel();
                        dtm.setRowCount(0);
                        showSupplierItems(supplyDeteilDTO.getItemList());
                    }
                }
            }
        });
        
        try {
            this.paysheetDTOs = monthlyInfoController.getAllPaysheetsThisMonth(thisMonth);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MonthlyInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MonthlyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        showAllPaysheetsThisMonth(thisMonth);
        totEmployeePaymentExpencetxt.setText(totPayment+"");
        
        showProfitInfoThisMonth(thisMonth);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        netProfitTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totEmployeePaymentExpencetxt = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        EmployeeTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ShowAllOrderItemsbtn = new javax.swing.JButton();
        grossProfitTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mainLabel4 = new javax.swing.JLabel();
        totRevenuetxt = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        SupplierDetailTbl = new javax.swing.JTable();
        ShowAllSupplyItemsbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderItemsTbl = new javax.swing.JTable();
        totGoodExpencetxt = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        SupplyItemsTbl = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        OrderDetailTbl = new javax.swing.JTable();
        mainLabel1 = new javax.swing.JLabel();
        mainLabel2 = new javax.swing.JLabel();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("NET PROFIT :");

        netProfitTxt.setEditable(false);
        netProfitTxt.setBackground(new java.awt.Color(255, 255, 255));
        netProfitTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Expense for Employee Payments :");

        totEmployeePaymentExpencetxt.setEditable(false);
        totEmployeePaymentExpencetxt.setBackground(new java.awt.Color(255, 255, 255));
        totEmployeePaymentExpencetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        EmployeeTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Fixed Salary", "OT Rate", "OT Hours", "OT Total", "Total Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(EmployeeTbl);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("GROSS PROFIT :");

        ShowAllOrderItemsbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ShowAllOrderItemsbtn.setText("Show All");

        grossProfitTxt.setEditable(false);
        grossProfitTxt.setBackground(new java.awt.Color(255, 255, 255));
        grossProfitTxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Total Revenue :");

        mainLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        mainLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel4.setText("Emplyee Payment Information");

        totRevenuetxt.setEditable(false);
        totRevenuetxt.setBackground(new java.awt.Color(255, 255, 255));
        totRevenuetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        SupplierDetailTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Total Bill", "Date", "Receipt ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane6.setViewportView(SupplierDetailTbl);

        ShowAllSupplyItemsbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ShowAllSupplyItemsbtn.setText("Show All");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Total Expense for Goods :");

        OrderItemsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(OrderItemsTbl);

        totGoodExpencetxt.setEditable(false);
        totGoodExpencetxt.setBackground(new java.awt.Color(255, 255, 255));
        totGoodExpencetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        SupplyItemsTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(SupplyItemsTbl);

        OrderDetailTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Total Bill", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
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
        jScrollPane5.setViewportView(OrderDetailTbl);

        mainLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        mainLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel1.setText("Order Information");

        mainLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        mainLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel2.setText("Supply Information");

        mainLabel.setFont(new java.awt.Font("Droid Sans", 1, 24)); // NOI18N
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel.setText("Monthly Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mainLabel1)
                                    .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(ShowAllOrderItemsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totRevenuetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mainLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(ShowAllSupplyItemsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totGoodExpencetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(mainLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totEmployeePaymentExpencetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(grossProfitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(netProfitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowAllOrderItemsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totRevenuetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totGoodExpencetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ShowAllSupplyItemsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grossProfitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addComponent(mainLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totEmployeePaymentExpencetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netProfitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MonthlyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonthlyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonthlyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonthlyInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EmployeeTbl;
    private javax.swing.JTable OrderDetailTbl;
    private javax.swing.JTable OrderItemsTbl;
    private javax.swing.JButton ShowAllOrderItemsbtn;
    private javax.swing.JButton ShowAllSupplyItemsbtn;
    private javax.swing.JTable SupplierDetailTbl;
    private javax.swing.JTable SupplyItemsTbl;
    private javax.swing.JTextField grossProfitTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel mainLabel1;
    private javax.swing.JLabel mainLabel2;
    private javax.swing.JLabel mainLabel4;
    private javax.swing.JTextField netProfitTxt;
    private javax.swing.JTextField totEmployeePaymentExpencetxt;
    private javax.swing.JTextField totGoodExpencetxt;
    private javax.swing.JTextField totRevenuetxt;
    // End of variables declaration//GEN-END:variables

   private void showAllOdersThisMonth(String thisMonth) {
        DefaultTableModel dtm=(DefaultTableModel) OrderDetailTbl.getModel();
        dtm.setRowCount(0);
        DefaultTableModel dtm1=(DefaultTableModel) OrderItemsTbl.getModel();
        dtm1.setRowCount(0);
        for (OrderDetailDTO orderDetails : ordersDetails) {
            Object[] rowData={orderDetails.getOid(),orderDetails.getCid(),orderDetails.getTotal(),orderDetails.getDate()};
            dtm.addRow(rowData);
            if (showAll==false) {
                totRevenue = totRevenue + orderDetails.getTotal();
            }
            showOderItems(orderDetails.getItemList());
        }
        totRevenuetxt.setText(totRevenue+"");
        
    }

    private void showOderItems(ArrayList<ItemDTO> orderItems) {
        for (ItemDTO item : orderItems) {
            Object[] rowData={item.getIid(),item.getSellingPrice(),item.getNoOfItems()};
            DefaultTableModel dtm=(DefaultTableModel) OrderItemsTbl.getModel();
            dtm.addRow(rowData);
        }
    }

    private void showAllSuppliersThisMonth(String thisMonth){
        DefaultTableModel dtm=(DefaultTableModel) SupplierDetailTbl.getModel();
        dtm.setRowCount(0);
        DefaultTableModel dtm1=(DefaultTableModel) SupplyItemsTbl.getModel();
        dtm1.setRowCount(0);
        for (SupplyDeteilDTO supplierItemsDetail : suppliersItemsDetails) {
            Object[] rowData={supplierItemsDetail.getSid(),supplierItemsDetail.getTotal(),supplierItemsDetail.getDate(),supplierItemsDetail.getSrID()};
            dtm.addRow(rowData);
            if (showAll==false) {
                totSupply = totSupply + supplierItemsDetail.getTotal();
            }
            showSupplierItems(supplierItemsDetail.getItemList());
            totGoodExpencetxt.setText(totSupply+"");
        }
    }

    private void showSupplierItems(ArrayList<ItemDTO> items) {
        for (ItemDTO item : items) {
            Object[] rowData={item.getIid(),item.getBuyingPrice(),item.getNoOfItems()};
            DefaultTableModel dtm=(DefaultTableModel) SupplyItemsTbl.getModel();
            dtm.addRow(rowData);
        }
    }

    private void showProfitInfoThisMonth(String thisMonth) {
        grossProfitTxt.setText((totRevenue-totSupply)+"");
        netProfitTxt.setText((totRevenue-totSupply-totPayment)+"");
    }

    private void showAllPaysheetsThisMonth(String thisMonth) {
        for (PaysheetDTO paysheetDTO : paysheetDTOs) {
            Object[] rowData={paysheetDTO.getEid(),paysheetDTO.getName(),paysheetDTO.getFixedSalary(),paysheetDTO.getOtRate(),paysheetDTO.getOtHours(),paysheetDTO.getOtAmount(),paysheetDTO.getTotalSalary()};
            DefaultTableModel dtm=(DefaultTableModel) EmployeeTbl.getModel();
            dtm.addRow(rowData);
            totPayment = totPayment + paysheetDTO.getTotalSalary();
        }
    }
}
