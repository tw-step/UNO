package com.step.uno.client.screen;

import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.Snapshot;

import javax.swing.*;
import java.awt.*;
import java.awt.peer.TextFieldPeer;

public class ActivityLog extends JPanel implements PlayerView {

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

        scrollPane.setPreferredSize(new Dimension(300, 1200));

        add(scrollPane);
        setVisible(true);

    }

    @Override
    public void showDisconnected() {

    }

    public void update(Snapshot snapshot) {
        String lastPlayerName=snapshot.playerSummaries[snapshot.currentPlayerIndex].name;
        logPanel.add( new TextArea(snapshot.openCard.toString() +"was played by"+lastPlayerName));

   }
}
