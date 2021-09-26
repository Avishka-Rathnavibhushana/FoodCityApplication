/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.city.system.view;

import food.city.system.controller.ManageDatabaseController;
import food.city.system.dto.EmployeeDTO;
import food.city.system.dto.ItemDTO;
import food.city.system.dto.SupplierDTO;
import food.city.system.dto.SupplierItemsDetailsDTO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class ManageDatabase extends javax.swing.JFrame {

    /**
     * Creates new form ManageDatabase
     */
    
    private boolean updateItem = false;
    private boolean updateEmployee = false;
    private boolean updateSupplier = false;
    private ManageDatabaseController manageDatabaseController;
    private Main main;
    
    public ManageDatabase(Main main) {
        initComponents();
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        this.manageDatabaseController = new ManageDatabaseController();
        
        this.main = main;
        main.setVisible(false);
        
        loadAllItems();
        
        itemDatabaseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (itemDatabaseTable.getSelectedRow() == -1) {
                    updateItem = false;
                    ItemIdtxt.disable();
                    clearItemTextFields();
                    return;
                }
                ItemIdtxt.disable();
                ItemIdtxt.setText((String) itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 0));
                ItemNametxt.setText((String) itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 1));
                ItemBuyingPricetxt.setText((String) itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 2).toString());
                ItemSellingPricetxt.setText(itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 3).toString());
                RemainingItemstxt.setText(itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 4).toString());
                LowerLimittxt.setText(itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 5).toString());
                updateItem = true;
            }
        });
        
        
        loadAllEmployees();
        
        employeeDatabaseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (employeeDatabaseTable.getSelectedRow() == -1) {
                    updateEmployee = false;
                    employeeIdtxt.disable();
                    clearEmployeeTextFields();
                    return;
                }
                
                employeeIdtxt.disable();
                employeeIdtxt.setText((String) employeeDatabaseTable.getValueAt(employeeDatabaseTable.getSelectedRow(), 0));
                employeeNametxt.setText((String) employeeDatabaseTable.getValueAt(employeeDatabaseTable.getSelectedRow(), 1));
                salarytxt.setText((String) employeeDatabaseTable.getValueAt(employeeDatabaseTable.getSelectedRow(), 2).toString());
                updateEmployee = true;
            }
        });
        
        loadAllSuppliers();
        
        supplierDatabaseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (supplierDatabaseTable.getSelectedRow() == -1) {
                    updateSupplier = false;
                    supplierIdtxt.disable();
                    clearSupplierTextFields();
                    return;
                }
                
                supplierIdtxt.disable();
                supplierIdtxt.setText((String) supplierDatabaseTable.getValueAt(supplierDatabaseTable.getSelectedRow(), 0));
                supplierNametxt.setText((String) supplierDatabaseTable.getValueAt(supplierDatabaseTable.getSelectedRow(), 1));
                updateSupplier = true;
            }
        });
        
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
    
    private void clearItemTextFields() {
        ItemIdtxt.setText("");
        ItemNametxt.setText("");
        ItemBuyingPricetxt.setText("");
        ItemSellingPricetxt.setText("");
        RemainingItemstxt.setText("");
        LowerLimittxt.setText("");
    }
    
    private void clearEmployeeTextFields() {
        employeeIdtxt.setText("");
        employeeNametxt.setText("");
        salarytxt.setText("");
    }
    
    private void clearSupplierTextFields() {
        supplierIdtxt.setText("");
        supplierNametxt.setText("");
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
        mainLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ItemIdtxt = new javax.swing.JTextField();
        ItemNametxt = new javax.swing.JTextField();
        ItemBuyingPricetxt = new javax.swing.JTextField();
        ItemSellingPricetxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        RemainingItemstxt = new javax.swing.JTextField();
        newItemBtn = new javax.swing.JButton();
        updateItemBtn = new javax.swing.JButton();
        RemoveItemBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeDatabaseTable = new javax.swing.JTable();
        salarytxt = new javax.swing.JTextField();
        newEmployeeBtn = new javax.swing.JButton();
        updateEmployeeBtn = new javax.swing.JButton();
        RemoveEmployeeBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        employeeIdtxt = new javax.swing.JTextField();
        employeeNametxt = new javax.swing.JTextField();
        mainLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        supplierIdtxt = new javax.swing.JTextField();
        supplierNametxt = new javax.swing.JTextField();
        mainLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        supplierDatabaseTable = new javax.swing.JTable();
        newSuppplierBtn = new javax.swing.JButton();
        updateSupplierBtn = new javax.swing.JButton();
        RemoveSupplierBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        itemDatabaseTable = new javax.swing.JTable();
        saveItemBtn = new javax.swing.JButton();
        saveEmployeeBtn = new javax.swing.JButton();
        saveSupplierBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        LowerLimittxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainLabel.setFont(new java.awt.Font("Droid Sans", 1, 24)); // NOI18N
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel.setText("Manage Database");

        mainLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        mainLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel1.setText("Item Database");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Item ID : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Item Name : ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Item Buying Price : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Item Selling Price : ");

        ItemIdtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemIdtxt.setEnabled(false);
        ItemIdtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemIdtxtActionPerformed(evt);
            }
        });

        ItemNametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNametxtActionPerformed(evt);
            }
        });

        ItemBuyingPricetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemBuyingPricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemBuyingPricetxtActionPerformed(evt);
            }
        });

        ItemSellingPricetxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ItemSellingPricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemSellingPricetxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Remaining Items : ");

        RemainingItemstxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RemainingItemstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemainingItemstxtActionPerformed(evt);
            }
        });

        newItemBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newItemBtn.setText("Add New");
        newItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemBtnActionPerformed(evt);
            }
        });

        updateItemBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateItemBtn.setText("Update");
        updateItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemBtnActionPerformed(evt);
            }
        });

        RemoveItemBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RemoveItemBtn.setText("Remove");
        RemoveItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveItemBtnActionPerformed(evt);
            }
        });

        employeeDatabaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        jScrollPane2.setViewportView(employeeDatabaseTable);

        salarytxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salarytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarytxtActionPerformed(evt);
            }
        });

        newEmployeeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newEmployeeBtn.setText("Add New");
        newEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEmployeeBtnActionPerformed(evt);
            }
        });

        updateEmployeeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateEmployeeBtn.setText("Update");
        updateEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeBtnActionPerformed(evt);
            }
        });

        RemoveEmployeeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RemoveEmployeeBtn.setText("Remove");
        RemoveEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveEmployeeBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Employee ID : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Employee Name : ");

        employeeIdtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        employeeIdtxt.setEnabled(false);
        employeeIdtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeIdtxtActionPerformed(evt);
            }
        });

        employeeNametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        employeeNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNametxtActionPerformed(evt);
            }
        });

        mainLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        mainLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel2.setText("Employee Database");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Salary : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Supplier Name : ");

        supplierIdtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierIdtxt.setEnabled(false);
        supplierIdtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierIdtxtActionPerformed(evt);
            }
        });

        supplierNametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierNametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierNametxtActionPerformed(evt);
            }
        });

        mainLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        mainLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel3.setText("Supplier Database");

        supplierDatabaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(supplierDatabaseTable);

        newSuppplierBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        newSuppplierBtn.setText("Add New");
        newSuppplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSuppplierBtnActionPerformed(evt);
            }
        });

        updateSupplierBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateSupplierBtn.setText("Update");
        updateSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateSupplierBtnActionPerformed(evt);
            }
        });

        RemoveSupplierBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RemoveSupplierBtn.setText("Remove");
        RemoveSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveSupplierBtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Supplier ID : ");

        itemDatabaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Buying Price", "Selling Price", "Remaining Items", "Lower Limit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(itemDatabaseTable);

        saveItemBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveItemBtn.setText("Save");
        saveItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemBtnActionPerformed(evt);
            }
        });

        saveEmployeeBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveEmployeeBtn.setText("Save");
        saveEmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmployeeBtnActionPerformed(evt);
            }
        });

        saveSupplierBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveSupplierBtn.setText("Save");
        saveSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSupplierBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Lower Item limit : ");

        LowerLimittxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LowerLimittxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LowerLimittxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RemoveItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RemainingItemstxt))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ItemBuyingPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemSellingPricetxt))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ItemNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LowerLimittxt))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(saveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RemoveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeeIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeeNametxt)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salarytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(supplierIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(supplierNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saveSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(newSuppplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(updateSupplierBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RemoveSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(ItemIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(RemainingItemstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(LowerLimittxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ItemBuyingPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(ItemSellingPricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(RemoveItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(employeeIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(salarytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveEmployeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newSuppplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RemoveSupplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(supplierIdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierNametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemIdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemIdtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemIdtxtActionPerformed

    private void ItemNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemNametxtActionPerformed

    private void ItemBuyingPricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemBuyingPricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemBuyingPricetxtActionPerformed

    private void ItemSellingPricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemSellingPricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemSellingPricetxtActionPerformed

    private void RemainingItemstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemainingItemstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemainingItemstxtActionPerformed

    private void RemoveItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveItemBtnActionPerformed
        try {
            if (itemDatabaseTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Select an Item first");
                ItemIdtxt.disable();
                return;
            }

            boolean result = manageDatabaseController.deleteItem(itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 0).toString());

            if (result) {
                JOptionPane.showMessageDialog(this, "Item has been deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the Item");
            }

            clearItemTextFields();
            itemDatabaseTable.getSelectionModel().clearSelection();
            loadAllItems();
            updateItem = false;

        } catch (Exception ex) {
            Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        ItemIdtxt.disable();
    }//GEN-LAST:event_RemoveItemBtnActionPerformed

    private void salarytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarytxtActionPerformed

    private void RemoveEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveEmployeeBtnActionPerformed
        try {
            if (employeeDatabaseTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Select an Employee first");
                employeeIdtxt.disable();
                return;
            }

            boolean result = manageDatabaseController.deleteEmployee(employeeDatabaseTable.getValueAt(employeeDatabaseTable.getSelectedRow(), 0).toString());

            if (result) {
                JOptionPane.showMessageDialog(this, "Employee has been deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the Employee");
            }

            clearEmployeeTextFields();
            employeeDatabaseTable.getSelectionModel().clearSelection();
            loadAllEmployees();
            updateEmployee = false;

        } catch (Exception ex) {
            Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        employeeIdtxt.disable();
    }//GEN-LAST:event_RemoveEmployeeBtnActionPerformed

    private void employeeIdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeIdtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeIdtxtActionPerformed

    private void employeeNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNametxtActionPerformed

    private void supplierIdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierIdtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierIdtxtActionPerformed

    private void supplierNametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierNametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierNametxtActionPerformed

    private void RemoveSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveSupplierBtnActionPerformed
        try {
            if (supplierDatabaseTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Select an Supplier first");
                supplierIdtxt.disable();
                return;
            }

            boolean result = manageDatabaseController.deleteSupplier(supplierDatabaseTable.getValueAt(supplierDatabaseTable.getSelectedRow(), 0).toString());

            if (result) {
                JOptionPane.showMessageDialog(this, "Supplier has been deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the Supplier");
            }

            clearSupplierTextFields();
            supplierDatabaseTable.getSelectionModel().clearSelection();
            loadAllSuppliers();
            updateSupplier = false;

        } catch (Exception ex) {
            Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        supplierIdtxt.disable();
    }//GEN-LAST:event_RemoveSupplierBtnActionPerformed

    private void saveItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemBtnActionPerformed
        if (ItemIdtxt.getText().equals("")||ItemNametxt.getText().equals("")||ItemBuyingPricetxt.getText().equals("")||ItemSellingPricetxt.getText().equals("")||RemainingItemstxt.getText().equals("")||LowerLimittxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Check for empty fields");
            ItemIdtxt.disable();
            return;
        }
        
        ItemDTO itemDTO = new ItemDTO(ItemIdtxt.getText(),
            ItemNametxt.getText(),
            Float.parseFloat(ItemBuyingPricetxt.getText()), 
            Float.parseFloat(ItemSellingPricetxt.getText()), 
            Integer.parseInt(RemainingItemstxt.getText()),
            Integer.parseInt(LowerLimittxt.getText()));

        if (!updateItem) {
            try {
                String result = manageDatabaseController.saveItem(itemDTO);
                if ("true".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Item has been added successfully");
                } else if("false".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Failed to add the Item");
                } else if("Item already Exist".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Item already Exist");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateItem = false;
            itemDatabaseTable.clearSelection();
            clearItemTextFields();
            loadAllItems();
        }
        ItemIdtxt.disable();
        
    }//GEN-LAST:event_saveItemBtnActionPerformed

    private void newItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newItemBtnActionPerformed
        updateItem = false;
        ItemIdtxt.enable(true);
        clearItemTextFields();
    }//GEN-LAST:event_newItemBtnActionPerformed

    private void updateItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemBtnActionPerformed
        if (ItemIdtxt.getText().equals("")||ItemNametxt.getText().equals("")||ItemBuyingPricetxt.getText().equals("")||ItemSellingPricetxt.getText().equals("")||RemainingItemstxt.getText().equals("")||LowerLimittxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Select an Item first");
            ItemIdtxt.disable();
            return;
        }
        
        ItemDTO itemDTO = new ItemDTO(ItemIdtxt.getText(),
            ItemNametxt.getText(),
            Float.parseFloat(ItemBuyingPricetxt.getText()), 
            Float.parseFloat(ItemSellingPricetxt.getText()), 
            Integer.parseInt(RemainingItemstxt.getText()),
            Integer.parseInt(LowerLimittxt.getText()));

        if (updateItem) {
            try {
                if (itemDatabaseTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(this, "Select an Item first");
                    return;
                }

                itemDTO.setIid((String) itemDatabaseTable.getValueAt(itemDatabaseTable.getSelectedRow(), 0));
                boolean result = manageDatabaseController.updateItem(itemDTO);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Item has been updated successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update the Item");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateItem = false;
            itemDatabaseTable.clearSelection();
            clearItemTextFields();
            loadAllItems();
        }
        ItemIdtxt.disable();
        
    }//GEN-LAST:event_updateItemBtnActionPerformed

    private void saveEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmployeeBtnActionPerformed
        if (employeeIdtxt.getText().equals("")||employeeNametxt.getText().equals("")||salarytxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Check for empty fields");
            employeeIdtxt.disable();
            return;
        }
        
        EmployeeDTO employeeDTO = new EmployeeDTO(employeeIdtxt.getText(),
            employeeNametxt.getText(),
            Float.parseFloat(salarytxt.getText()));

        if (!updateEmployee) {
            try {
                String result = manageDatabaseController.saveEmployee(employeeDTO);
                if ("true".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Employee has been added successfully");
                } else if("false".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Failed to add the Employee");
                } else if("Employee already Exist".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Employee already Exist");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateEmployee = false;
            employeeDatabaseTable.clearSelection();
            clearEmployeeTextFields();
            loadAllEmployees();
        }
        employeeIdtxt.disable();
    }//GEN-LAST:event_saveEmployeeBtnActionPerformed

    private void saveSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSupplierBtnActionPerformed
        if (supplierIdtxt.getText().equals("")||supplierNametxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Check for empty fields");
            supplierIdtxt.disable();
            return;
        }
        
        SupplierDTO supplierDTO = new SupplierDTO(supplierIdtxt.getText(),
            supplierNametxt.getText());

        if (!updateSupplier) {
            try {
                String result = manageDatabaseController.saveSupplier(supplierDTO);
                if ("true".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Supplier has been added successfully");
                } else if("false".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Failed to add the Supplier");
                } else if("Supplier already Exist".equals(result)) {
                    JOptionPane.showMessageDialog(this, "Supplier already Exist");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateSupplier = false;
            supplierDatabaseTable.clearSelection();
            clearSupplierTextFields();
            loadAllSuppliers();
        }
        supplierIdtxt.disable();
    }//GEN-LAST:event_saveSupplierBtnActionPerformed

    private void newEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEmployeeBtnActionPerformed
        updateEmployee = false;
        employeeIdtxt.enable(true);
        clearEmployeeTextFields();
    }//GEN-LAST:event_newEmployeeBtnActionPerformed

    private void updateEmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateEmployeeBtnActionPerformed
        if (employeeIdtxt.getText().equals("")||employeeNametxt.getText().equals("")||salarytxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Select an Employee first");
            employeeIdtxt.disable();
            return;
        }
        
        EmployeeDTO employeeDTO = new EmployeeDTO(employeeIdtxt.getText(),
            employeeNametxt.getText(),
            Float.parseFloat(salarytxt.getText()));

        if (updateEmployee) {
            try {
                if (employeeDatabaseTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(this, "Select an Employee first");
                    return;
                }

                employeeDTO.setEid((String) employeeDatabaseTable.getValueAt(employeeDatabaseTable.getSelectedRow(), 0));
                boolean result = manageDatabaseController.updateEmployee(employeeDTO);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Employee has been updated successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update the Employee");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateEmployee = false;
            employeeDatabaseTable.clearSelection();
            clearEmployeeTextFields();
            loadAllEmployees();
        }
        employeeIdtxt.disable();
    }//GEN-LAST:event_updateEmployeeBtnActionPerformed

    private void newSuppplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSuppplierBtnActionPerformed
        updateSupplier = false;
        supplierIdtxt.enable(true);
        clearSupplierTextFields();
    }//GEN-LAST:event_newSuppplierBtnActionPerformed

    private void updateSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateSupplierBtnActionPerformed
        if (supplierIdtxt.getText().equals("")||supplierNametxt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Check for empty fields");
            supplierIdtxt.disable();
            return;
        }
        
        SupplierDTO supplierDTO = new SupplierDTO(supplierIdtxt.getText(),
            supplierNametxt.getText());

        if (updateSupplier) {
            try {
                if (supplierDatabaseTable.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(this, "Select an Supplier first");
                    return;
                }

                supplierDTO.setSid((String) supplierDatabaseTable.getValueAt(supplierDatabaseTable.getSelectedRow(), 0));
                boolean result = manageDatabaseController.updateSupplier(supplierDTO);

                if (result) {
                    JOptionPane.showMessageDialog(this, "Supplier has been updated successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update the Supplier");
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateSupplier = false;
            supplierDatabaseTable.clearSelection();
            clearSupplierTextFields();
            loadAllSuppliers();
        }
        supplierIdtxt.disable();
    }//GEN-LAST:event_updateSupplierBtnActionPerformed

    private void LowerLimittxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LowerLimittxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LowerLimittxtActionPerformed

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
            java.util.logging.Logger.getLogger(ManageDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ItemBuyingPricetxt;
    private javax.swing.JTextField ItemIdtxt;
    private javax.swing.JTextField ItemNametxt;
    private javax.swing.JTextField ItemSellingPricetxt;
    private javax.swing.JTextField LowerLimittxt;
    private javax.swing.JTextField RemainingItemstxt;
    private javax.swing.JButton RemoveEmployeeBtn;
    private javax.swing.JButton RemoveItemBtn;
    private javax.swing.JButton RemoveSupplierBtn;
    private javax.swing.JTable employeeDatabaseTable;
    private javax.swing.JTextField employeeIdtxt;
    private javax.swing.JTextField employeeNametxt;
    private javax.swing.JTable itemDatabaseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JLabel mainLabel1;
    private javax.swing.JLabel mainLabel2;
    private javax.swing.JLabel mainLabel3;
    private javax.swing.JButton newEmployeeBtn;
    private javax.swing.JButton newItemBtn;
    private javax.swing.JButton newSuppplierBtn;
    private javax.swing.JTextField salarytxt;
    private javax.swing.JButton saveEmployeeBtn;
    private javax.swing.JButton saveItemBtn;
    private javax.swing.JButton saveSupplierBtn;
    private javax.swing.JTable supplierDatabaseTable;
    private javax.swing.JTextField supplierIdtxt;
    private javax.swing.JTextField supplierNametxt;
    private javax.swing.JButton updateEmployeeBtn;
    private javax.swing.JButton updateItemBtn;
    private javax.swing.JButton updateSupplierBtn;
    // End of variables declaration//GEN-END:variables

    private void loadAllItems() {
        try {
            ArrayList<ItemDTO> allItems = manageDatabaseController.getAllItems();
            
            DefaultTableModel dtm = (DefaultTableModel) itemDatabaseTable.getModel();
            dtm.setRowCount(0);
            
            for (ItemDTO itemDTO  : allItems) {
                Object[] rowData = {
                    itemDTO.getIid(),
                    itemDTO.getName(),
                    itemDTO.getBuyingPrice(),
                    itemDTO.getSellingPrice(),
                    itemDTO.getNoOfItems(),
                    itemDTO.getLowerLimit()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllEmployees() {
        try {
            ArrayList<EmployeeDTO> allEmployees = manageDatabaseController.getAllEmployees();
            
            DefaultTableModel dtm = (DefaultTableModel) employeeDatabaseTable.getModel();
            dtm.setRowCount(0);
            
            for (EmployeeDTO employeeDTO  : allEmployees) {
                Object[] rowData = {
                    employeeDTO.getEid(),
                    employeeDTO.getName(),
                    employeeDTO.getSalary()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllSuppliers() {
        try {
            ArrayList<SupplierDTO> allSuppliers = manageDatabaseController.getAllSuppliers();
            
            DefaultTableModel dtm = (DefaultTableModel) supplierDatabaseTable.getModel();
            dtm.setRowCount(0);
            
            for (SupplierDTO supplierDTO  : allSuppliers) {
                Object[] rowData = {
                    supplierDTO.getSid(),
                    supplierDTO.getName()
                };
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(ItemInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
