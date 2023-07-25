package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JTextField fld_user_name;
    private JPanel pnl_user_form;
    private JTextField fld_user_uname;
    private JTextField fld_user_password;
    private JComboBox cmb_user_type;
    private JButton btn_user_add;
    private JTextField fld_user_id_delete;
    private JButton btn_user_delete;
    private JTextField fld_sh_user_name;
    private JTextField fld_sh_user_uname;
    private JComboBox cmb_sh_user_type;
    private JButton btn_user_sh;
    private DefaultTableModel mdl_user_list;
    Object[] row_user_list;

    private Operator operator;

    public OperatorGUI(Operator operator) {
        this.operator = operator;
//        Helper.setLayout();
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.getScreenCenter("x", getSize()), Helper.getScreenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Welcome : " + operator.getName());

        // ModelUserList

        mdl_user_list = new DefaultTableModel();
        Object[] col_user_list = {"ID", "Name and Surname", "Username", "Password", "Type"};
        mdl_user_list.setColumnIdentifiers(col_user_list);
        row_user_list = new Object[col_user_list.length];

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);

        loadUserModel();

        btn_user_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_name) | Helper.isFieldEmpty(fld_user_uname) | Helper.isFieldEmpty(fld_user_password)) {
                Helper.showMsg("empty");
            } else {
                String name = fld_user_name.getText();
                String uname = fld_user_uname.getText();
                String pass = fld_user_password.getText();
                String type = cmb_user_type.getSelectedItem().toString();
                if (User.add(name, uname, pass, type)) {
                    Helper.showMsg("success");
                    loadUserModel();
                    fld_user_password.setText(null);
                    fld_user_uname.setText(null);
                    fld_user_name.setText(null);
                } else {
                    Helper.showMsg("error");
                }
            }

        });

        btn_user_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_id_delete)) {
                Helper.showMsg("empty");
            } else {
                try {
                    int userId = Integer.parseInt(fld_user_id_delete.getText());
                    if (User.delete(userId)) {
                        loadUserModel();
                        Helper.showMsg("success");
                    } else {
                        loadUserModel();
                        Helper.showMsg("error");
                    }
                } catch (NumberFormatException ex) {
                    Helper.showMsg("error");
                }
            }
        });

        tbl_user_list.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int user_id = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String user_name = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String user_uname = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String user_pass = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                String user_type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();
                if (User.update(user_id, user_name, user_uname, user_pass, user_type)) {
                    Helper.showMsg("success");
                }
                loadUserModel();
            }
        });

        btn_user_sh.addActionListener(e -> {
            String name = fld_sh_user_name.getText();
            String uname = fld_sh_user_uname.getText();
            String type = cmb_sh_user_type.getSelectedItem().toString();
            String query = User.searchQuery (name, uname, type);
            ArrayList<User> searchingUser = User.searchUserList (query);
            loadUserModel(searchingUser);
            fld_sh_user_name.setText(null);
            fld_user_uname.setText(null);
        });
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.setId(1);
        operator.setName("Hasan Burak Songur");
        operator.setUname("hburaks");
        operator.setPass("1234");
        operator.setType("Operator");
        OperatorGUI oGui = new OperatorGUI(operator);
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel();
        clearModel.setRowCount(0);
        for (User obj : User.getList()) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }

    public void loadUserModel(ArrayList<User> list){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_user_list.getModel () ;
        clearModel.setRowCount(0);
        for (User obj : list) {
            int i = 0;
            row_user_list[i++] = obj.getId();
            row_user_list[i++] = obj.getName();
            row_user_list[i++] = obj.getUname();
            row_user_list[i++] = obj.getPass();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }
    }
}
