package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
public static void setLayout(){
    for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
        if(info.getName().equals("Nimbus")){
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
}
