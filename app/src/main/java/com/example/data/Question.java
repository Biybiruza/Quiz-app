package com.example.data;

public class Question {
    int img;
    String a;
    String b;
    String c;
    int trueAnswer;

    public Question(int img, String a, String b, String c, int trueAnswer) {
        this.img = img;
        this.a = a;
        this.b = b;
        this.c = c;
        this.trueAnswer = trueAnswer;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public int getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(int trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
