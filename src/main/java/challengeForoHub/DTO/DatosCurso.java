package challengeForoHub.DTO;

import challengeForoHub.MODEL.Cursos;

public record DatosCurso(Long id, String nombre) {
    public DatosCurso(Cursos curso) {
        this(curso.getId(), curso.getNombre());
    }
}