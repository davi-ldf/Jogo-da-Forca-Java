import java.util.ArrayList;
import  java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> palavrasSecretas = new ArrayList<>();
        palavrasSecretas.add("peixe"); // index 0 e 5 letras
        palavrasSecretas.add("jaguatirica"); // index 1 e 11 letras
        palavrasSecretas.add("cachorro"); // index 2 e 8 letras

        Random random = new Random();
        int tamanhoArrayList = palavrasSecretas.size(); // 3
        int indexDaPalavraAleatoria = random.nextInt(tamanhoArrayList);
        String palavraSecreta = palavrasSecretas.get(indexDaPalavraAleatoria); // Seleciona uma das palavras aleatoriamente

        ArrayList<Character> letrasDescobertas = new ArrayList<>();

        for (int i = 0; i < palavraSecreta.length(); i++) {
            letrasDescobertas.add('_'); // Inicializa com traços para cada letra da palavra
        }

        int tentativas = 6; // Máximo de tentativas
        boolean palavraFoiDescoberta = false; // Flag de Game Over

        // Enquanto a palavra não for descoberta...
        // ou ainda houverem tentativas restantes, o programa continua.
        while (!palavraFoiDescoberta && tentativas > 0) {
            System.out.println();
            System.out.println("Palavra: " + letrasDescobertas);
            System.out.print("Chute uma letra: ");
            char chute = scanner.next().charAt(0);

            boolean acertou = false;
            for(int i = 0; i < palavraSecreta.length(); i++) { // Percorre cada letra da palavra
                if (palavraSecreta.charAt(i) == chute) { // Bate com o chute?
                    letrasDescobertas.set(i, chute); // Tracinho recebe a letra no index certo
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativas--;
                System.out.println("Você tem mais " + tentativas + " tentativas.");
            }

            // Verifica se a palavra foi completamente descoberta
            palavraFoiDescoberta = !letrasDescobertas.contains('_');
        }

        if (palavraFoiDescoberta) {
            System.out.println("Parabéns, voceê acertou! A palavra era: " + palavraSecreta);
        } else {
            System.out.println("Você perdeu. A palavra era: " + palavraSecreta);
        }



    }
}