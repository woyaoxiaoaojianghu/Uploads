package com.qf.dao.Impl;

import com.qf.Utils.DBUtils;
import com.qf.dao.IUser2;
import com.qf.entity.User2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User2DaoImpl implements IUser2 {
    @Override
    public void add(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into account (username,password) value (?,?)");
            ps.setString(1,username);
            ps.setString(2,password);
            int i = ps.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            DBUtils.close(conn,ps);
        }
    }

    @Override
    public User2 see(User2 user2) {
        User2 use = new User2();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from account where username = ? and password = ?");
            ps.setString(1,use.getUsername());
            ps.setString(2,use.getPassword());
            res = ps.executeQuery();
            if (res.next()){
                String username = res.getString("username");
                String password = res.getString("password");
                use.setPassword(password);
                use.setUsername(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            DBUtils.close(conn,ps,res);
        }
        return use;
    }
}
