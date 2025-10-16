package com.decorator.exe.padraoDecorator;

import java.util.List;

public class UrgenciaDecorator extends ProcessoDecorator {

    public UrgenciaDecorator(Processo processoDecorado) {
        super(processoDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", com urgência";
    }

    @Override
    public List<String> iniciar() {
        List<String> acoes = super.iniciar();
        acoes.add(adicionarUrgencia());
        return acoes;
    }

    private String adicionarUrgencia() {
        return "Ação: Marcando processo como urgente.";
    }
}
