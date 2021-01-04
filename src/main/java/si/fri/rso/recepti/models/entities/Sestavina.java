package si.fri.rso.recepti.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sestavina")
public class Sestavina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sestavinaId;

    private String ime;

    private Integer kolicina;

    private String enotaKolicine;

    @JsonFormat(pattern="dd-MM-yyyy", timezone="Europe/Ljubljana")
    private LocalDate created;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recept_fk")
    private Recept recept;

    public Sestavina() {
    }

    public Integer getSestavinaId() {
        return sestavinaId;
    }

    public void setSestavinaId(Integer sestavinaId) {
        this.sestavinaId = sestavinaId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getEnotaKolicine() {
        return enotaKolicine;
    }

    public void setEnotaKolicine(String enotaKolicine) {
        this.enotaKolicine = enotaKolicine;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Recept getRecept() {
        return recept;
    }

    public void setRecept(Recept recept) {
        this.recept = recept;
    }
}
