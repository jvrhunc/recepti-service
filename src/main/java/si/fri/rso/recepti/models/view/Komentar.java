package si.fri.rso.recepti.models.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Komentar {

    private Integer komentarId;

    @JsonFormat(pattern="dd-MM-yyyy", timezone="Europe/Ljubljana")
    private LocalDate created;

    private String komentar;
    private Integer ocena;
    private Integer uporabnikId;
    private Integer receptId;

    public Komentar() {
    }

    public Integer getKomentarId() {
        return komentarId;
    }

    public void setKomentarId(Integer komentarId) {
        this.komentarId = komentarId;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Integer getUporabnikId() {
        return uporabnikId;
    }

    public void setUporabnikId(Integer uporabnikId) {
        this.uporabnikId = uporabnikId;
    }

    public Integer getReceptId() {
        return receptId;
    }

    public void setReceptId(Integer receptId) {
        this.receptId = receptId;
    }
}
