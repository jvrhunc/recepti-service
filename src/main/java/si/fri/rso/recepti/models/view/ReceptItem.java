package si.fri.rso.recepti.models.view;

import si.fri.rso.recepti.models.entities.Recept;

import java.util.List;

public class ReceptItem {

    private Recept recept;

    private Slika slika;

    private List<Komentar> komentar;

    public ReceptItem() {
    }

    public ReceptItem(Recept recept, Slika slika, List<Komentar> komentar) {
        this.recept = recept;
        this.slika = slika;
        this.komentar = komentar;
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

    public List<Komentar> getKomentar() {
        return komentar;
    }

    public void setKomentar(List<Komentar> komentar) {
        this.komentar = komentar;
    }
}
