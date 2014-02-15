package com.tw.uno;

public class RunIt{
    public static void main(String[] args) {
        try {
            new Color();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}