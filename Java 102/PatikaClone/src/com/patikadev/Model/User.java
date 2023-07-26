package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String uname;
    private String pass;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userlist = new ArrayList<>();
        String query = "SELECT * FROM \"user\"";
        User obj;
        try {
            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("user_type"));
                userlist.add(obj);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userlist;
    }

    public static boolean add(String name, String uname, String pass, String user_type) {
        String query = "INSERT INTO \"user\" (name, uname, pass, user_type) VALUES (?,?,?,?)";
        User findUser = User.getFetch(uname);
        if (findUser != null) {
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, user_type);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public static User getFetch(String uname) {
        User obj = null;
        String query = "SELECT * FROM \"user\" WHERE uname = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, uname);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("user_type"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return obj;
    }
    public static User getFetch(int id){
        User obj = null;
        String query = "SELECT * FROM \"user\" WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new User();
                obj.setId((rs.getInt("id")));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("user_type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static boolean delete(int userId) {
        User obj = null;
        String query1 = "SELECT * FROM \"user\" WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query1);
            pr.setInt(1, userId);
            ResultSet rs = pr.executeQuery();
            if (!rs.next()) {
                return false;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String query2 = "DELETE  FROM \"user\" WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query2);
            pr.setInt(1, userId);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;

    }

    public static boolean update(int id, String name, String uname, String pass, String type) {
        String query = "UPDATE \"user\" SET name=?, uname=?, pass=?, user_type=? WHERE id = ?";
        User findUser = User.getFetch(uname);
        if (findUser != null && findUser.getId() != id) {
            Helper.showMsg("error");
            return false;
        }
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            pr.setInt(5, id);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return true;
        }
    }

    public static ArrayList<User> searchUserList(String query){

        return getUsers(query);
    }

    public static String searchQuery(String name,String uname,String user_type){
        String query = "SELECT * FROM \"user\" WHERE uname LIKE '%{{uname}}%' AND name ILIKE '%{{name}}%'";
        query = query.replace("{{uname}}", uname);
        query = query.replace("{{name}}",name);
        if (!user_type.isEmpty()){
            query += " AND user_type='{{user_type}}'";
            query = query.replace("{{user_type}}",user_type);
        }
        return query;
    }



    private static ArrayList<User> getUsers(String query) {

        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {

            Statement st = DBConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new User();
                obj.setId((rs.getInt("id")));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("user_type"));
                userList.add(obj);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
