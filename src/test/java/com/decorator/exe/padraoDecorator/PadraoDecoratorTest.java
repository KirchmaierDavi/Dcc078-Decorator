package com.decorator.exe.padraoDecorator;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PadraoDecoratorTest {

    @Test
    void testProcessoSindical() {
        Processo processo = new ProcessoSindical();
        assertEquals("Processo sindical base", processo.getDescricao());
        List<String> acoes = processo.iniciar();
        assertEquals(1, acoes.size());
        assertEquals("Iniciando Processo sindical base", acoes.get(0));
    }

    @Test
    void testPrioridadeDecorator() {
        Processo processo = new PrioridadeDecorator(new ProcessoSindical());
        assertEquals("Processo sindical base, com prioridade", processo.getDescricao());
        List<String> acoes = processo.iniciar();
        assertEquals(2, acoes.size());
        assertTrue(acoes.contains("Iniciando Processo sindical base"));
        assertTrue(acoes.contains("Ação: Definindo alta prioridade para o processo."));
    }

    @Test
    void testRevisaoDecorator() {
        Processo processo = new RevisaoDecorator(new ProcessoSindical());
        assertEquals("Processo sindical base, para revisão", processo.getDescricao());
        List<String> acoes = processo.iniciar();
        assertEquals(2, acoes.size());
        assertTrue(acoes.contains("Iniciando Processo sindical base"));
        assertTrue(acoes.contains("Ação: Enviando processo para revisão jurídica."));
    }

    @Test
    void testUrgenciaDecorator() {
        Processo processo = new UrgenciaDecorator(new ProcessoSindical());
        assertEquals("Processo sindical base, com urgência", processo.getDescricao());
        List<String> acoes = processo.iniciar();
        assertEquals(2, acoes.size());
        assertTrue(acoes.contains("Iniciando Processo sindical base"));
        assertTrue(acoes.contains("Ação: Marcando processo como urgente."));
    }

    @Test
    void testCombinacaoDecorators() {
        Processo processo = new RevisaoDecorator(new PrioridadeDecorator(new UrgenciaDecorator(new ProcessoSindical())));
        String expectedDesc = "Processo sindical base, com urgência, com prioridade, para revisão";
        assertEquals(expectedDesc, processo.getDescricao());

        List<String> acoes = processo.iniciar();
        assertEquals(4, acoes.size());
        assertTrue(acoes.contains("Iniciando Processo sindical base"));
        assertTrue(acoes.contains("Ação: Marcando processo como urgente."));
        assertTrue(acoes.contains("Ação: Definindo alta prioridade para o processo."));
        assertTrue(acoes.contains("Ação: Enviando processo para revisão jurídica."));
    }
}

