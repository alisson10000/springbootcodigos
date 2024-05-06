package com.spring.aulaNove.component;

import org.springframework.stereotype.Component;

import com.spring.aulaNove.service.MeuServico;
@Component("implementacaoUm")
public class MinhaImplementacaoServicoUm implements MeuServico {
@Override	
public String fazerAlgo() {
	
	String mensagem = "Implementação um -> vou estudar";
	
	
return	mensagem;
}
}
