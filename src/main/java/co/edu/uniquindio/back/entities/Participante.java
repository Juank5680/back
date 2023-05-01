package co.edu.uniquindio.back.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
public class Participante {
    @Id
    private Integer codigo;
    @Column(nullable = false, length = 150)
    private String nombre;
    @Column(nullable = false, length = 100, unique = true)
    private String email;


}