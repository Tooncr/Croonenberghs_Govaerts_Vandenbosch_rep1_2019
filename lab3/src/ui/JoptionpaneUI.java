package ui;

import domain.Feestartikel;
import domain.Shop;

import javax.swing.*;

public class JoptionpaneUI {
    private Shop shop;

    public JoptionpaneUI(Shop shop){
        this.shop = shop;
    }

    public void start(){
        while (true) {
            String txt = "1. Add party item\n2. Remove party item\n" +
                    "3. Rent party item\n4. Return party item\n" +
                    "5. Repair party item\n6. Show available party items\n\n" +
                    "0. Stop\n\n Make your choice:";
            String option = JOptionPane.showInputDialog(txt);
            switch (Integer.parseInt(option)) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    rentItem();
                    break;
                case 4:
                    returnItem();
                    break;
                case 5:
                    repairItem();
                    break;
                case 6:
                    showItems();
                    break;
                case 0:
                    stop();
                    break;
                default:
                    stop();
            }
        }
    }


    private void addItem(){
        String name = JOptionPane.showInputDialog("name of the item");
        double price = Double.parseDouble(JOptionPane.showInputDialog("price"));
        Feestartikel f = new Feestartikel(name, price);
        shop.addFeestArtikel(f);
    }

    private void removeItem(){
        String name = JOptionPane.showInputDialog("name of the item");
        shop.removeFeestArtikel(name);
    }

    private void rentItem(){
        String name = JOptionPane.showInputDialog("name of the item");
        shop.leenFeestArtikel(name);
    }

    private void returnItem(){
        String name = JOptionPane.showInputDialog("name of the item");
        shop.brengFeestArtikelTerug(name);
    }

    private void repairItem(){
        String name = JOptionPane.showInputDialog("name of the item");
        shop.herstelFeestArtikel(name);
    }

    private void showItems(){
        JOptionPane.showMessageDialog(null, shop.toonFeestArtikels());
    }

    private void stop(){
        System.exit(0);
    }
}
