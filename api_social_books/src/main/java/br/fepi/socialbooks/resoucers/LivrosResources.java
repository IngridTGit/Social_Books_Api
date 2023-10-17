package br.fepi.socialbooks.resoucers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fepi.socialbooks.domain.Livro;

@RestController
public class LivrosResources {
	
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		
		Livro livro1 = new Livro("A arte da guerra");
		Livro livro2 = new Livro("1984");
		Livro livro3 = new Livro("O pequeno príncipe");
		Livro livro4 = new Livro("Dona flor e seus 2 maridos");
		
		Livro[] livros = {livro1, livro2, livro3, livro4};
		
		return Arrays.asList(livros);
				
	}
	
}
