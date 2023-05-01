package co.edu.uniquindio.back.services;

import co.edu.uniquindio.back.repositories.PuntoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PuntoService {

    @Autowired
    private PuntoRepo puntoRepo;

    @Transactional
    public Object[] findPuntoIdPregunta(Integer idPregunta) {
        return puntoRepo.findPuntoIdPregunta(idPregunta);
    }

}
