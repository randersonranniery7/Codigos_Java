import java.util.List;
import java.util.Scanner;

public class ProgramaBlocoDeNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlocoDeAnotacoes bloco = new BlocoDeAnotacoes();

        boolean continuar = true;

        while(continuar){
            System.out.println("Escolha uma das opcões:\n 1.Adicionar uma anotação\n 2.Buscar anotação pelo ID\n 3.Editar anotação\n 4.Buscar anotaçao por texto\n 5.Listar Anotações\n 6.Deletar Anotação\n 7.Sair");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> {
                    try {
                        System.out.println("Digite: ");
                        bloco.adicionarAnotacao(sc.nextLine());
                    } catch (Exception exception) {
                        System.err.println(exception.getMessage());
                    }
                }
                case "2" -> {
                    try {
                        System.out.println("Informe o ID: ");
                        Anotacao notaEncontradaPorId = bloco.buscaNotaPorId(Integer.parseInt(sc.nextLine()));
                        System.out.println(notaEncontradaPorId);

                    } catch (Exception exception) {
                        System.err.println("Ocorreu um erro no program por:\n" + exception.getMessage());
                    }
                }
                case "3" -> {
                    try {
                        System.out.println("Informe o ID da anotação: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Edite: ");
                        String novaAnotacao = sc.nextLine();
                        bloco.editarAnotacao(id, novaAnotacao);
                    } catch (Exception exception) {
                        System.err.println("Ocorreu um erro no programa por:\n" + exception.getMessage());
                    }
                }
                case "4" -> {

                    try {
                        System.out.println("Digite uma palavra ou frase para encontrar anotações correspondentes: ");
                        String encontrarAnotacao = sc.nextLine();
                        List<Anotacao> notaEncontradaPorTexto = bloco.recuperarPorTexto(encontrarAnotacao);
                        System.out.println(notaEncontradaPorTexto);
                    } catch (Exception exception) {

                        System.err.println("Ocorreu um erro no programa por:\n" + exception.getMessage());
                    }
                }
                case "5" -> {

                    try {
                        List<Anotacao> anotacoes = bloco.listarAnotacoes();
                        for(Anotacao nota : anotacoes){
                            System.out.println(nota);
                        }

                    } catch (Exception exception) {
                        System.err.println("Ocorreu um erro no programa por:\n" + exception.getMessage());

                    }
                }
                case "6" -> {

                    try {
                        System.out.println("Informe o ID da anotação que deseja deletar: ");
                        int idDeletar = Integer.parseInt(sc.nextLine());
                        bloco.deletarAnotacao(idDeletar);
                        System.out.println("Anotação deletada com sucesso!");

                    } catch (Exception exception) {
                        System.err.println("Ocorreu um erro no programa por:\n" + exception.getMessage());

                    }
                }
                case "7" -> {
                    System.out.println("Encerrando...");
                    continuar = false;
                }
            }
        }
        sc.close();
    }
}