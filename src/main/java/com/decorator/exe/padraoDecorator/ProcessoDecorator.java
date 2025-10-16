package com.decorator.exe.padraoDecorator;

import java.util.List;

public abstract class ProcessoDecorator implements Processo {
    protected Processo processoDecorado;

    public ProcessoDecorator(Processo processoDecorado) {
        this.processoDecorado = processoDecorado;
    }

    @Override
    public String getDescricao() {
        return processoDecorado.getDescricao();
    }

    @Override
    public List<String> iniciar() {
        return processoDecorado.iniciar();
    }
}
