

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BlocoDeAnotacoes {
    private List<Anotacao> anotacoes = new ArrayList<>();


    public Anotacao adicionarAnotacao(String texto){
        int id = anotacoes.size() + 1 ;
        Anotacao novaAnotacao = null;
        try {
            novaAnotacao = new Anotacao(texto, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        anotacoes.add(novaAnotacao);
        return novaAnotacao;
    }


    public Anotacao buscaNotaPorId(int id) {
        for(Anotacao anotacao : anotacoes){
            if(anotacao.getId() == id){
                return anotacao;
            }
        }
        return null;
    }

    public Anotacao editarAnotacao(int id, String texto) throws Exception {

        Anotacao anotacao = buscaNotaPorId(id);
        if(anotacao != null){
            anotacao.setTexto(texto);
        }
        return anotacao;

    }

    public List<Anotacao> recuperarPorTexto(String texto) throws Exception{
        List<Anotacao> anotacaoEncontada = new ArrayList<>();
        for(Anotacao anotacao: anotacoes){
            if(anotacoes.size() > 0){
                if (anotacao.contemTexto(texto) && !anotacao.isDeletada()){
                    anotacaoEncontada.add(anotacao);
                }
            }
        }
        return anotacaoEncontada;
    }

    public List<Anotacao> listarAnotacoes() throws Exception{
        List<Anotacao> listar = new ArrayList<>();
        if(anotacoes.size() > 0){
            for(int i = 0; i < anotacoes.size(); i++){
                listar.add(anotacoes.get(i));
            }
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
        return listar;
    }

    public Anotacao deletarAnotacao(int id){
        Anotacao nota = buscaNotaPorId(id);
        if(nota.isDeletada()){
            return null;
        }
        nota.deleta();
        return nota;
    }

    @Override
    public String toString() {
        return "BlocoDeAnotacoes{" +
                "anotacoes=" + anotacoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BlocoDeAnotacoes that = (BlocoDeAnotacoes) o;
        return Objects.equals(anotacoes, that.anotacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(anotacoes);
    }
}




