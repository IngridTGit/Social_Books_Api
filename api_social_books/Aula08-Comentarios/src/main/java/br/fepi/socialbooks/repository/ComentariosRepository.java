package br.fepi.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{

}
