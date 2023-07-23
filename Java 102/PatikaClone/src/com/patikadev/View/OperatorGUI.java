package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private DefaultTableModel mdl_user_list;

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
        lbl_welcome.setText("Welcome : " + operator.getName());

        // ModelUserList

        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Name and Surname", "Username", "Password", "Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        for(User obj : User.getList()){
            Object[] row = new Object[col_user_list.length];
            row[0] = obj.getId();
            row[1] = obj.getName();
            row[2] = obj.getUname();
            row[3] = obj.getPass();
            row[4] = obj.getType();
            mdl_user_list.addRow(row);
        }

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
