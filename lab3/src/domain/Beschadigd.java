package domain;

public class Beschadigd implements ArtikelState{
    @Override
    public void leenUit(Feestartikel artikel) {}

    @Override
    public void herstel(Feestartikel artikel) {
        artikel.setState(new Uitleenbaar());
    }

    @Override
    public void verwijder(Feestartikel artikel) {
        artikel.setState(new Verwijderd());
    }

    @Override
    public void brengTerug(Feestartikel artikel) {}
}
