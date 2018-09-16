package com.example.ahmedd.ecommerce.Model;

public class ItemView {


    String hotSummer;
    int summerImg;

    public ItemView(int summerImg) {
        this.summerImg = summerImg;
    }

    public ItemView(String hotSummer, int summerImg) {
        this.hotSummer = hotSummer;
        this.summerImg = summerImg;
    }

    public String getHotSummer() {
        return hotSummer;
    }

    public void setHotSummer(String hotSummer) {
        this.hotSummer = hotSummer;
    }

    public int getSummerImg() {
        return summerImg;
    }

    public void setSummerImg(int summerImg) {
        this.summerImg = summerImg;
    }
}
