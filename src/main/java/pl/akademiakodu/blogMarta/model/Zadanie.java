package pl.akademiakodu.blogMarta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Zadanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String username;

    private String title;

    private String tresczadania;

    private String odpowiedz;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTresczadania() {
        return tresczadania;
    }

    public void setTresczadania(String tresczadania) {
        this.tresczadania = tresczadania;
    }

    public String getOdpowiedz() {
        return odpowiedz;
    }

    public void setOdpowiedz(String odpowiedz) {
        this.odpowiedz = odpowiedz;
    }

    @Override
    public String toString() {
        return id + ". " + title;

    }
    @OneToMany(mappedBy = "zadanie")
    private List<Comment> comments = new ArrayList<>();
}
