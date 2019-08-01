package pl.akademiakodu.blogMarta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int commentID;

    private String commentUserName;

    private String contentOfComment;

    @OneToOne
    private Zadanie zadanie;

    @Override
    public String toString() {
        return
                commentUserName + ": " +  contentOfComment ;
    }
}
