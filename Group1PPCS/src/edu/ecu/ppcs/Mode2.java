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
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * Start each class or interface with summary description line
 * 
 * @author jamesadams
 * @version 1.0
 *
 */
public class Mode2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JPanel formPanel;
    private JLabel lblsize4x6;
    private JLabel lblsize5x7;
    private JLabel lblsize8x10;
    private JLabel lblglossy1;
    private JLabel lblmatte1;
    private JLabel lblglossy2;
    private JLabel lblmatte2;
    private JLabel lblglossy3;
    private JLabel lblmatte3;
    private JLabel lblEmpty1;
    private JLabel lblEmpty2;
    private JLabel lblEmpty3;
    private JLabel lblEmpty4;
    private JLabel lblEmpty5;
    private JLabel lblEmpty6;
    private JLabel lblEmpty7;
    private JLabel lblEmpty8;
    private JLabel lblEmpty9;
    private JLabel lblEmpty10;
    private JLabel lblEmpty11;
    private JLabel timeLabel;
    
    private SpinnerModel quantityModel4x6G;
    private JSpinner quantity4x6G;
    private SpinnerModel quantityModel4x6M;
    private JSpinner quantity4x6M;
    private SpinnerModel quantityModel5x7G;
    private JSpinner quantity5x7G;
    private SpinnerModel quantityModel5x7M;
    private JSpinner quantity5x7M;
    private SpinnerModel quantityModel8x10G;
    private JSpinner quantity8x10G;
    private SpinnerModel quantityModel8x10M;
    private JSpinner quantity8x10M;
    private String[] timeItems = {"Next Day", "1-Hour"};
    private JComboBox<String> time;
    private JButton submit;
    private PhotoCostCalculatorMode2 calc;
    
    public Mode2(PhotoCostCalculatorMode2 calc) {
        initializeComponents();
        createPanel();
        addListeners();
        setLayout(new BorderLayout());
        this.calc = calc;
        add(mainPanel, BorderLayout.CENTER);
        setSize(550, 250);
        setTitle("Photo Print Cost System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        formPanel = new JPanel(new GridLayout(7,4));
        lblsize4x6 = new JLabel("4 x 6: ");
        lblsize5x7 = new JLabel("5 x 7: ");
        lblsize8x10 = new JLabel("8 x 10: ");
        lblglossy1 = new JLabel("Glossy finishing: ");
        lblmatte1 = new JLabel("Matte finishing: ");
        lblglossy2 = new JLabel("Glossy finishing: ");
        lblmatte2 = new JLabel("Matte finishing: ");
        lblglossy3 = new JLabel("Glossy finishing: ");
        lblmatte3 = new JLabel("Matte finishing: ");
        lblEmpty1 = new JLabel(" ");
        lblEmpty2 = new JLabel("         ");
        lblEmpty3 = new JLabel(" ");
        lblEmpty4 = new JLabel(" ");
        lblEmpty5 = new JLabel("         ");
        lblEmpty6 = new JLabel(" ");
        lblEmpty7 = new JLabel(" ");
        lblEmpty8 = new JLabel("         ");
        lblEmpty9 = new JLabel(" ");
        lblEmpty10 = new JLabel("");
        lblEmpty11 = new JLabel(" ");
        timeLabel = new JLabel("Processing Time: ");
        
        quantityModel4x6G = new SpinnerNumberModel(0, 0, 100, 1);
        quantity4x6G = new JSpinner(quantityModel4x6G);
        quantityModel4x6M = new SpinnerNumberModel(0, 0, 100, 1);
        quantity4x6M = new JSpinner(quantityModel4x6M);
        quantityModel5x7G = new SpinnerNumberModel(0, 0, 100, 1);
        quantity5x7G = new JSpinner(quantityModel5x7G);
        quantityModel5x7M = new SpinnerNumberModel(0, 0, 100, 1);
        quantity5x7M = new JSpinner(quantityModel5x7M);
        quantityModel8x10G = new SpinnerNumberModel(0, 0, 100, 1);
        quantity8x10G = new JSpinner(quantityModel8x10G);
        quantityModel8x10M = new SpinnerNumberModel(0, 0, 100, 1);
        quantity8x10M = new JSpinner(quantityModel8x10M);

        time = new JComboBox<String>(timeItems);
        submit = new JButton("Submit Order");
    }
    
    private void createPanel() {
        formPanel.add(lblsize4x6);
        formPanel.add(lblEmpty1);
        formPanel.add(lblglossy1);
        formPanel.add(quantity4x6G);
        formPanel.add(lblEmpty2);
        formPanel.add(lblEmpty3);
        formPanel.add(lblmatte1);
        formPanel.add(quantity4x6M);
        
        formPanel.add(lblsize5x7);
        formPanel.add(lblEmpty4);
        formPanel.add(lblglossy2);
        formPanel.add(quantity5x7G);
        formPanel.add(lblEmpty5);
        formPanel.add(lblEmpty6);
        formPanel.add(lblmatte2);
        formPanel.add(quantity5x7M);
        
        formPanel.add(lblsize8x10);
        formPanel.add(lblEmpty7);
        formPanel.add(lblglossy3);
        formPanel.add(quantity8x10G);
        formPanel.add(lblEmpty8);
        formPanel.add(lblEmpty9);
        formPanel.add(lblmatte3);
        formPanel.add(quantity8x10M);
        
        formPanel.add(timeLabel);
        formPanel.add(lblEmpty10);
        formPanel.add(lblEmpty11);
        formPanel.add(time);
        
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(submit, BorderLayout.SOUTH);
    }
    
    private void addListeners() {
        submit.addActionListener(new ButtonListener());
    }
    
    public int getQuantityTotal() {
    	return (int) quantity4x6G.getValue() + (int) quantity4x6M.getValue() + 
    			(int) quantity5x7G.getValue() + (int) quantity5x7M.getValue() +
    			(int) quantity8x10G.getValue() + (int) quantity8x10M.getValue();
    }
    
    public int getQuantity4x6() {
    	return (int) quantity4x6G.getValue() + (int) quantity4x6M.getValue();
    }
    
    public int getQuantity5x7() {
    	return (int) quantity5x7G.getValue() + (int) quantity5x7M.getValue();
    }
    
    public int getQuantity8x10() {
    	return (int) quantity8x10G.getValue() + (int) quantity8x10M.getValue();
    }
    
    public int getMatteFinish4x6() {
    	return (int) quantity4x6M.getValue();
    }
    
    public int getMatteFinish5x7() {
    	return (int) quantity5x7M.getValue();
    }
    
    public int getMatteFinish8x10() {
    	return (int) quantity8x10M.getValue();
    }
    
    public String getProcessingTime() {
    	return time.getSelectedItem().toString();
    }
    
    private class ButtonListener implements ActionListener {

        /**
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent aE) {
            JButton b = (JButton) aE.getSource();
            
            if (b.equals(submit)) {
            	double sizeCost4x6 = calc.getSizeCost(getQuantity4x6(), "4 x 6");
            	double sizeCost5x7 = calc.getSizeCost(getQuantity5x7(), "5 x 7");
            	double sizeCost8x10 = calc.getSizeCost(getQuantity8x10(), "8 x 10");
            	double finishCost4x6 = calc.getFinishCost(getMatteFinish4x6(), "matte", "4 x 6");
            	double finishCost5x7 = calc.getFinishCost(getMatteFinish5x7(), "matte", "5 x 7");
            	double finishCost8x10 = calc.getFinishCost(getMatteFinish8x10(), "matte", "8 x 10");
            	double processingTimeCost = calc.getProcessingTimeCost(getQuantityTotal(), getProcessingTime());
            	double totalCost = sizeCost4x6 + sizeCost5x7 + sizeCost8x10 + finishCost4x6 + finishCost5x7
            			+ finishCost8x10 + processingTimeCost;
            	
            	if (totalCost > 35.00) {
            		totalCost = totalCost - (totalCost * 0.05);
            	}
            	
            	String total = String.format("%.2f", totalCost);
                JOptionPane.showMessageDialog(null, "The total cost for your order is: $" + total);
            }
        }
        
    }
}
