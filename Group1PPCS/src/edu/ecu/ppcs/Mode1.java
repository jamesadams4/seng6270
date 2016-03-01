/**
 * Mode1.java 1.0 Feb 26, 2016
 * 
 * Copyright (c) 2016 James C. Adams IV. All Rights Reserved
 */
package edu.ecu.ppcs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * Start each class or interface with summary description line
 * 
 * @author jamesadams
 * @version 1.0
 *
 */
public class Mode1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JPanel formPanel;
    private JLabel quantityLabel;
    private JLabel sizesLabel;
    private JLabel finishLabel;
    private JLabel timeLabel;
    private JLabel promoLabel;
    private SpinnerModel quantityModel;
    private JSpinner quantity;
    private String[] sizesItems = {"4 x 6", "5 x 7", "8 x 10"};
    private JComboBox<String> sizes;
    private String[] finishItems = {"glossy", "matte"};
    private JComboBox<String> finish;
    private String[] timeItems = {"Next Day", "1-Hour"};
    private JComboBox<String> time;
    private JTextField promo;
    private JButton submit;
    private PhotoCostCalculator calc;
    
    public Mode1(PhotoCostCalculator calc) {
        initializeComponents();
        createPanel();
        addListeners();
        setLayout(new BorderLayout());
        this.calc = calc;
        add(mainPanel, BorderLayout.CENTER);
        setSize(350, 200);
        setTitle("Photo Print Cost System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        formPanel = new JPanel(new GridLayout(5,2));
        quantityLabel = new JLabel("Print Quantity (1 to 100): ");
        sizesLabel = new JLabel("Sizes: ");
        finishLabel = new JLabel("Finish: ");
        timeLabel = new JLabel("Processing Time: ");
        promoLabel = new JLabel("Promo Code: ");
        quantityModel = new SpinnerNumberModel(1, 1, 100, 1);
        quantity = new JSpinner(quantityModel);
        sizes = new JComboBox<String>(sizesItems);
        finish = new JComboBox<String>(finishItems);
        time = new JComboBox<String>(timeItems);
        promo = new JTextField(20);
        submit = new JButton("Submit Order");
    }
    
    private void createPanel() {
        formPanel.add(quantityLabel);
        formPanel.add(quantity);
        formPanel.add(sizesLabel);
        formPanel.add(sizes);
        formPanel.add(finishLabel);
        formPanel.add(finish);
        formPanel.add(timeLabel);
        formPanel.add(time);
        formPanel.add(promoLabel);
        formPanel.add(promo);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(submit, BorderLayout.SOUTH);
    }
    
    private void addListeners() {
        submit.addActionListener(new ButtonListener());
    }
    
    public int getQuantity() {
    	return (int) quantity.getValue();
    }
    
    public String getSizes() {
    	return sizes.getSelectedItem().toString();
    }
    
    public String getFinish() {
    	return finish.getSelectedItem().toString();
    }
    
    public String getProcessingTime() {
    	return time.getSelectedItem().toString();
    }
    
    public String getPromoCode() {
    	return promo.getText();
    }
    
    private class ButtonListener implements ActionListener {

        /**
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent aE) {
            JButton b = (JButton) aE.getSource();
            
            if (b.equals(submit)) {
            	double sizeCost = calc.getSizeCost(getQuantity(), getSizes());
            	double finishCost = calc.getFinishCost(getQuantity(), getFinish(), getSizes());
            	double processingTimeCost = calc.getProcessingTimeCost(getQuantity(), getProcessingTime());
            	double promoDiscount = calc.getPromoDiscount(getQuantity(), getPromoCode());
            	double totalCost = sizeCost + finishCost + processingTimeCost + promoDiscount;
            	String total = String.format("%.2f", totalCost);
                JOptionPane.showMessageDialog(null, "The total cost for your order is: $" + total);
            }
        }
        
    }
}
