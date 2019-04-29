package domain;

public enum CodeerEnum {
    BASE64 ("Base64", "domain.Base64Strat"),
    CAESAR ("Caesar", "domain.CaesarStrat"),
    SPIEGEL("Spiegel", "domain.GespiegeldStrat"),
    RANDOM ("Random", "domain.RandomStrat");

    private final String beschrijving;
    private final String klassenaam;

    CodeerEnum(String beschrijving, String klassenaam){
        this.beschrijving = beschrijving;
        this.klassenaam = klassenaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getKlassenaam() {
        return klassenaam;
    }
}
