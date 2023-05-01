package co.edu.uniquindio.back.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpinion;

    private int idItem;

    private int idParticipante;

    @Column (nullable = false)
    private int valoracion;

    public Opinion() {
    }

    public Opinion(int idItem, int idParticipante, int valoracion) {
        this.idItem = idItem;
        this.idParticipante = idParticipante;
        this.valoracion = valoracion;
    }
}