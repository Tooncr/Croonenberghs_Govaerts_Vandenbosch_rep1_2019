package domain;

import java.util.Base64;

public class Base64Strat implements CodeerStrategy{

    @Override
    public String codeer(String zin) {
        return Base64.getEncoder().encodeToString(zin.getBytes());
    }

    @Override
    public String decodeer(String zin) {
        return new String(Base64.getDecoder().decode(zin));
    }
}
