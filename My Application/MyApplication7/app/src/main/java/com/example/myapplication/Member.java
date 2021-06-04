package com.example.myapplication;

public class Member {
    private String Name,email,Contactno,Repaircost,duration, pin;
    private  String DeliveryType, exp;


    public  Member(){}

    public  String getPin()
    {
        return pin;
    }

    public void setPin(String pincode) {
        pin = pincode;
    }





    public  String getName()
    {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public  String getemail()
    {
        return email;
    }

    public void setemail(String Email) {
        email= Email;
    }




    public  String getContactno()
    {
        return Contactno;
    }

    public void setContactno(String contactno) {
        Contactno= contactno;
    }

    public  String getRepaircost()
    {
        return Repaircost;
    }

    public void setRepaircost(String repaircost) {
        Repaircost= repaircost;
    }

    public  String getduration()
    {
        return duration;
    }

    public void setduration(String Duration) {
        duration= Duration;
    }

    public  String getDeliveryType()
    {
        return   DeliveryType;
    }

    public void setDeliveryType(String deliveryType)
    {
        DeliveryType=deliveryType;
    }

    public  String getExp()
    {
        return  exp;
    }

    public void setExp(String Exp)
    {
        exp=Exp;
    }



}
