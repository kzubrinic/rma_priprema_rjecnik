package hr.kruno.z2.rma_priprema_k_05_2021;

import java.util.Comparator;
import java.util.Objects;

class StavkaRjecnika implements Comparable<StavkaRjecnika>, Comparator<StavkaRjecnika> {
    private String rijec;
    private String opis;
    public StavkaRjecnika(String r, String o){
        rijec = r;
        opis = o;
    }

    public String getRijec() {
        return rijec;
    }

    public void setRijec(String rijec) {
        this.rijec = rijec;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StavkaRjecnika that = (StavkaRjecnika) o;
        return rijec.equals(that.rijec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rijec);
    }

    @Override
    public String toString() {
        return "StavkaRjecnika{" +
                "rijec='" + rijec + '\'' +
                ",\nopis='" + opis + '\'' +
                '}';
    }
    // Metoda za uspoređivanje objekata korištenjem standardnih metoda Java kolekcija
    @Override
    public int compareTo(StavkaRjecnika sr) {
        return rijec.toLowerCase().compareTo(sr.getRijec().toLowerCase());
    }
    @Override
    public int compare(StavkaRjecnika sr1, StavkaRjecnika sr2) {
        return sr1.compareTo(sr2);
    }
}
