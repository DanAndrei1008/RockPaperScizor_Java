package com.dan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab5 extends JFrame implements ActionListener {

    private JButton okButton; // Here we create all the GUI elements
    private JTextField dayField, monthField, yearField;
    private JLabel dayLabel, monthLabel, yearLabel;
    /*from   w  ww .jav  a 2 s  .  co m*/
    public static void main(String[] args) {
        Lab5 paper = new Lab5();
        paper.setSize(400,100); // Setting up the pane
        paper.createGUI();
        paper.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        dayLabel = new JLabel("Day:"); // Setting up the labels
        window.add(dayLabel);
        dayField = new JTextField(3); // Setting up the fields
        window.add(dayField);
        monthLabel = new JLabel("Month:"); // Setting up the labels
        window.add(monthLabel);
        monthField = new JTextField(3); // Setting up the fields
        window.add(monthField);
        yearLabel = new JLabel("Year:"); // Setting up the labels
        window.add(yearLabel);
        yearField = new JTextField(3); // Setting up the fields
        window.add(yearField);
        okButton = new JButton("Ok"); // Setting up the Button
        window.add(okButton);
        okButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event){
        String dayString = dayField.getText();    // Here we  grab and parse
        int day = Integer.parseInt(dayString);    // The input
        String monthString = monthField.getText();
        int month = Integer.parseInt(monthString);
        String yearString = yearField.getText();
        int year = Integer.parseInt(yearString);
        int maxdays = getMaxDays(month,year);

        if (maxdays < day || day <= 0 || year < 0){
            // We define months not 1-12 as maxdays = 0, this grabs them as
            // well as invalid days.
            JOptionPane.showMessageDialog(null,"Invalid Date!");
        }else if (month == 12 && day == maxdays){ // Catches new years
            year++;
            month = 1;
            day = 1;
            JOptionPane.showMessageDialog(null, "Tomorrow is " + day + "/" +
                    month + "/" + year + ".");
        } else if (day == maxdays) { // Catches new months
            month++;
            day = 1;
            JOptionPane.showMessageDialog(null, "Tomorrow is " + day + "/" +
                    month + "/" + year + ".");
        } else {
            day++;
            JOptionPane.showMessageDialog(null, "Tomorrow is " + day + "/" +
                    month + "/" + year + ".");
        }
    }
    private int getMaxDays(int month, int year){
        int maxdays;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                maxdays = 31;
                break;
            case 2:
                if (year % 400 ==0){
                    maxdays = 29;
                }else if (year % 100 ==0){
                    maxdays = 28;
                } else if (year % 4 == 0){
                    maxdays = 29;
                }else maxdays = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxdays = 30;
                break;
            default:
                maxdays = 0;
                break;
        }
        return maxdays;
    }
}