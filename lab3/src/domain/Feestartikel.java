package domain;

public class Feestartikel {
    private String description;
    private double prijs;
    private ArtikelState state;

    public Feestartikel(String description, double prijs){
        setDescription(description);
        setPrijs(prijs);
        state = new Uitleenbaar();
    }

    public ArtikelState getState(){
        return this.state;
    }

    public void setState(ArtikelState state){
        this.state = state;
    }

    public void setUitgeleend(){
        this.getState().leenUit(this);
    }

    public void setBeschadigd(){
        this.getState().herstel(this);
    }

    public void setVerwijderd(){
        this.getState().verwijder(this);
    }

    public void setUitleenbaar(){
        this.getState().brengTerug(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String toString(){
        return "description: " + this.description + ", price: " + this.prijs + ", state: " + this.state.getClass().getSimpleName();
    }
}
