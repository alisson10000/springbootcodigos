package com.spring.aulaNove.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.spring.aulaNove.service.MeuServico;

@Component
public class MeuComponente {
    private final MeuServico meuServico;

    // Injeção com @Qualifier
    public MeuComponente(@Qualifier("implementacaoDois") MeuServico meuServico) {
        this.meuServico = meuServico;
    }

    public String usarServico() {
       return meuServico.fazerAlgo();
    }
}