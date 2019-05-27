package com.ssm.demo.controller;


/**
 * 去除double类型无效位的0
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(subZeroAndDot("3.40000900000000"));
    }

    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }


}
