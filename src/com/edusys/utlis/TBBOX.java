/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utlis;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Nam
 */
public class TBBOX {
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message,"HỆ THỐNG QUẢN LÝ ĐÀO TẠO",JOptionPane.INFORMATION_MESSAGE);
    }
//    xac nhan
    public static boolean confirm(Component parent,String message){
        int result= JOptionPane.showConfirmDialog(parent, message,"HỆ THỐNG QUẢN LÝ ĐÀO TẠO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static String prompt(Component parent,String message){
        return JOptionPane.showInputDialog(parent,message, "HỆ THỐNG QUẢN LÝ ĐÀO TÀO",JOptionPane.INFORMATION_MESSAGE);
    }
}
