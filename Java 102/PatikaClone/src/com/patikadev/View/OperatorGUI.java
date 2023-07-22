package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;

import javax.swing.*;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
//        Helper.setLayout();
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.getScreenCenter("x", getSize()),Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.setId(1);
        operator.setName("Hasan Burak Songur");
        operator.setUname("hburaks");
        operator.setPass("1234");
        operator.setType("Operator");
        OperatorGUI oGui = new OperatorGUI(operator);
    }}
