package ui;

import domain.Shop;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JoptionpaneUI ui = new JoptionpaneUI(new Shop());
        ui.start();
    }
}
