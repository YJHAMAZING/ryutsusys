package com.wetech.ryutsumodel.model;

public class test {
    protected test(String a,Object b,String c){
        System.out.println("选A");
    }

    protected test(String a,Object b,Object c){
        System.out.println("选B");
    }

    public static void main(String[] args) {
        test t = new test("1","2",null);
    }
}
