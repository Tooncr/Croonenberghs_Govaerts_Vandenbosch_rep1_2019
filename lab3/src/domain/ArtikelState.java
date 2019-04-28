package domain;

public interface ArtikelState {
    void leenUit(Feestartikel artikel);
    void herstel(Feestartikel artikel);
    void verwijder(Feestartikel artikel);
    void brengTerug(Feestartikel artikel);
}
