package com.spring.aulaTres.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.aulaTres.model.Usuarios;
import com.spring.aulaTres.repository.UsuariosRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	@Autowired /* IC / CD ou CDI Injeção de dependencias */
	private UsuariosRepository usuariosRepository;

	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String name) {
		return "Hello " + name + "!";
	}

	@GetMapping("/salvarnome/{name}")
	@ResponseStatus(HttpStatus.OK)
	public String salvarNome(@PathVariable String name) {
		Usuarios usuario = new Usuarios();
		usuario.setNomeUsuario(name);
		usuariosRepository.save(usuario);
		return "Nome:  " + name + ", salvo no banco de dados!";
	}

	/* Nosso primeiro método de API */
	@GetMapping(value = "listartodos")
	@ResponseBody /* Retorna os dados para o corpo do html */
	public ResponseEntity<List<Usuarios>> listaUsuarios() {
		/* Executa a consulta do banco de dados */
		List<Usuarios> usuarios = usuariosRepository.findAll();
		/* retorna a lista em JSON */
		return new ResponseEntity<List<Usuarios>>(usuarios, HttpStatus.OK);
	}

	/* Segundo método de API para salvar dados */
	@PostMapping(value = "salvar")
	@ResponseBody/* Retorna os dados para o do Postman o que foi salvo no banco de dados*/
	public ResponseEntity<Usuarios> salvar(@RequestBody Usuarios usuarios) {
		/*Criada a variável user que é do tipo Usuarios que receberá
		 *  pela interface o método que irá salvar os dados no banco de dados */
		Usuarios user = usuariosRepository.save(usuarios);

		/*Retorna para o corpo do Postman que o objeto foi salvo e apresenta na tela*/
		return new ResponseEntity<Usuarios>(user, HttpStatus.CREATED);
	}
	
	
	/* Terceiro método de API para deletar dados */
	@DeleteMapping(value = "delete")/*mapeia o url*/
	@ResponseBody/* Descrição da resposta*/
	/*Ele recebe um parametro que será passado por dentro do Postman*/
	/*ResponseEntity vai retornar uma string com o texto informando 
	 * que o usuario foi deletado com sucesso*/
	public ResponseEntity<String> delete(@RequestParam Long idUser) {
		/*Utilizo apenas a interface usuariosRepository chamando o método
		 * deleteById para deletar o registro*/
		 usuariosRepository.deleteById(idUser);

		/*Retorna para o corpo do Postman o texto informando que o registro foi deletado*/
		return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
	}
	
	
	

}
