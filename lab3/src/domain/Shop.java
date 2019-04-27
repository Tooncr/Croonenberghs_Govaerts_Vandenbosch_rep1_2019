package domain;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Feestartikel> feestartikels;

    public Shop(){
        feestartikels = new ArrayList<>();
    }

    public Feestartikel zoekFeestArtikel(String description){
        Feestartikel a = null;
        for(Feestartikel f : feestartikels){
            if(f.getDescription().equals(description)){
                a = f;
            }
        }
        return a;
    }

    public void addFeestArtikel(Feestartikel artikel){
        this.feestartikels.add(artikel);
        artikel.setUitleenbaar();
    }

    public void removeFeestArtikel(String description){
        zoekFeestArtikel(description).setVerwijderd();
    }

    public void leenFeestArtikel(String description){
        zoekFeestArtikel(description).setUitgeleend();
    }

    public void brengFeestArtikelTerug(String description){
        zoekFeestArtikel(description).setUitleenbaar();
    }

    public void beschadigFeestArtikel(String description){
        zoekFeestArtikel(description).setBeschadigd();
    }

    public void herstelFeestArtikel(String description){
        zoekFeestArtikel(description).setUitleenbaar();
    }

    public String toonFeestArtikels(){
        String res = "";
        for(Feestartikel f : feestartikels){
            if(!(f.getState() instanceof Verwijderd)){
                res += f + "\n";
            }
        }
        return res;
    }
}
