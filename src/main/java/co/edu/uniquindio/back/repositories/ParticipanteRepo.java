package co.edu.uniquindio.back.repositories;

import co.edu.uniquindio.back.entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParticipanteRepo extends JpaRepository<Participante, Integer> {

    /**
     * Obtiene todos los estudiantes ordenandolos segun la calificacion del test.
     */
    @Query(value = "SELECT nombre, id_participante, sum(valoracion) nota FROM respuesta " +
            "join participante on participante.codigo = respuesta.id_participante " +
            "group by id_participante " +
            "order by 2 desc", nativeQuery = true)
    List<Object[]> getParticipantesPuntaje();

    @Query(value = "SELECT nombre, codigo, enunciado, valoracion FROM respuesta R\n" +
            "join participante E on E.codigo = R.id_participante\n" +
            "join pregunta P on P.id_pregunta = R.id_pregunta\n" +
            "where codigo = ?", nativeQuery = true)
    List<Object[]> getResultadosTest(Integer codigo);

}
