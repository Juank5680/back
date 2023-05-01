package co.edu.uniquindio.back.controllers;

import co.edu.uniquindio.back.entities.Opinion;
import co.edu.uniquindio.back.services.OpinionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("opinion")
public class OpinionController {

    @Autowired
    private OpinionService opinionService;

    @PostMapping("/crear")
    public ResponseEntity<?> createOpinion(@RequestBody Opinion opinion){
        try {
            if(opinionService.createOpinion(opinion)) {
                return ResponseEntity.status(HttpStatus.CREATED).body(null);
            }
            else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
                objetoJson.put("Mensaje", "No es posible registrar la Opinion");
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
            objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
            objetoJson.put("Mensaje", "Ocurrio un problema");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getPromedioOpinion() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    opinionService.getPromedioOpinion());
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






