package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Speler {
    private int volgnr;
    private int score;
    private int prevScore;
    private List<View> views;

    public Speler(int volgnr){
        views = new ArrayList<>();
        this.score = 0;
        this.volgnr = volgnr;
    }


    public int[] generateRandomDice(int sides, int amount){
        int[] res = new int[amount];
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            res[i] = rand.nextInt(sides)+1;
        }
        return res;
    }

    public int[] throwDice(){
        int[] dice = generateRandomDice(6,2);
        int res = dice[0] + dice[1];
        if(dice[0] == dice[1]) res *= 2;
        if(res == this.prevScore){
            res += 5;
        }
        this.prevScore = res;
        this.score += res;
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

    public int getVolgnr(){
        return this.volgnr;
    }

    public int getScore(){
        return this.score;
    }

    public int getPrevScore(){
        return this.prevScore;
    }
}
