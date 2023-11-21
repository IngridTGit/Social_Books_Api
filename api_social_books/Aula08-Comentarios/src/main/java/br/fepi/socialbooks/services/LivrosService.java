package br.fepi.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.fepi.socialbooks.domain.Comentario;
import br.fepi.socialbooks.domain.Livro;
import br.fepi.socialbooks.repository.ComentariosRepository;
import br.fepi.socialbooks.repository.LivrosRepository;
import br.fepi.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosrepository;
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findById(id).orElse(null);
		
		if (livro == null) {
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}
		
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("Livro não encontrado.");
		}
	}
	
	public void atualizar (Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosrepository.save(comentario);
		
	}
	
	
}
