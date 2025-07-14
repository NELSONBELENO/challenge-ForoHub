package challengeForoHub.DTO;

import challengeForoHub.MODEL.Usuario;

public
record DatosAutor(Long id, String nombre) {
    public DatosAutor(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}