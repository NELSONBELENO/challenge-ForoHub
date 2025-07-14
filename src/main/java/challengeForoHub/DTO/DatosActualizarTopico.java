package challengeForoHub.DTO;

import challengeForoHub.MODEL.Topico.*;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        StatusTopico status
) {}