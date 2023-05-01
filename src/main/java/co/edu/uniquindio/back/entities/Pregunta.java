package co.edu.uniquindio.back.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Pregunta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column (nullable = false, length = 25)
    private String enunciado;
    @ManyToOne
    private Punto puntoInicial;

    @ManyToOne
    private Punto puntoFinal;
}