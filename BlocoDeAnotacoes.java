import java.util.ArrayList;
import java.util.Objects;

public class BlocoDeAnotacoes {
    private ArrayList<Anotacao> anotacoes = new ArrayList<>();


    public Anotacao adicionarAnotacao(String texto){
        int id = anotacoes.size() + 1 ;
        Anotacao novaAnotacao = new Anotacao(texto, id);
        anotacoes.add(novaAnotacao);
        return novaAnotacao;
    }


    public Anotacao buscaNotaPorId(int id){
        for(Anotacao anotacao : anotacoes){
            if(anotacao.getId() == id){
                return anotacao;
            }
        }
        return null;
    }

    public Anotacao editarAnotacao(int id, String texto){
        Anotacao anotacao = buscaNotaPorId(id);
        if(anotacao != null){
            anotacao.setTexto(texto);
        }
        return anotacao;

    }

    public ArrayList<Anotacao> recuperarPorTexto(String texto){
        ArrayList<Anotacao> anotacaoEncontada = new ArrayList<>();
        for(Anotacao anotacao: anotacoes){
            if(anotacoes.size() > 0){
                if (anotacao.getTexto().contains(texto) && !anotacao.isDeletada()){
                    anotacaoEncontada.add(anotacao);
                }
            }
        }
        return anotacaoEncontada;
    }

    public ArrayList<Anotacao> listarAnotacoes(){
        ArrayList<Anotacao> listar = new ArrayList<>();
        if(anotacoes.size() > 0){
            for(int i = 0; i < anotacoes.size(); i++){
                listar.add(anotacoes.get(i));
            }
        }
        return listar;
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




