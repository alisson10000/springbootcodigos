package com.spring.aulaOito.service;
import com.spring.aulaOito.dto.UsuarioDTO;
import com.spring.aulaOito.model.Usuario;
import com.spring.aulaOito.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UsuarioService {
	@Qualifier("modelMapper")
	private final ModelMapper modelMapper;
	private final UsuarioRepository usuarioRepository;

	public UsuarioService(ModelMapper modelMapper, UsuarioRepository usuarioRepository) {
		this.modelMapper = modelMapper;
		this.usuarioRepository = usuarioRepository;
	}

	// Método para converter entidade Usuario em DTO UsuarioDTO
	public UsuarioDTO converterParaDTO(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	// Método para converter DTO UsuarioDTO em entidade Usuario
	public Usuario converterParaEntidade(UsuarioDTO usuarioDTO) {
		return modelMapper.map(usuarioDTO, Usuario.class);
	}

//Método para verificar se um usuário existe pelo ID
	public boolean existePorId(Long id) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		return usuarioOptional.isPresent(); // Retorna true se o usuário existe, false caso contrário
	}

	// Método para salvar um novo usuário
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// Método para atualizar um usuário existente
	public void atualizar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	// Método para buscar um usuário por ID
	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	// Método para remover um usuário por ID
	public void remover(Long id) {
		usuarioRepository.deleteById(id);
	}
}
