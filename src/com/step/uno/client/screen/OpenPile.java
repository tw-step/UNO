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
        openPile.setText(snapshot.openCard.sign.toString());
        openPile.setBackground(getColor());
        openPile.setPreferredSize(new Dimension(150, 200));
        openPile.setFont(new Font("vardana", Font.BOLD, 18));
        add(openPile);
        setVisible(true);
    }

    private Color getColor() {

        Map<Colour,Color> colorMap = new HashMap<>();
        colorMap.put(Colour.Black,Color.black);
        colorMap.put(Colour.Red,Color.red);
        colorMap.put(Colour.Green,Color.green);
        colorMap.put(Colour.Blue,Color.blue);
        colorMap.put(Colour.Yellow,Color.yellow);

        return colorMap.get(snapshot.openCard.colour);
    }

    public void update(Snapshot snapshot) {
        this.snapshot = snapshot;
        openPile.setText(snapshot.openCard.sign.toString());
        openPile.setBackground(getColor());
    }
}
