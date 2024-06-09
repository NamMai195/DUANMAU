/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utlis;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nam
 */
public class JdbcHelper {
    private static  String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static  String dburl="jdbc:sqlserver://localhost:1433;databaseName=QLKHDAM_PS38841;encrypt=true;trustServerCertificate=true;";
    private static String user="sa";
    private static String pass="123";
//    nap driver
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    /*
    Xây dựng preparedStatement
    @pẩm sql là câu chứa lệnh sql có thể chứa tham số nó có thể 
    là lời gọi thủ tục
    */
public static PreparedStatement getStmt (String sql, Object ... args) throws SQLException{
        Connection connection = DriverManager. getConnection (dburl, user, pass) ;
        PreparedStatement pstmt = null;
        if (sql.trim() .startsWith ("{") ) {
            pstmt = connection.prepareCall (sql) ;
        } else {
            pstmt = connection.prepareStatement (sql) ;
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject (i + 1, args[i]) ;
        }
            return pstmt;
        }
/*
    Xây dựng update*/
public static  int update(String sql,Object... args){
    try {
        PreparedStatement stmt = getStmt(sql, args);
        try {
            return stmt.executeUpdate();
        } finally {
            stmt.getConnection().close();
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
/*
    Xây dựng qeryyy*/
public static  ResultSet query(String sql,Object...args){
    try {
        PreparedStatement stmt =getStmt(sql, args);
        return stmt.executeQuery();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
/*
    Xây dựng value oj*/
public static Object value(String sql,Object...args){
    try {
        ResultSet rs=query(sql, args);
        if (rs.next()) {
            return rs.getObject(0);
        }
        rs.getStatement().getConnection().close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return null;
}
}
