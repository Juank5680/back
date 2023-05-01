package co.edu.uniquindio.back.services;

import co.edu.uniquindio.back.entities.Respuesta;
import co.edu.uniquindio.back.repositories.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepo respuestaRepo;
    @Transactional
    public boolean createRespuesta(Respuesta respuesta) {
        if (respuestaRepo.findById(respuesta.getIdRespuesta()) != null) {
            respuestaRepo.save(respuesta);
            return true;
        }
        return false;
    }

    @Transactional
    public List<Object[]> getPReguntasTyF() {
        return respuestaRepo.getPreguntasTyF();
    }

    @Transactional
    public List<Object[]> getPromedioPreguntas() {
        return respuestaRepo.getPromedioPreguntas();
    }
}