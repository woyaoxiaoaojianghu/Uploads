package com.qf.dao.Impl;

import com.qf.Utils.DBUtils;
import com.qf.dao.IUser;
import com.qf.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class UserDaoImpl implements IUser {
    @Override
    public int addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        int i = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into register (username,password,email,`name`,phone,sex,birthday) value (?,?,?,?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getName());
            ps.setString(5,user.getPhone());
            ps.setString(6,user.getSex());
            Date birthday3 = user.getBirthday();
            java.sql.Date birthday = new java.sql.Date(birthday3.getTime());
            ps.setDate(7,birthday);
            i = ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtils.close(conn,ps);
        }
        return i;
    }
}
