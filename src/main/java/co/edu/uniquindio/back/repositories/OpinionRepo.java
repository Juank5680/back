package co.edu.uniquindio.back.repositories;

import co.edu.uniquindio.back.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepo extends JpaRepository<Opinion, Integer> {


    @Query(value = "select i.enunciado, avg(valoracion) Promedio_Global " +
            "from opinion o join item i " +
            "on i.id_item = o.id_item " +
            "group by i.enunciado " +
            "order by 1 ", nativeQuery = true)
    List<Object[]> getPromedioOpinion();

    @Query(value = "select avg(valoracion) promedio from opinion where id_item = ?", nativeQuery = true)
    Double getPromedioValoracionOpinion(Integer idItem);

    @Query(value = "select valoracion from opinion where id_item = ?", nativeQuery = true)
    List<Double> getValoracionesOpinion(Integer idItem);

}
