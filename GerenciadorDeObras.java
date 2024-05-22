import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeObras {
    private List<ObraDeArte> colecaoDeObras;

    public GerenciadorDeObras() {
        this.colecaoDeObras = new ArrayList<>();
    }

    public void adicionarObra(ObraDeArte obra) {
        colecaoDeObras.add(obra);
    }

    public List<ObraDeArte> getColecaoDeObras() {
        return colecaoDeObras;
    }

    public ObraDeArte buscarObraPorTitulo(String titulo) {
        for (ObraDeArte obra : colecaoDeObras) {
            if (obra.getTitulo().equalsIgnoreCase(titulo)) {
                return obra;
            }
        }
        return null;
    }

    public void listarTodasAsObras() {
        for (ObraDeArte obra : colecaoDeObras) {
            System.out.println(obra);
        }
    }

    public void atualizarObra(String titulo, ObraDeArte novaObra) {
        ObraDeArte obra = buscarObraPorTitulo(titulo);
        if (obra != null) {
            obra.setTitulo(novaObra.getTitulo());
            obra.setArtista(novaObra.getArtista());
            obra.setAnoDeCriacao(novaObra.getAnoDeCriacao());
            obra.setTipo(novaObra.getTipo());
            obra.setLocalizacao(novaObra.getLocalizacao());
        }
    }

    public void excluirObra(String titulo) {
        ObraDeArte obra = buscarObraPorTitulo(titulo);
        if (obra != null) {
            colecaoDeObras.remove(obra);
        }
    }

    public void salvarParaArquivo(String nomeDoArquivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nomeDoArquivo))) {
            for (ObraDeArte obra : colecaoDeObras) {
                if (obra instanceof Pintura) {
                    Pintura pintura = (Pintura) obra;
                    escritor.println("Pintura;" + pintura.getTitulo() + ";" + pintura.getArtista() + ";" + pintura.getAnoDeCriacao() + ";" + pintura.getLocalizacao() + ";" + pintura.getMeio());
                } else if (obra instanceof Escultura) {
                    Escultura escultura = (Escultura) obra;
                    escritor.println("Escultura;" + escultura.getTitulo() + ";" + escultura.getArtista() + ";" + escultura.getAnoDeCriacao() + ";" + escultura.getLocalizacao() + ";" + escultura.getMaterial());
                } else {
                    escritor.println("ObraDeArte;" + obra.getTitulo() + ";" + obra.getArtista() + ";" + obra.getAnoDeCriacao() + ";" + obra.getTipo() + ";" + obra.getLocalizacao());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarDeArquivo(String nomeDoArquivo) {
        try (Scanner scanner = new Scanner(new FileReader(nomeDoArquivo))) {
            colecaoDeObras.clear();
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                if (partes.length >= 6) {
                    String tipo = partes[0];
                    String titulo = partes[1];
                    String artista = partes[2];
                    int anoDeCriacao = Integer.parseInt(partes[3]);
                    String localizacao = partes[4];

                    switch (tipo) {
                        case "Pintura":
                            String meio = partes[5];
                            colecaoDeObras.add(new Pintura(titulo, artista, anoDeCriacao, localizacao, meio));
                            break;
                        case "Escultura":
                            String material = partes[5];
                            colecaoDeObras.add(new Escultura(titulo, artista, anoDeCriacao, localizacao, material));
                            break;
                        case "ObraDeArte":
                        default:
                            colecaoDeObras.add(new ObraDeArte(titulo, artista, anoDeCriacao, partes[5], localizacao));
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ObraDeArte> buscarObrasPorCriterios(String artista, int anoDeCriacao, String tipo) {
        List<ObraDeArte> resultado = new ArrayList<>();
        for (ObraDeArte obra : colecaoDeObras) {
            boolean corresponde = true;
            if (artista != null && !artista.isEmpty() && !obra.getArtista().equalsIgnoreCase(artista)) {
                corresponde = false;
            }
            if (anoDeCriacao != 0 && obra.getAnoDeCriacao() != anoDeCriacao) {
                corresponde = false;
            }
            if (tipo != null && !tipo.isEmpty() && !obra.getTipo().equalsIgnoreCase(tipo)) {
                corresponde = false;
            }
            if (corresponde) {
                resultado.add(obra);
            }
        }
        return resultado;
    }
}
