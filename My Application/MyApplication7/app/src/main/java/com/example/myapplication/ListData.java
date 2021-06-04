package com.example.myapplication;

public class ListData {
    private String name;
    private String contactno;
    private String pin;
    private String email;
    private String repaircost;
    private String duration;
    private String exp;
    private String deliveryType;

    public  ListData(){


    }

    public ListData( String name,
             String contactno,
             String pin,
             String email,
             String repaircost,
             String duration,
             String exp,String deliveryType) {
        this.contactno = contactno;
        this.name = name;
        this.pin=pin;
        this.email=email;
        this.repaircost=repaircost;
        this.duration=duration;
        this.exp = exp;
        this.deliveryType=deliveryType;
    }

    public String getName() {
        return name;
    }

    public String getContactno() {
        return contactno;
    }

    public String getPin() {
        return pin;
    }
    public String getEmail() {
        return email;
    }
    public String getExp() {
        return exp;
    }
    public String getDuration() {
        return duration;
    }
    public String getRepaircost() {
        return repaircost;
    }
    public String getDeliveryType() {
        return deliveryType;
    }

}

