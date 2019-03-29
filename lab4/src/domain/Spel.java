package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Spel {
    private int beurt;
    private Set<Speler> spelers;
    private List<View> views;

    public Spel(int beurt){
        setBeurt(0);
        spelers = new HashSet<>();
    }


    public int[] generateRandomDice(int sides, int amount){
        int[] res = new int[amount];
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            res[i] = rand.nextInt(sides)+1;
        }
        return res;
    }

    public int[] throwDice(Speler s){
        int[] dice = generateRandomDice(6,2);
        int res = dice[0] + dice[1];
        if(dice[0] == dice[1]) res *= 2;
        if(res == s.getPrevScore()){
            res += 5;
        }
        s.setPrevScore(res);
        s.addscore(res);
        return dice;
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
    public void updateDisplays(){
        
    }

    public int getBeurt() {
        return beurt;
    }

    public void setBeurt(int beurt) {
        this.beurt = beurt;
    }
}
