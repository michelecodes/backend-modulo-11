import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SeparadorDeJogos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> jogadores = new HashMap<>();

        System.out.println("Digite 'sair' para encerrar o programa.");

        while (true) {
            System.out.print("Digite o nome do jogador: ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite o jogo (Pokemon, Digimon ou Magic): ");
            String jogo = scanner.nextLine();

            jogadores.put(nome, jogo);
        }

        separarJogos(jogadores);
    }

    private static void separarJogos(Map<String, String> jogadores) {
        Map<String, String> pokemonTCG = new HashMap<>();
        Map<String, String> digimonTCG = new HashMap<>();
        Map<String, String> magicTheGathering = new HashMap<>();

        for (Map.Entry<String, String> entry : jogadores.entrySet()) {
            String nome = entry.getKey();
            String jogo = entry.getValue();

            switch (jogo.toLowerCase()) {
                case "pokemon":
                    pokemonTCG.put(nome, jogo);
                    break;
                case "digimon":
                    digimonTCG.put(nome, jogo);
                    break;
                case "magic":
                    magicTheGathering.put(nome, jogo);
                    break;
                default:
                    System.out.println("Jogo não reconhecido para o jogador " + nome + ": " + jogo);
            }
        }

        System.out.println("Jogadores de Pokémon TCG:");
        exibirJogadores(pokemonTCG);

        System.out.println("Jogadores de Digimon TCG:");
        exibirJogadores(digimonTCG);

        System.out.println("Jogadores de Magic The Gathering:");
        exibirJogadores(magicTheGathering);
    }

    private static void exibirJogadores(Map<String, String> jogadores) {
        for (Map.Entry<String, String> entry : jogadores.entrySet()) {
            System.out.println("Nome: " + entry.getKey() + ", Jogo: " + entry.getValue());
        }
    }
}
