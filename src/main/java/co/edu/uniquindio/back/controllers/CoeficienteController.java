package co.edu.uniquindio.back.controllers;

import co.edu.uniquindio.back.services.CoeficienteService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("coeficiente")
public class CoeficienteController {

    @Autowired
    private CoeficienteService coeficienteService;

    @GetMapping("/obtener")
    public ResponseEntity<?> getCoeficiente(@RequestParam Integer idItem,
                                            @RequestParam Integer idPregunta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    coeficienteService.getCoeficiente(idItem, idPregunta));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo de error", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción error", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No existen registros en la BD");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

}
