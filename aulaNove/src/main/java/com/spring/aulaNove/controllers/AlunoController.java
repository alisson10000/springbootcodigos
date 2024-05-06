package com.spring.aulaNove.controllers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.aulaNove.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/{nome}")
	public ResponseEntity<List<Aluno>> buscarAlunoPorNome(@RequestParam String nome) {

		TypedQuery<Aluno> query = entityManager.createNamedQuery("Aluno.findByNome", Aluno.class);

		query.setParameter("nome", nome);

		List<Aluno> alunos = query.getResultList();
		if (alunos.isEmpty()) {

			return ResponseEntity.noContent().build();

		}
		return ResponseEntity.ok(alunos);
	}
	@GetMapping("/ordem-alfabetica")
    public ResponseEntity<List<Aluno>> buscarAlunosEmOrdemAlfabetica() {
        Query query = entityManager.createNativeQuery("SELECT * FROM alunos ORDER BY nome_aluno", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alunos);
    }
	
	
	
	
	
}
