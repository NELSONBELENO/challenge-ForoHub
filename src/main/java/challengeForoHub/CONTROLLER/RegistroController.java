package challengeForoHub.CONTROLLER;

import challengeForoHub.DTO.DatosRegistroUsuario;
import challengeForoHub.DTO.DatosRespuestaRegistro;
import challengeForoHub.MODEL.Usuario;
import challengeForoHub.SERVICE.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario) {
        try {
            Usuario nuevoUsuario = usuarioService.registrarUsuario(datosRegistroUsuario);
            DatosRespuestaRegistro respuesta = new DatosRespuestaRegistro(
                    nuevoUsuario.getId(),
                    nuevoUsuario.getNombre(),
                    nuevoUsuario.getEmail(),
                    nuevoUsuario.getRol().name()
            );
            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno al registrar el usuario.");
        }
    }
}