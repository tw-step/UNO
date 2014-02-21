package com.step.uno.client.screen;

import com.step.uno.messages.Snapshot;

import javax.swing.*;
import java.awt.*;

public class ActivityLog extends JPanel {

    private final JPanel logPanel =new JPanel();
    private JScrollPane scrollPane = new JScrollPane();

    public ActivityLog() {
        logPanel.add(new Label("Activity Log"));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.add(logPanel);
        add(scrollPane);
        setVisible(true);
    }

    public void update(Snapshot snapshot) {

    }
}
