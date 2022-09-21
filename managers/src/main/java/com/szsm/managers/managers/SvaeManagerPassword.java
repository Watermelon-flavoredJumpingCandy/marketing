package com.szsm.managers.managers;

import java.util.Scanner;

public class SvaeManagerPassword {
    //数字
    public static final String REG_NUMBER = ".*\\d+.*";
    //大写字母
    public static final String REG_UPPERCASE = ".*[A-Z]+.*";
    //小写字母
    public static final String REG_LOWERCASE = ".*[a-z]+.*";
    //特殊符号
    public static final String REG_SYMBOL = ".*[~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"]+.*";



//    public static void main(String[] args) {
//        System.out.println("请输入密码：");
//        Scanner scanner=new Scanner(System.in);
//        String pwd=scanner.nextLine();
//
//        checkPasswordRule(pwd,scanner);
//        scanner.close();
//
//    }
    public void checkPassword(){
        System.out.println("请输入密码：");
        Scanner scanner=new Scanner(System.in);
        String pwd=scanner.nextLine();
        checkPasswordRule(pwd,scanner);
        scanner.close();
    }

    public static boolean checkPasswordRule(String password,Scanner input) {
        //密码为空或者长度小于位则返回false
        if (password == null || password.length() < 8) {
            System.out.println("密码为空或者长度小于8位 请重新输入：");
//            Scanner scanner=new Scanner(System.in);
            String pwd=input.nextLine();
            checkPasswordRule(pwd,input);
            return false;
        }else{
            int i = 0;
            if (password.matches(REG_NUMBER)) i++;
            if (password.matches(REG_LOWERCASE)) i++;
            if (password.matches(REG_UPPERCASE)) i++;
            if (password.matches(REG_SYMBOL)) i++;
            if(i<3){
                System.out.println("密码输入有误 请重新输入带有数字字母特殊符合的密码：");
//                Scanner scanner=new Scanner(System.in);
                String pwd=input.nextLine();
                checkPasswordRule(pwd,input);
                return false;
            }else{
                System.out.println("密码设置成功！");
                return true;
            }
        }

    }
}
