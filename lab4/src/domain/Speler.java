package domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Speler {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int volgnr;
    private Score score;

    public Speler(){
        this.score = new Score(0);
        this.volgnr = count.incrementAndGet();
    }

    public int getVolgnr(){
        return this.volgnr;
    }

    public Score getScore(){
        return this.score;
    }
}
