package co.edu.uniquindio.back.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity

@Getter
@Setter
public class Item {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItem;

    @Column (nullable = false, length = 250)
    private String enunciado;

}