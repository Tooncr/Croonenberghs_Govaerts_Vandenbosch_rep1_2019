package domain;

public class Uitgeleend implements ArtikelState{
    @Override
    public void leenUit(Feestartikel artikel) {}

    @Override
    public void herstel(Feestartikel artikel) {}

    @Override
    public void verwijder(Feestartikel artikel) {}

    @Override
    public void brengTerug(Feestartikel artikel) {
        artikel.setState(new Uitleenbaar());
    }
}
