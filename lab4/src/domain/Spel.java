package domain;

import java.util.*;

public class Spel implements ObservableVanMichiel {
    private int beurt;
    private int ronde;
    private List<Speler> spelers;
    private List<View> views;

    public Spel(){
        setRonde(1);
        setBeurt(1);
        spelers = new ArrayList<>();
        this.views = new ArrayList<>();
    }

    public void gooi(Speler speler){
        speler.throwDice();
        if(beurt >= spelers.size()){
            beurt = 1;
            ronde++;
        } else {
            beurt += 1;
        }
        updateViews();
    }

    //add view to list
    public void addView(View view){
        this.views.add(view);
    }

    //remove view from list
    public void removeView(View view){
        this.views.remove(view);
    }

    //update all views in list
    public void updateViews(){
        for(View v : views){
            v.update();
        }
    }

    public Speler getSpeler(int nr){
        for(Speler s : spelers){
            if(s.getVolgnr() == nr){
                return s;
            }
        }
        return null;
    }

    public int getBeurt() {
        return beurt;
    }

    public void setBeurt(int beurt) {
        this.beurt = beurt;
    }

    public void addSpeler(Speler speler){
        this.spelers.add(speler);
    }

    public Speler getSpeler(){
        return getSpeler(this.beurt);
    }

    public int getRonde(){
        return this.ronde;
    }

    private void setRonde(int ronde){
        this.ronde = ronde;
    }

    public String getScoreLijn() {
        String res = "Beurt " + this.ronde + ":";
        for (int i = 1; i < spelers.size()+1; i++) {
            res += "sp" + i + ": " + getSpeler(i).getPrevScore() + " ";
        }
        return res;
    }
}
