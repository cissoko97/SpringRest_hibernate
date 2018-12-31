package org.centaurus.app.enumeration;

public enum WeekDay {
    Lundi(1, "Lundi"),
    Mardi(2, "Mardi"),
    Mercredi(3, "Mercredi"),
    Jeudi(4, "Jeudi"),
    Vendredi(5, "Vendredi"),
    Samedi(6, "Samedi"),
    Dimanche(7, "Dimanche");

    private int position;
    private String jour;

    WeekDay(int position, String jour) {
        this.position = position;
        this.jour = jour;
    }

    public String toString() {
        return this.position + " : " + this.jour;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }
}
