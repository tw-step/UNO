package com.tw.uno;

import javax.swing.*;

public class CenterTable extends JPanel{

    private Draw draw;
    private StatusHint statusHint;

    public CenterTable(){
        try {
            statusHint = new StatusHint(700, 700, 200, 100);
            draw = new Draw();

        } catch (Exception e) {
            e.printStackTrace();
        }

        draw.setBounds(0,0,100,100);

        add(statusHint);
        add(draw);

    }

    public static void main(String[] args) {
        new CenterTable();
    }

}
