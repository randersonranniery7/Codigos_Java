
import java.time.LocalDate;
import java.util.Objects;


public class Anotacao {
    private String texto;
    private int id;
    private boolean deletada = false;
    private LocalDate dataDeCriacao;


    public Anotacao(String texto, int id) {
        this.texto = texto;
        this.id = id;
        dataDeCriacao = LocalDate.now();
    }

    public Anotacao(){
        this("",0);
    }

    public boolean isDeletada(){
        return deletada;
    }

    public void deleta(){
        deletada = true;
    }

    public boolean contemTexto(String texto){
        if(this.texto.contains(texto)){
            return true;
        } else {
            return false;
        }

    }

    public int getId() {
        return id;
    }


    public String getTexto() {
        return texto;
    }


    public void setTexto(String texto) {
        this.texto = texto;
    }


    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }


    @Override
    public String
    toString() {
        return "Anotacao{" +
                "texto='" + texto + '\'' +
                ", id=" + id +
                ", dataDeCriacao=" + dataDeCriacao +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anotacao anotacao = (Anotacao) o;
        return id == anotacao.id && Objects.equals(texto, anotacao.texto) && Objects.equals(dataDeCriacao, anotacao.dataDeCriacao);
    }


    @Override
    public int hashCode() {
        return Objects.hash(texto, id, dataDeCriacao);
    }
}



