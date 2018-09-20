package com.example.ahmedd.ecommerce.Model;

public class ItemView {


    String hotSummer , placeText,txt;
    int summerImg , placeImg;

    public ItemView(int summerImg) {
        this.summerImg = summerImg;
    }

    public ItemView(int summerImg, String hotSummer, String txt ) {
        this.summerImg = summerImg;
        this.hotSummer =hotSummer;
        this.txt = txt;
    }

    public ItemView(String placeText, int placeImg) {
        this.placeText = placeText;
        this.placeImg = placeImg;
    }

    public String getPlaceText() {
        return placeText;
    }

    public int getPlaceImg() {
        return placeImg;
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
