package com.dan;

import static javax.swing.JOptionPane.*;

public class Main {
    public static void showWarningMessage(String text, String title) {
        showMessageDialog(null, text, title, WARNING_MESSAGE);
    }/*from  w w  w  . java  2 s  . c  o m*/

    public static void showWarningMessage(String text) {
        showWarningMessage(text, "Error");
    }
}
