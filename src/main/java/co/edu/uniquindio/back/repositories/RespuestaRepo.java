package co.edu.uniquindio.back.repositories;

import co.edu.uniquindio.back.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepo extends JpaRepository<Respuesta, Integer> {

    @Query(value = "select p.enunciado, " +
            "(select count(*)  " +
            "from respuesta rr " +
            "where rr.valoracion = 1 " +
            "and rr.id_pregunta = r.id_pregunta ) correctas, " +
            "(select count(*) " +
            "from respuesta rr " +
            "where rr.valoracion = 0 " +
            "and rr.id_pregunta = r.id_pregunta ) incorrectas from respuesta r join pregunta p " +
            "on r.id_pregunta = p.id_pregunta" +
            "group by p.enunciado", nativeQuery = true)
    List<Object[]> getPreguntasTyF();

    @Query(value = "select p.enunciado, avg(valoracion) Promedio_Global " +
            "from respuesta r join pregunta p " +
            "on p.id_pregunta = r.id_pregunta " +
            "group by p.enunciado " +
            "order by 1", nativeQuery = true)
    List<Object[]> getPromedioPreguntas();

    @Query(value = "select avg(valoracion) promedio from respuesta where id_pregunta = ?", nativeQuery = true)
    Double getPromedioValoracionPregunta(Integer idItem);

    @Query(value = "select valoracion from respuesta where id_pregunta = ?", nativeQuery = true)
    List<Double> getValoracionesPregunta(Integer idItem);
}
