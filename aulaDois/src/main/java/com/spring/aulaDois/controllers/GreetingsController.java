package com.spring.aulaDois.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.spring.aulaDois.model.Usuarios;
import com.spring.aulaDois.repository.UsuariosRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
@Autowired /* IC / CD  ou CDI Injeção de dependencias */
	private UsuariosRepository usuariosRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    
    @GetMapping("/olamundo/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String retornoOlaMundo(@PathVariable String name) {
    	
        return "Olá mundo " + name + "!";
    }
    
    
    @GetMapping("/salvarnome/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String salvarNome(@PathVariable String name) {
    	
    	Usuarios usuario = new Usuarios();
    	usuario.setNomeUsuario(name);
    	
    	usuariosRepository.save(usuario);
        return "Nome:  " + name + ", salvo no banco de dados!";
    }
}
