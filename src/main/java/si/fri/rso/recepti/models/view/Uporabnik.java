package si.fri.rso.recepti.models.view;

public class Uporabnik {

    private Integer id;
    private String ime;
    private String priimek;
    private String username;
    private String imageUrl;


    public Uporabnik() {
    }

    public Uporabnik(Integer id, String ime, String priimek, String username, String imageUrl) {
        this.id = id;
        this.ime = ime;
        this.priimek = priimek;
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
