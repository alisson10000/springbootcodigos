package com.spring.aulaNove.component;

import org.springframework.stereotype.Component;

import com.spring.aulaNove.service.MeuServico;

@Component("implementacaoDois")
public class MinhaImplementacaoServicoDois implements MeuServico {

	@Override
	public String fazerAlgo() {
	String mensagem = "Implementação dois -> vou dormir";
	
	return mensagem;
	}
}
