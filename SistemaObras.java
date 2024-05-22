import java.util.List;
import java.util.Scanner;

public class SistemaObras {

    private static void exibirMenu() {
        System.out.println("\n=== Menu de Gerenciamento de Obras de Arte ===");
        System.out.println("1. Adicionar Obra");
        System.out.println("2. Listar Obras");
        System.out.println("3. Buscar Obra");
        System.out.println("4. Atualizar Obra");
        System.out.println("5. Excluir Obra");
        System.out.println("6. Salvar Obras");
        System.out.println("7. Carregar Obras");
        System.out.println("8. Procurar Obras por Critérios");
        System.out.println("0. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    private static void verificarOpcao(int op, GerenciadorDeObras gerenciador, Scanner scanner) {
        String titulo, artista, tipo, localizacao;
        int anoDeCriacao;

        switch (op) {
            case 1:
                System.out.print("Digite o título: ");
                titulo = scanner.nextLine();
                System.out.print("Digite o artista: ");
                artista = scanner.nextLine();
                System.out.print("Digite o ano de criação: ");
                anoDeCriacao = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Digite o tipo (Pintura/Escultura): ");
                tipo = scanner.nextLine();
                System.out.print("Digite a localização: ");
                localizacao = scanner.nextLine();

                if (tipo.equalsIgnoreCase("Pintura")) {
                    System.out.print("Digite o meio (ex: óleo, acrílico): ");
                    String meio = scanner.nextLine();
                    gerenciador.adicionarObra(new Pintura(titulo, artista, anoDeCriacao, localizacao, meio));
                } else if (tipo.equalsIgnoreCase("Escultura")) {
                    System.out.print("Digite o material (ex: mármore, bronze): ");
                    String material = scanner.nextLine();
                    gerenciador.adicionarObra(new Escultura(titulo, artista, anoDeCriacao, localizacao, material));
                } else {
                    gerenciador.adicionarObra(new ObraDeArte(titulo, artista, anoDeCriacao, tipo, localizacao));
                }
                break;
            case 2:
                gerenciador.listarTodasAsObras();
                break;
            case 3:
                System.out.print("Digite o título: ");
                titulo = scanner.nextLine();
                ObraDeArte obra = gerenciador.buscarObraPorTitulo(titulo);
                if (obra != null) {
                    System.out.println(obra);
                } else {
                    System.out.println("Obra não encontrada.");
                }
                break;
            case 4:
                System.out.print("Digite o título da obra a ser atualizada: ");
                titulo = scanner.nextLine();
                System.out.print("Digite o novo título: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Digite o novo artista: ");
                String novoArtista = scanner.nextLine();
                System.out.print("Digite o novo ano de criação: ");
                int novoAnoDeCriacao = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o novo tipo: ");
                String novoTipo = scanner.nextLine();
                System.out.print("Digite a nova localização: ");
                String novaLocalizacao = scanner.nextLine();
                gerenciador.atualizarObra(titulo, new ObraDeArte(novoTitulo, novoArtista, novoAnoDeCriacao, novoTipo, novaLocalizacao));
                break;
            case 5:
                System.out.print("Digite o título da obra a ser excluída: ");
                titulo = scanner.nextLine();
                gerenciador.excluirObra(titulo);
                break;
            case 6:
                System.out.print("Digite o nome do arquivo para salvar: ");
                String nomeArquivoSalvar = scanner.nextLine();
                gerenciador.salvarParaArquivo(nomeArquivoSalvar);
                break;
            case 7:
                System.out.print("Digite o nome do arquivo para carregar: ");
                String nomeArquivoCarregar = scanner.nextLine();
                gerenciador.carregarDeArquivo(nomeArquivoCarregar);
                break;
            case 8:
                System.out.print("Digite o artista (ou deixe em branco para ignorar): ");
                artista = scanner.nextLine();
                System.out.print("Digite o ano de criação (ou 0 para ignorar): ");
                anoDeCriacao = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Digite o tipo (ou deixe em branco para ignorar): ");
                tipo = scanner.nextLine();
                List<ObraDeArte> resultados = gerenciador.buscarObrasPorCriterios(artista, anoDeCriacao, tipo);
                if (resultados.isEmpty()) {
                    System.out.println("Nenhuma obra encontrada.");
                } else {
                    for (ObraDeArte resultado : resultados) {
                        System.out.println(resultado);
                    }
                }
                break;
            case 0:
                System.out.println("Saindo...");
                scanner.close();
                break;
            default:
                System.out.println("Opção inválida. Digite novamente.");
        }

        System.out.println();
    }

    public static void executar() {
        GerenciadorDeObras gerenciador = new GerenciadorDeObras();
        Scanner scanner = new Scanner(System.in);
        int op;

        do {
            exibirMenu();
            op = scanner.nextInt();
            scanner.nextLine();
            verificarOpcao(op, gerenciador, scanner);
        } while (op != 0);
    }
}
