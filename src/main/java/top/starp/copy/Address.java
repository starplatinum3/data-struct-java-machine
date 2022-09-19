package top.starp.copy;

//public class Address {
//    private String provices;
//    private String city;
//    public void setAddress(String provices,String city){
//        this.provices = provices;
//        this.city = city;
//    }
//    @Override
//    public String toString() {
//        return "Address [provices=" + provices + ", city=" + city + "]";
//    }
//
//}

//package com.ys.test;

public class Address implements Cloneable
,java.io.Serializable{
    private String provices;
    private String city;
    public void setAddress(String provices,String city){
        this.provices = provices;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address [provices=" + provices + ", city=" + city + "]";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
