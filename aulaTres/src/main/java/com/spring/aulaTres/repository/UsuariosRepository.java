package com.spring.aulaTres.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.aulaTres.model.Usuarios;
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	/* Abaixo a minha JPQL para realizar consulta por parte do nome */
	/*função trim utilizada para remover os espaços.*/
	@Query(value = "select u from Usuarios u  where upper(trim(u.nomeUsuario)) like %?1%")
	List<Usuarios> buscarPorNome(String name);

}
