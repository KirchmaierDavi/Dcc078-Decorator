package com.decorator.exe.padraoDecorator;

import java.util.List;

public class PrioridadeDecorator extends ProcessoDecorator {

    public PrioridadeDecorator(Processo processoDecorado) {
        super(processoDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", com prioridade";
    }

    @Override
    public List<String> iniciar() {
        List<String> acoes = super.iniciar();
        acoes.add(adicionarPrioridade());
        return acoes;
    }

    private String adicionarPrioridade() {
        return "Ação: Definindo alta prioridade para o processo.";
    }
}
