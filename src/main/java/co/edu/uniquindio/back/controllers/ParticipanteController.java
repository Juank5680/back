package co.edu.uniquindio.back.controllers;

import co.edu.uniquindio.back.entities.Participante;
import co.edu.uniquindio.back.services.ParticipanteService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("estudiante")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @PostMapping("/crear")
    public ResponseEntity<?> createParticipante(@RequestBody Participante participante){
        try {
            if(participanteService.createParticipante(participante)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Participante creado correctamente");
            }
            else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
                objetoJson.put("Mensaje", "No es posible registrar el Participante, " +
                        "puede que ya exista uno con el mismo codigo");
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }
        }catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
            objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
            objetoJson.put("Mensaje", "Ocurrio un problema");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getParticipantesPromedio() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    participanteService.getAllParticipantesPuntaje());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción error", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No existen registros en la BD");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/test/{codigo}")
    public ResponseEntity<?> getResultadoTest(@PathVariable Integer codigo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    participanteService.getResultadosTest(codigo));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción error", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No existen registros en la BD");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

}
