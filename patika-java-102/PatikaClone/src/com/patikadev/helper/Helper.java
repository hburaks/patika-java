package com.patikadev.helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setLayout() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static int getScreenCenter(String axis, Dimension size) {
        int point;

        switch (axis) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }
    public static boolean isFieldEmpty(JEditorPane field) {
        return field.getText().trim().isEmpty();
    }

    public static void showMsg(String str) {
        String msg ="";
        String title = "";
        if(str == "empty"){
            msg = "Please, fill all the inputs";
            title = "Error!";
        } else if (str == "success") {
            msg = "Success";
            title = "Result";
        } else if(str == "error"){
            msg = "There is an error!";
            title = "Error!";
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);

    }

    public static boolean confirm(String str){
        String msg;
        switch (str){
            case "sure":
                msg = "Are you sure?";
                break;
            default:
                msg=str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Final decision?", JOptionPane.YES_NO_OPTION) == 0;
    }
}
