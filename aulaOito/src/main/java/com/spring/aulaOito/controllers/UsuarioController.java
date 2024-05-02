package com.spring.aulaOito.controllers;
import com.spring.aulaOito.dto.UsuarioDTO;
import com.spring.aulaOito.model.Usuario;
import com.spring.aulaOito.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import javax.validation.Valid;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	@PostMapping
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
		// Converter o DTO de usuário em uma entidade Usuario
		Usuario usuario = usuarioService.converterParaEntidade(usuarioDTO);
		// Salvar o usuário no banco de dados
		usuarioService.salvar(usuario);
		// Retornar uma resposta 200 (OK) com o DTO do usuário recém-criado
		return ResponseEntity.ok(usuarioService.converterParaDTO(usuario));
	}
	@PutMapping
	public ResponseEntity<UsuarioDTO> atualizar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		// Verifique se o ID está presente no DTO
		if (usuarioDTO.getId() == null) {
			// Retorna uma resposta de erro 400 (Bad Request) se o ID estiver ausente
			return ResponseEntity.badRequest().build();
		}
		// Busque o usuário no banco de dados pelo ID fornecido no DTO
		Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(usuarioDTO.getId());
		// Verifique se o usuário existe no banco de dados
		if (usuarioOptional.isPresent()) {
			// Se o usuário existe, obtenha o objeto Usuario correspondente
			Usuario usuario = usuarioOptional.get();

			// Atualize os dados do usuário com base nas informações fornecidas no DTO
			usuarioService.atualizar(usuarioService.converterParaEntidade(usuarioDTO));

			// Retorna uma resposta 200 (OK) com o DTO do usuário atualizado
			return ResponseEntity.ok(usuarioService.converterParaDTO(usuario));
		} else {
			// Se o usuário não existe no banco de dados, retorne uma resposta 404 (Not
			// Found)
			return ResponseEntity.notFound().build();
		}
	}//fim do método atualizar

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarUm(@PathVariable Long id) {
		// Buscar o usuário pelo ID fornecido
		Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(id);

		// Verificar se o usuário foi encontrado
		if (usuarioOptional.isPresent()) {
			// Se encontrado, obter o usuário e converter para DTO
			Usuario usuario = usuarioOptional.get();
			UsuarioDTO usuarioDTO = usuarioService.converterParaDTO(usuario);

			// Retornar uma resposta 200 (OK) contendo o DTO do usuário encontrado
			return ResponseEntity.ok(usuarioDTO);
		} else {
			// Se não encontrado, retornar uma resposta 404 (Not Found)
			String mensagem = "Usuario não encontrado";
			return ResponseEntity.badRequest().body(mensagem);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> remover(@PathVariable Long id) {
		// Verificar se o usuário existe na base de dados
		boolean existeUsuario = usuarioService.existePorId(id);

		// Se o usuário não existe, retornar uma mensagem personalizada
		if (!existeUsuario) {
			String mensagem = "O registro " + id + " não existe no banco de dados.";
			return ResponseEntity.badRequest().body(mensagem);
		}

		// Se o usuário existe, removê-lo
		usuarioService.remover(id);

		// Criar a mensagem de resposta indicando que o usuário foi removido com sucesso
		String mensagem = "O registro " + id + " foi deletado.";

		// Retornar uma resposta 200 (OK) com a mensagem personalizada
		return ResponseEntity.ok(mensagem);
	}
}
