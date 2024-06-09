/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utlis;

import com.edusys.entity.NhanVien;

/**
 *
 * @author Nam
 */
public class Auth {
//   doi tuong chua thong tin khi nguoi dung dang nhap
    public static NhanVien user=null;
//    clear thong tin khi dang xuat
    public static void clear(){
        Auth.user=null;
    }
//    KT dang nhap hay chua
   public static boolean isLogin(){
       return Auth.user !=null;
   }
   public static boolean isManager(){
       return Auth.isLogin() && user.isVaiTro();
   }
}
