package challengeForoHub.CONTROLLER;

import challengeForoHub.DTO.DatosActualizarCurso;
import challengeForoHub.DTO.DatosRegistroCurso;
import challengeForoHub.DTO.DatosRespuestaCurso;
import challengeForoHub.MODEL.Cursos;
import challengeForoHub.SERVICE.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso) {
        Cursos cursoRegistrado = cursoService.registrar(datosRegistroCurso);
        DatosRespuestaCurso respuesta = new DatosRespuestaCurso(cursoRegistrado);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaCurso>> listarCursos(Pageable paginacion) {
        Page<Cursos> cursosPage = cursoService.listar(paginacion);
        Page<DatosRespuestaCurso> cursosDTO = cursosPage.map(DatosRespuestaCurso::new);
        return ResponseEntity.ok(cursosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> obtenerCursoPorId(@PathVariable Long id) {
        Cursos curso = cursoService.buscarPorId(id);
        DatosRespuestaCurso respuesta = new DatosRespuestaCurso(curso);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> actualizarCurso(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        DatosActualizarCurso datosActualizadosConId = new DatosActualizarCurso(id, datosActualizarCurso.nombre(), datosActualizarCurso.categoria());
        Cursos cursoActualizado = cursoService.actualizar(datosActualizadosConId);
        DatosRespuestaCurso respuesta = new DatosRespuestaCurso(cursoActualizado);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}