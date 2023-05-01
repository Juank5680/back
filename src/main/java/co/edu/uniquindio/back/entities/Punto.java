package co.edu.uniquindio.back.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Punto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPunto;
    @Column(columnDefinition = "int default 0")
    private int x;
    @Column(columnDefinition = "int default 0")
    private int y;

    @OneToMany(mappedBy = "puntoInicial")
    private List<Pregunta> ListaPreguntas;

    @OneToMany(mappedBy = "puntoFinal")
    private List<Pregunta> ListaPreguntas2;

}