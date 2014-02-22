package com.step.uno.client.screen;

import com.step.uno.messages.Snapshot;

import javax.swing.*;
import java.awt.*;

public class ActivityLog extends JPanel {

    private final JPanel logPanel =new JPanel();
    private JScrollPane scrollPane = new JScrollPane();

    public ActivityLog() {
        Label activityLable = new Label("Activity Log");
        activityLable.setFont(new Font("vardana", Font.BOLD, 22));
        logPanel.add(activityLable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        logPanel.setVisible(true);
        scrollPane.getViewport().add(logPanel);

        scrollPane.setPreferredSize(new Dimension(200, 700));

        add(scrollPane);
        setVisible(true);

    }

    public void update(Snapshot snapshot) {
        String lastPlayerName=snapshot.playerSummaries[snapshot.currentPlayerIndex].name;
        logPanel.add( new TextArea(snapshot.openCard.toString() +"was played by"+lastPlayerName));

   }
}
