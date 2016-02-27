/**
 * Main.java 1.0 Feb 26, 2016
 * 
 * Copyright (c) 2016 James C. Adams IV. All Rights Reserved
 */
package edu.ecu.ppcs;

import javax.swing.JOptionPane;

/**
 * Start each class or interface with summary description line
 * 
 * @author jamesadams
 * @version 1.0
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) { 
      Object[] options = {"Mode 1", "Mode 2"};
      int mode = JOptionPane.showOptionDialog(null, "Pick a mode:\n\nMode 1: All prints must have the same size, finish, and processing time.\n"
                      + "Mode 2: Each print can have a different size, finish, and processing time.", "Photo Print Cost System",
                      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                      options, options[0]);
    
      if (mode == 0) {
          Mode1 mode1 = new Mode1();
      }
  }

}
