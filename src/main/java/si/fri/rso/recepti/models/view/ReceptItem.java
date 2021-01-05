package si.fri.rso.recepti.models.view;

import si.fri.rso.recepti.models.entities.Recept;

import java.util.List;

public class ReceptItem {

    private Recept recept;

    private Slika slika;

    private Komentar[] komentar;

    public ReceptItem(Recept recept, Slika slika, Komentar[] komentar) {
        this.recept = recept;
        this.slika = slika;
        this.komentar = komentar;
    }

    public ReceptItem() {

    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }

    public Slika getSlika() {
        return slika;
    }

    public void setSlika(Slika slika) {
        this.slika = slika;
    }

    public Komentar[] getKomentar() {
        return komentar;
    }

    public void setKomentar(Komentar[] komentar) {
        this.komentar = komentar;
    }
}
