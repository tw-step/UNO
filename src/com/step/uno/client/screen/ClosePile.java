package com.step.uno.client.screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClosePile extends JPanel {
    JButton draw;

    public ClosePile() {
        draw = new JButton("Draw Cards");
        draw.addActionListener(new OnClick());
        add(draw);
        setVisible(true);
    }

    private class OnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
