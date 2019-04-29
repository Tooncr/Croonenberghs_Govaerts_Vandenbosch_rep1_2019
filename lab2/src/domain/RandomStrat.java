package domain;

public class RandomStrat implements CodeerStrategy{
    private RandomCypher cypher;

    public RandomStrat(){
        cypher = new RandomCypher();
    }

    @Override
    public String codeer(String zin) {
        return new String(cypher.encypher(zin.toCharArray()));
    }

    @Override
    public String decodeer(String zin) {
        return new String(cypher.decypher(zin.toCharArray()));
    }
}
