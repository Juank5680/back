package co.edu.uniquindio.back.services;

import co.edu.uniquindio.back.entities.Participante;
import co.edu.uniquindio.back.repositories.ParticipanteRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ParticipanteService {
    @Autowired
    private ParticipanteRepo participanteRepo;
    @Transactional
    public boolean createParticipante(Participante participante) {
        if(participanteRepo.existsById(participante.getCodigo())) {
            return false;
        }
        participanteRepo.save(participante);
        log.info("Participante guardado");
        return true;
    }

    @Transactional
    public List <Object[]> getAllParticipantesPuntaje() {
        return participanteRepo.getParticipantesPuntaje();
    }

    @Transactional
    public List <Object[]> getResultadosTest(Integer codigo) {
        return participanteRepo.getResultadosTest(codigo);
    }
}
