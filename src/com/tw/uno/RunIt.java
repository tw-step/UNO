package com.tw.uno;

import javax.swing.*;
import java.awt.*;

public class RunIt extends JFrame{
    private String title;

    public RunIt(String title) throws HeadlessException {
        this.title = title;
        setVisible(true);
        setBounds(20,20,500,500);
        try {
            add(new StatusHint(0,0,100,100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new RunIt("Status Hint Positioning");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}