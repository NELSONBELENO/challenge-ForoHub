package challengeForoHub.REPOSITORY;

import challengeForoHub.MODEL.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findById(Long id);
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}