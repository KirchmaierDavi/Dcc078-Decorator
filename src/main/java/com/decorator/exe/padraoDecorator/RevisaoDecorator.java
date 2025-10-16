package com.decorator.exe.padraoDecorator;

import java.util.List;

public class RevisaoDecorator extends ProcessoDecorator {

    public RevisaoDecorator(Processo processoDecorado) {
        super(processoDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", para revisão";
    }

    @Override
    public List<String> iniciar() {
        List<String> acoes = super.iniciar();
        acoes.add(enviarParaRevisao());
        return acoes;
    }

    private String enviarParaRevisao() {
        return "Ação: Enviando processo para revisão jurídica.";
    }
}
