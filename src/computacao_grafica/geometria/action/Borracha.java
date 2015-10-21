package computacao_grafica.geometria.action;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import computacao_grafica.geometria.formas.Circunferencia2D;
import computacao_grafica.geometria.formas.Forma2D;
import computacao_grafica.geometria.formas.Ponto2D;
import computacao_grafica.geometria.matematica.Ponto.ModoCoordenada;

public class Borracha {

    private Set<Ponto2D> pontosASeremAvaliados;

    public Borracha(Ponto2D pontoClicado) {
        this.pontosASeremAvaliados = new HashSet<Ponto2D>();
        this.pontosASeremAvaliados.addAll(new Circunferencia2D(1, pontoClicado).getPontos());
        this.pontosASeremAvaliados.addAll(new Circunferencia2D(2, pontoClicado).getPontos());
        this.pontosASeremAvaliados.add(pontoClicado);
    }

    public Forma2D apagar(Collection<Forma2D> formas) {
        Forma2D formaASerApagada = null;
        Iterator<Forma2D> itF2D = formas.iterator();
        while (formaASerApagada == null && itF2D.hasNext()) {
            Forma2D forma = itF2D.next();
            for (Ponto2D ponto : pontosASeremAvaliados) {
                Ponto2D avaliacao = new Ponto2D(ponto, ponto.get_cor(), ModoCoordenada.ABSOLUTA_JANELA);
                if (forma.getFormaMatematica().contem(avaliacao)) {
                    formaASerApagada = forma;
                    break;
                }
            }
        }
        return formaASerApagada;
    }
}
