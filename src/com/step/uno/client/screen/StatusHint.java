package com.step.uno.client.screen;

import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;

import javax.swing.*;
import java.awt.*;

public class StatusHint extends JPanel implements PlayerView{

    private final JLabel hint;

    public StatusHint() {
        hint =new JLabel("skdltgspodfig");
        setBackground(new Color(128, 26, 21));
//        setPreferredSize(new Dimension(200,200));
        add(hint);
//        setSize(200, 200);
        setVisible(true);
    }

    @Override
    public void showDisconnected() {

    }

    @Override
    public void update(Snapshot snapshot) {
        hint.setText("please put a "+snapshot.runningColour+" card");
    }
}
