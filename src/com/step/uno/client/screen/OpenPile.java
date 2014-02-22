package com.step.uno.client.screen;

import com.step.uno.messages.Snapshot;
import com.step.uno.model.Colour;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class OpenPile extends JPanel{
    JButton openPile = new JButton();
    private Snapshot snapshot;

    public OpenPile(Snapshot snapshot) {
        this.snapshot = snapshot;
        String part = changeSign(snapshot);

        openPile.setText(part);
        openPile.setBackground(getColor());
        openPile.setPreferredSize(new Dimension(100, 150));
        openPile.setFont(new Font("vardana", Font.BOLD, 18));
        add(openPile);
        setVisible(true);
    }

    private String changeSign(Snapshot snapshot) {
        String sign = snapshot.openCard.sign.name();
        String part = snapshot.openCard.sign.name();
        if (sign.startsWith("_"))
            part = sign.split("_")[1];
        return part;
    }

    private Color getColor() {

        Map<Colour,Color> colorMap = new HashMap<>();
        colorMap.put(Colour.Black,new Color(10, 18, 42));
        colorMap.put(Colour.Red,new Color(254,46,46));
        colorMap.put(Colour.Green,new Color(1,223,58));
        colorMap.put(Colour.Blue,new Color(46, 204, 250));
        colorMap.put(Colour.Yellow,new Color(247,254,46));

        return colorMap.get(snapshot.openCard.colour);
    }

    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        String part = changeSign(snapshot);
        openPile.setText(part);
        openPile.setBackground(getColor());
    }
}
