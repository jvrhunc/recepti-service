package si.fri.rso.recepti.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import si.fri.rso.recepti.models.enums.Tip;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "recept")
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer receptId;

    private String ime;

    private String opis;

    private Integer uporabnikId;

    @JsonFormat(pattern="dd-MM-yyyy", timezone="Europe/Ljubljana")
    private LocalDate created;

    @Enumerated(EnumType.STRING)
    @Column(length = 4)
    private Tip tip;

    @OneToMany(mappedBy = "recept", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Sestavina> sestavine;

    public Recept() {
    }

    public Integer getReceptId() {
        return receptId;
    }

    public void setReceptId(Integer receptId) {
        this.receptId = receptId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getUporabnikId() {
        return uporabnikId;
    }

    public void setUporabnikId(Integer uporabnikId) {
        this.uporabnikId = uporabnikId;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public List<Sestavina> getSestavine() {
        return sestavine;
    }

    public void setSestavine(List<Sestavina> sestavine) {
        this.sestavine = sestavine;
    }
}
