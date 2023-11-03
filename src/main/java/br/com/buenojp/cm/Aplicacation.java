package br.com.buenojp.cm;

import br.com.buenojp.cm.model.Tabuleiro;
import br.com.buenojp.cm.views.TabuleiroConsole;

public class Aplicacation {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        new TabuleiroConsole(tabuleiro);
    }
}
