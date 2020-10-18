/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics.commision;

import DBController.DataBaseConnector;
import DataManipulation.DataManipulation;
import DataManipulation.Rounding;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author lakshan
 */
public class CommisionView extends javax.swing.JFrame {

    /**
     * Creates new form DayEndView
     */
    Commision commision;

    /**
     * Creates new form CommisionView
     */
    public CommisionView() {
        initComponents();
        commision = Commision.getInstance();
        DataBaseConnector connector = DataBaseConnector.getInstance();
        AutoCompleteDecorator.decorate(commision_rep_name_combo);
        DataManipulation dm = new DataManipulation(connector);
        dm.getRecords("reps", "name", commision_rep_name_combo);
        LocalDate today = LocalDate.now();
        commission_from_picker.setDate(convertToDateViaSqlDate(today.withDayOfMonth(1)));
        commission_to_picker.setDate(convertToDateViaSqlDate(today.withDayOfMonth(today.lengthOfMonth())));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        commision.setDate(df.format(commission_from_picker.getDate()), df.format(commission_to_picker.getDate()));
        generateReport();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        commission_from_picker = new com.toedter.calendar.JDateChooser();
        refresh_btn = new javax.swing.JLabel();
        sales_panel = new javax.swing.JPanel();
        total_sales_lbl = new javax.swing.JLabel();
        commision_credit_sales = new javax.swing.JLabel();
        commision_cash_sales = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        commission_halfPayments_lbl = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        total_cashSale_lbl = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        commission_pending_credit_lbl = new javax.swing.JLabel();
        returns_panel = new javax.swing.JPanel();
        total_returns_lbl = new javax.swing.JLabel();
        credit_returns_lbl = new javax.swing.JLabel();
        cash_returns_lbl = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        partPayments_panel = new javax.swing.JPanel();
        partpayments_lbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        commission_to_picker = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        commision_rep_name_combo = new javax.swing.JComboBox<>();
        partPayments_panel1 = new javax.swing.JPanel();
        commission_value_lbl = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Commission Report");

        commission_from_picker.setDateFormatString("yyyy-MM-dd");

        refresh_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-filled-50.png"))); // NOI18N
        refresh_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh_btnMouseClicked(evt);
            }
        });

        sales_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        total_sales_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total_sales_lbl.setText("xxxxx.xx");

        commision_credit_sales.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        commision_credit_sales.setText("xxxxx.xx");

        commision_cash_sales.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        commision_cash_sales.setText("xxxxx.xx");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Cash Sales");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Credit Sales");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Half Payments");

        commission_halfPayments_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        commission_halfPayments_lbl.setText("xxxxx.xx");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Total Cash Sales");

        total_cashSale_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total_cashSale_lbl.setText("xxxxx.xx");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Total Sales");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Pending Credit Payments");

        commission_pending_credit_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        commission_pending_credit_lbl.setForeground(new java.awt.Color(255, 51, 51));
        commission_pending_credit_lbl.setText("xxxxx.xx");

        javax.swing.GroupLayout sales_panelLayout = new javax.swing.GroupLayout(sales_panel);
        sales_panel.setLayout(sales_panelLayout);
        sales_panelLayout.setHorizontalGroup(
            sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sales_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sales_panelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sales_panelLayout.createSequentialGroup()
                                .addComponent(total_cashSale_lbl)
                                .addGap(17, 17, 17))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sales_panelLayout.createSequentialGroup()
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addGroup(sales_panelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel17))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commision_cash_sales, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(commision_credit_sales, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(commission_pending_credit_lbl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(commission_halfPayments_lbl, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sales_panelLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total_sales_lbl)
                        .addGap(17, 17, 17)))
                .addContainerGap())
        );
        sales_panelLayout.setVerticalGroup(
            sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sales_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commision_cash_sales)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(commision_credit_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(commission_halfPayments_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(commission_pending_credit_lbl))
                .addGap(33, 33, 33)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_sales_lbl)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(sales_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total_cashSale_lbl)
                    .addComponent(jLabel18))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        returns_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Returns", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        total_returns_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total_returns_lbl.setText("xxxxx.xx");

        credit_returns_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        credit_returns_lbl.setText("xxxxx.xx");

        cash_returns_lbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cash_returns_lbl.setText("xxxxx.xx");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Cash Returns");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Credit Returns");

        javax.swing.GroupLayout returns_panelLayout = new javax.swing.GroupLayout(returns_panel);
        returns_panel.setLayout(returns_panelLayout);
        returns_panelLayout.setHorizontalGroup(
            returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returns_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returns_panelLayout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returns_panelLayout.createSequentialGroup()
                        .addGroup(returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(credit_returns_lbl)
                            .addComponent(cash_returns_lbl))
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returns_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(total_returns_lbl)
                .addGap(22, 22, 22))
        );
        returns_panelLayout.setVerticalGroup(
            returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returns_panelLayout.createSequentialGroup()
                .addGroup(returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(returns_panelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(cash_returns_lbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, returns_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(returns_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(credit_returns_lbl)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_returns_lbl)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        partPayments_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Part Payments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        partpayments_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        partpayments_lbl.setText("xxxxx.xx");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Part Payments");

        javax.swing.GroupLayout partPayments_panelLayout = new javax.swing.GroupLayout(partPayments_panel);
        partPayments_panel.setLayout(partPayments_panelLayout);
        partPayments_panelLayout.setHorizontalGroup(
            partPayments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partPayments_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(partpayments_lbl)
                .addGap(23, 23, 23))
        );
        partPayments_panelLayout.setVerticalGroup(
            partPayments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partPayments_panelLayout.createSequentialGroup()
                .addGroup(partPayments_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partPayments_panelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(partpayments_lbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partPayments_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commission_to_picker.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("From");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("To");

        commision_rep_name_combo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        commision_rep_name_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commision_rep_name_comboActionPerformed(evt);
            }
        });

        partPayments_panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commision", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 18))); // NOI18N

        commission_value_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        commission_value_lbl.setForeground(new java.awt.Color(0, 204, 102));
        commission_value_lbl.setText("xxxxx.xx");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("amount");

        javax.swing.GroupLayout partPayments_panel1Layout = new javax.swing.GroupLayout(partPayments_panel1);
        partPayments_panel1.setLayout(partPayments_panel1Layout);
        partPayments_panel1Layout.setHorizontalGroup(
            partPayments_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partPayments_panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commission_value_lbl)
                .addGap(23, 23, 23))
        );
        partPayments_panel1Layout.setVerticalGroup(
            partPayments_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partPayments_panel1Layout.createSequentialGroup()
                .addGroup(partPayments_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(partPayments_panel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(commission_value_lbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, partPayments_panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sales_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(returns_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(partPayments_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(commission_from_picker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(commission_to_picker, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addComponent(commision_rep_name_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(refresh_btn)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(partPayments_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(commision_rep_name_combo)
                                    .addComponent(commission_from_picker, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(refresh_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commission_to_picker, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(sales_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(returns_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(partPayments_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(partPayments_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        partPayments_panel1.getAccessibleContext().setAccessibleName("Commision for period");
        partPayments_panel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh_btnMouseClicked
        Date from = commission_from_picker.getDate();
        Date to = commission_to_picker.getDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        commision.setDate(df.format(from), df.format(to));
        generateReport();
    }//GEN-LAST:event_refresh_btnMouseClicked

    private void commision_rep_name_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commision_rep_name_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commision_rep_name_comboActionPerformed

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
            java.util.logging.Logger.getLogger(CommisionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommisionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommisionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommisionView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommisionView().setVisible(true);
            }
        });
    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public void generateReport() {

        boolean disposed = false;
        String cash_sale = commision.getCashSales();
        if (!cash_sale.equals("null")) {
            commision_cash_sales.setText(Rounding.decimalFormatiing(Double.valueOf(cash_sale)));
        } else {
            JOptionPane.showMessageDialog(null, "Sorry for this day can't prepare the day end report due to no sales");
            this.dispose();
            disposed = true;
        }

        if (!disposed) {

            String credit_sales = commision.getCreditSales();
            if (!credit_sales.equals("null")) {
                commision_credit_sales.setText(Rounding.decimalFormatiing(Double.valueOf(credit_sales)));
            } else {
                commision_credit_sales.setText("0.00");
                credit_sales = "0.00";
            }

            String half_payments = commision.getHalfPayments();
            if (!half_payments.equals("null")) {
                commission_halfPayments_lbl.setText(Rounding.decimalFormatiing(Double.valueOf(half_payments)));
            } else {
                commission_halfPayments_lbl.setText("0.00");
                half_payments = "0.00";
            }

            if (!half_payments.equals("null") && !credit_sales.equals("null")) {
                String pending_credit_amount = String.valueOf(Double.valueOf(credit_sales) - Double.valueOf(half_payments));
                commission_pending_credit_lbl.setText(pending_credit_amount);
            }

            double t_sales = Double.valueOf(cash_sale) + Double.valueOf(credit_sales);
            total_sales_lbl.setText(Rounding.decimalFormatiing(t_sales));

            double t_cash_sales = Double.valueOf(cash_sale) + Double.valueOf(half_payments);
            total_cashSale_lbl.setText(Rounding.decimalFormatiing(t_cash_sales));

            String cash_returns = commision.getCashReturns();
            if (!cash_returns.equals("null")) {
                cash_returns_lbl.setText(Rounding.decimalFormatiing(Double.valueOf(cash_returns)));
            } else {
                cash_returns_lbl.setText("0.00");
                cash_returns = "0.00";
            }

            String credit_retunrs = commision.getCreditReturns();
            if (!credit_retunrs.equals("null")) {
                credit_returns_lbl.setText(Rounding.decimalFormatiing(Double.valueOf(credit_retunrs)));
            } else {
                credit_returns_lbl.setText("0.00");
                credit_retunrs = "0.00";
            }

            double t_returns = Double.valueOf(cash_returns_lbl.getText()) + Double.valueOf(credit_returns_lbl.getText());
            if (t_returns != 0.00) {
                total_returns_lbl.setText(Rounding.decimalFormatiing(t_returns));
            } else {
                total_returns_lbl.setText("0.00");
            }

            String part_payments = commision.getPartPayments();
            if (!part_payments.equals("null")) {
                partpayments_lbl.setText(Rounding.decimalFormatiing(Double.valueOf(part_payments)));
            } else {
                partpayments_lbl.setText("0.00");
                part_payments = "0.00";
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cash_returns_lbl;
    private javax.swing.JLabel commision_cash_sales;
    private javax.swing.JLabel commision_credit_sales;
    private javax.swing.JComboBox<String> commision_rep_name_combo;
    private com.toedter.calendar.JDateChooser commission_from_picker;
    private javax.swing.JLabel commission_halfPayments_lbl;
    private javax.swing.JLabel commission_pending_credit_lbl;
    private com.toedter.calendar.JDateChooser commission_to_picker;
    private javax.swing.JLabel commission_value_lbl;
    private javax.swing.JLabel credit_returns_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel partPayments_panel;
    private javax.swing.JPanel partPayments_panel1;
    private javax.swing.JLabel partpayments_lbl;
    private javax.swing.JLabel refresh_btn;
    private javax.swing.JPanel returns_panel;
    private javax.swing.JPanel sales_panel;
    private javax.swing.JLabel total_cashSale_lbl;
    private javax.swing.JLabel total_returns_lbl;
    private javax.swing.JLabel total_sales_lbl;
    // End of variables declaration//GEN-END:variables
}
