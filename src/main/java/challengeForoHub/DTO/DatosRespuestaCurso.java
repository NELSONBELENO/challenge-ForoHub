package challengeForoHub.DTO;

import challengeForoHub.MODEL.Cursos;

public record DatosRespuestaCurso(
        Long id,
        String nombre,
        String categoria
) {
    public DatosRespuestaCurso(Cursos curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria()
        );
    }
}