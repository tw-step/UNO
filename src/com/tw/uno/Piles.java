package com.tw.uno;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Piles {
    private JButton drawButton;

    public Piles() {
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(e.getSource().toString());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
