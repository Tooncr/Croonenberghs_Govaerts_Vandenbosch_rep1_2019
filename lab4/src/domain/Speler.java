package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Speler {
    private int volgnr;
    private int score;
    private int prevScore;

    public Speler(int volgnr){
        setScore(0);
        setVolgnr(volgnr);
    }

    public void addscore(int tempScore){
        this.score+=tempScore;
    }

    public void setVolgnr(int volgnr) {
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
