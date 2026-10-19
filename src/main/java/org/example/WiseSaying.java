package org.example;

public class WiseSaying {
    String text = "";
    String auth = "";

    public String getAuth() {
        return auth;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String toString() {
        return  auth + " / " + text;
    }
}