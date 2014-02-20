package com.step.uno.client.screen;

import com.step.communication.channel.MessageChannel;
import com.step.uno.messages.DrawCardAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClosePile extends JPanel {
    JButton draw;
    MessageChannel communicationChannel;
    public ClosePile(MessageChannel communicationChannel) {

        this.communicationChannel = communicationChannel;

        draw = new JButton("Draw Cards");
        draw.addActionListener(new OnClick());
        add(draw);
        setVisible(true);
    }

    private class OnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            communicationChannel.send(new DrawCardAction());
        }
    }
}
