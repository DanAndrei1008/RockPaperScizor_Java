package com.dan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab3 extends JFrame
        implements ActionListener {
    private JPanel panel;
    private JButton button;

    public static void main(String[] args) {
        Lab3 frame = new Lab3();
        frame.setSize(350, 400);//from   w w w .  j av a 2  s.c  o  m
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout() );
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));
        panel.setBackground(Color.white);
        window.add(panel);
        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event) {
        int deepEnd;
        int shallowEnd;
        Graphics paper = panel.getGraphics();

        String inputString;//used to read an input

        inputString = JOptionPane.showInputDialog("Deep End: ");
        deepEnd = Integer.parseInt(inputString);
        inputString = JOptionPane.showInputDialog("Shallow End: ");
        shallowEnd = Integer.parseInt(inputString);

        JOptionPane.showMessageDialog(null,"Volume: " + calculateVolume
                (20,5,deepEnd,shallowEnd)); // Here we call for the volume.
        drawPool(paper, 10, 10, deepEnd, shallowEnd, 20); // Draw the pool.

    }

    private void drawPool(Graphics paper, int x, int y, int deepEnd,
                          int shallowEnd, int length) {
        length = length * 10;   // The following 3 variables are scaled up by
        deepEnd = deepEnd * 10; // By a factor of 10 for easy viewing.
        shallowEnd = shallowEnd * 10; // We assume small dimensions are given
        paper.drawLine(x,y,x + length,y); // Draw the top rim of the pool
        paper.drawLine(x,y,x,(y + deepEnd)); // Draw deep end wall
        paper.drawLine((x + length),y,(x + length),(y + shallowEnd));
        // Above we draw the shallow end wall.
        paper.drawLine((x + length),(y + shallowEnd), x ,(y + deepEnd));
        // Above we draw the line between the bottoms of the walls.
    }

    private double calculateVolume(int length, int width, int deepEnd,
                                   int shallowEnd) {
        double volume; // The volume may be a decimal.
        double average; // The average we calculate below may be a decimal.
        average = (deepEnd + shallowEnd) / 2.0; // Determine average of depth
        volume = (length * width) * average; // Calculate the volume
        return volume; // Return the volume calculated above
    }
}
