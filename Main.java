import java.util.Random;
import java.util.Scanner;

// Definição da classe Tamagotchi
class Tamagotchi {
    private int fome; // Nível de fome do Tamagotchi
    private int felicidade; // Nível de felicidade do Tamagotchi
    private int idade; // Idade do Tamagotchi
    private int saude; // Nível de saúde do Tamagotchi
    private int higiene; // Nível de higiene do Tamagotchi
    private int socializacao; // Nível de socialização do Tamagotchi
    private boolean vivo; // Estado de vida do Tamagotchi (vivo ou morto)

    // Construtor para inicializar o Tamagotchi com valores padrão
    public Tamagotchi() {
        fome = 50;
        felicidade = 50;
        idade = 0;
        saude = 100;
        higiene = 50;
        socializacao = 50;
        vivo = true; // O Tamagotchi começa vivo
    }

    // Método privado para garantir que os atributos fiquem dentro dos limites (0 a 100)
    private void verificarLimites() {
        if (fome < 0) fome = 0; // Não permite valores negativos para fome
        if (fome > 100) fome = 100; // Limite máximo para fome é 100
        if (felicidade < 0) felicidade = 0; // Não permite valores negativos para felicidade
        if (felicidade > 100) felicidade = 100; // Limite máximo para felicidade é 100
        if (saude < 0) saude = 0; // Não permite valores negativos para saúde
        if (saude > 100) saude = 100; // Limite máximo para saúde é 100
        if (higiene < 0) higiene = 0; // Não permite valores negativos para higiene
        if (higiene > 100) higiene = 100; // Limite máximo para higiene é 100
        if (socializacao < 0) socializacao = 0; // Não permite valores negativos para socialização
        if (socializacao > 100) socializacao = 100; // Limite máximo para socialização é 100
    }

    // Método para alimentar o Tamagotchi
    public void alimentar() {
        if (vivo) { // Verifica se o Tamagotchi está vivo
            fome -= 10; // Diminui a fome ao alimentar
            felicidade += 5; // Aumenta a felicidade ao alimentar
            saude += 5; // Aumenta a saúde ao alimentar
            verificarLimites(); // Verifica e ajusta os limites dos atributos
        } else {
            System.out.println("\nO Tamagotchi está morto. Não é possível alimentá-lo.");
        }
    }

    // Método para brincar com o Tamagotchi
    public void brincar() {
        if (vivo) {
            felicidade += 10;
            fome += 5;
            higiene -= 5;
            socializacao += 5;
            verificarLimites();
        } else {
            System.out.println("\nO Tamagotchi está morto. Não é possível brincar com ele.");
        }
    }

    // Método para fazer o Tamagotchi dormir
    public void dormir() {
        if (vivo) {
            felicidade += 10;
            fome += 5;
            idade++;
            verificarLimites();
        } else {
            System.out.println("\nO Tamagotchi está morto. Não é possível fazê-lo dormir.");
        }
    }

    // Método para levar o Tamagotchi para passear
    public void passear() {
        if (vivo) {
            felicidade += 10;
            fome += 5;
            higiene -= 5;
            socializacao += 10;
            verificarLimites();
        } else {
            System.out.println("\nO Tamagotchi está morto. Não é possível levá-lo para passear.");
        }
    }

    // Método para dar banho no Tamagotchi
    public void tomarBanho() {
        if (vivo) {
            higiene += 20;
            verificarLimites();
        } else {
            System.out.println("\nO Tamagotchi está morto. Não é possível dar banho nele.");
        }
    }

    // Método para verificar o status do Tamagotchi e se ele está vivo
    public void verificarStatus() {
        if (fome >= 100 || felicidade <= 0 || saude <= 0) {
            vivo = false; // Define o Tamagotchi como morto se algum dos atributos atingir um limite
            System.out.println("\nO Tamagotchi morreu!");
        } else {
            System.out.println("\nTamagotchi está vivo.");
            System.out.println("Fome: " + fome);
            System.out.println("Felicidade: " + felicidade);
            System.out.println("Saúde: " + saude);
            System.out.println("Higiene: " + higiene);
            System.out.println("Socialização: " + socializacao);
            System.out.println("Idade: " + idade);
        }
    }

    // Método para simular eventos aleatórios que podem afetar o estado do Tamagotchi
    public void eventoAleatorio() {
        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance < 20) { // 20% de chance de evento aleatório
            System.out.println("\nDia chuvoso! Nível de energia diminui.");
            felicidade -= 20;
            verificarLimites(); // Verifica e ajusta os limites dos atributos após o evento
        }
    }

    // Método para verificar se o Tamagotchi está vivo
    public boolean isVivo() {
        return vivo;
    }

    // Método para definir o estado de vida do Tamagotchi
    public void setVivo(boolean estado) {
        vivo = estado;
    }
}

// Classe principal Main para testar o Tamagotchi
public class Main {
    // Método para limpar a tela do console
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Função principal
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi(); // Cria um novo Tamagotchi
        Scanner scanner = new Scanner(System.in); // Cria um scanner para entrada do usuário

        while (tamagotchi.isVivo()) { // Loop enquanto o Tamagotchi estiver vivo
            clearScreen(); // Limpa a tela do console
            System.out.println("--- Menu Tamagotchi ---");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Dormir");
            System.out.println("4. Passear");
            System.out.println("5. Tomar Banho");
            System.out.println("6. Verificar Status");
            System.out.println("7. Sair");

            System.out.print("\nEscolha uma ação: ");
            int escolha = scanner.nextInt(); // Lê a escolha do usuário

            switch (escolha) {
                case 1:
                    tamagotchi.alimentar(); // Chama o método alimentar do Tamagotchi
                    tamagotchi.verificarStatus(); // Mostra o status atual do Tamagotchi
                    break;
                case 2:
                    tamagotchi.brincar();
                    tamagotchi.verificarStatus();
                    break;
                case 3:
                    tamagotchi.dormir();
                    tamagotchi.verificarStatus();
                    break;
                case 4:
                    tamagotchi.passear();
                    tamagotchi.verificarStatus();
                    break;
                case 5:
                    tamagotchi.tomarBanho();
                    tamagotchi.verificarStatus();
                    break;
                case 6:
                    tamagotchi.verificarStatus();
                    break;
                case 7:
                    System.out.println("\nSaindo do jogo.");
                    tamagotchi.setVivo(false); // Define o Tamagotchi como morto
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }

            tamagotchi.eventoAleatorio(); // Simula um evento aleatório
            scanner.nextLine(); // Limpa o buffer do scanner
            System.out.print("\nPressione Enter para continuar...");
            scanner.nextLine(); // Aguarda o usuário pressionar Enter antes de continuar
        }

        scanner.close(); // Fecha o scanner após o jogo
    }
}
