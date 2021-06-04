package com.example.myapplication;

public class Customer {

    private String cname,cemail,ccity,cstate,ccontactno;



    public  Customer(){}
    public  String getcname()
    {
        return cname;
    }

    public void setcname(String name) {
        cname = name;
    }
    public  String getcemail()
    {
        return cemail;
    }

    public void setcemail(String Email) {
        cemail= Email;
    }


    public  String getccity()
    {
        return ccity ;
    }

    public void setccity(String City) {
        ccity= City;
    }

    public  String getcstate()
    {
        return cstate;
    }

    public void setcstate(String State) {
        cstate=State;
    }

    public  String getccontactno()
    {
        return ccontactno;
    }

    public void setccontactno(String contactno ) {
        ccontactno= contactno;
    }

  }
