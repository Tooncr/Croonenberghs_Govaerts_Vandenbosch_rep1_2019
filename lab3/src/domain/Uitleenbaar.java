package domain;

public class Uitleenbaar implements ArtikelState{
    @Override
    public void leenUit(Feestartikel artikel) {
        artikel.setState(new Uitgeleend());
    }

    @Override
    public void herstel(Feestartikel artikel) {}

    @Override
    public void verwijder(Feestartikel artikel) {
        artikel.setState(new Verwijderd());
    }

    @Override
    public void brengTerug(Feestartikel artikel) {}

}
