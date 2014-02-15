package com.tw.uno;

import java.awt.Container;

import org.swixml.SwingEngine;

public class Starter {


    public static void main(String[] args) throws Exception {
        SwingEngine se = new SwingEngine();
        Container container = se.render("xml/Starter.xml");
        container.setVisible(true);
    }

}