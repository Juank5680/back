package co.edu.uniquindio.back.repositories;

import co.edu.uniquindio.back.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PuntoRepo extends JpaRepository<Pregunta, Integer> {
    @Query(value = "select pu.x x_inicial, pu.y y_inicial, "+
            "pu2.x x_final, pu2.y y_final "+
            "from punto pu, pregunta pr, punto pu2 "+
            "where pu.id_punto = pr.punto_inicial_id_punto "+
            "and pu2.id_punto = pr.punto_final_id_punto "+
            "and pr.id_pregunta = ?", nativeQuery = true)
    Object [] findPuntoIdPregunta(Integer idPregunta);

}