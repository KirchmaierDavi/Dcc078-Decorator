package com.decorator.exe.padraoDecorator;

import java.util.ArrayList;
import java.util.List;

public class ProcessoSindical implements Processo {

    @Override
    public String getDescricao() {
        return "Processo sindical base";
    }

    @Override
    public List<String> iniciar() {
        List<String> acoes = new ArrayList<>();
        acoes.add("Iniciando " + getDescricao());
        return acoes;
    }
}
