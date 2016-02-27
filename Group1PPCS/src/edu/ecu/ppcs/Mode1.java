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
public class Mode1 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JPanel formPanel;
    private JLabel quantityLabel;
    private JLabel sizesLabel;
    private JLabel finishLabel;
    private JLabel timeLabel;
    private SpinnerModel quantityModel;
    private JSpinner quantity;
    private String[] sizesItems = {"4 x 6", "5 x 7", "8 x 10"};
    private JComboBox<String> sizes;
    private String[] finishItems = {"glossy", "matte"};
    private JComboBox<String> finish;
    private String[] timeItems = {"Next Day", "1-Hour"};
    private JComboBox<String> time;
    private JButton submit;
    
    public Mode1() {
        initializeComponents();
        createPanel();
        addListeners();
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        setSize(350, 200);
        setTitle("Photo Print Cost System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void initializeComponents() {
        mainPanel = new JPanel(new BorderLayout());
        formPanel = new JPanel(new GridLayout(4,2));
        quantityLabel = new JLabel("Print Quantity (1 to 100): ");
        sizesLabel = new JLabel("Sizes: ");
        finishLabel = new JLabel("Finish: ");
        timeLabel = new JLabel("Processing Time: ");
        quantityModel = new SpinnerNumberModel(1, 1, 100, 1);
        quantity = new JSpinner(quantityModel);
        sizes = new JComboBox<String>(sizesItems);
        finish = new JComboBox<String>(finishItems);
        time = new JComboBox<String>(timeItems);
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
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(submit, BorderLayout.SOUTH);
    }
    
    private void addListeners() {
        submit.addActionListener(new ButtonListener());
    }
    
    private class ButtonListener implements ActionListener {

        /**
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent aE) {
            JButton b = (JButton) aE.getSource();
            
            if (b.equals(submit)) {
                JOptionPane.showMessageDialog(null, "The total cost for your order is: ");
            }
        }
        
    }
}
