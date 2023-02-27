package com.example.blood;

public class Doner {
    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBlood(String blood) {
        Blood = blood;
    }

    public void setUpozela(String upozela) {
        Upozela = upozela;
    }

    public void setZela(String zela) {
        Zela = zela;
    }

    public void setDd(int Rday){x=Rday;}
    public void setMm(int Rmonth){y = Rmonth;}
    public void setYy(int Ryear){z =Ryear;}

    private String Mobile;
    private String Name;
    private String Blood;
    private String Upozela;
    private String Zela;
    private int x,y,z;

    public Doner() {

    }

    public Doner(String mobile, String name, String blood, String upozela, String zela, int Rday,int Rmonth,int Ryear) {
        Mobile = mobile;
        Name = name;
        Blood = blood;
        Upozela = upozela;
        Zela = zela;
        x = Rday;
        y = Rmonth;
        z = Ryear;

    }


    public String getMobile() {
        return Mobile;
    }

    public String getName() {
        return Name;

    }


    public String getBlood() {
        return Blood;
    }


    public String getUpozela() {
        return Upozela;
    }

    public String getZela() {
        return Zela;
    }
    public int getDd(){return x;}
    public int getMm(){return y;}
    public int getYy(){return z;}


}
