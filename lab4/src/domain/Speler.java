package domain;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Speler {
    private int volgnr;
    private int[] dice;
    private int score;
    private int prevScore;

    public Speler(int volgnr){
        dice = new int[2];
        setScore(0);
        setVolgnr(volgnr);
    }

    public String printDice(){
        return dice[0] + " en " + dice[1];
    }

    public int[] generateRandomDice(int sides, int amount){
        int[] res = new int[amount];
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            res[i] = rand.nextInt(sides)+1;
        }
        this.dice = res;
        return res;
    }

    public int[] throwDice(){
        int[] dice = generateRandomDice(6,2);
        int res = dice[0] + dice[1];
        if(dice[0] == dice[1]) res *= 2;
        if(res == this.getPrevScore()){
            res += 5;
        }
        this.setPrevScore(res);
        this.addscore(res);
        return dice;
    }

    public void addscore(int tempScore){
        this.score+=tempScore;
    }

    private void setVolgnr(int volgnr) {
        this.volgnr = volgnr;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPrevScore(int prevScore) {
        this.prevScore = prevScore;
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
