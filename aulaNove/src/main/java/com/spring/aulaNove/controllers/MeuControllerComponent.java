package com.spring.aulaNove.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.aulaNove.component.MeuComponente;

@RestController
@RequestMapping("/componente")
public class MeuControllerComponent {

	private final MeuComponente meuComponente;
	
	public MeuControllerComponent(MeuComponente meuComponente) {
		this.meuComponente = meuComponente;
	}
	
	@GetMapping("/respostacomponente")
	@ResponseBody
	public  String  mostrarComponente(){
	return meuComponente.usarServico();
	}
}
