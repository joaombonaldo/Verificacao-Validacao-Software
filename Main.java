import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        try {
            // Solicitar data e hora de entrada
            System.out.print("Digite a data e hora de entrada (dd/MM/yyyy HH:mm): ");
            String entradaStr = scanner.nextLine();
            LocalDateTime entrada = LocalDateTime.parse(entradaStr, formatter);

            // Solicitar data e hora de saída
            System.out.print("Digite a data e hora de saída (dd/MM/yyyy HH:mm): ");
            String saidaStr = scanner.nextLine();
            LocalDateTime saida = LocalDateTime.parse(saidaStr, formatter);

            // Solicitar se o cliente é VIP
            System.out.print("O cliente é VIP? (sim/não): ");
            String isVIPStr = scanner.nextLine();
            boolean isVIP = isVIPStr.equalsIgnoreCase("sim");

            // Criar instância da classe Estacionamento
            Estacionamento estacionamento = new Estacionamento(entrada, saida, isVIP);

            // Calcular e exibir o valor
            double valor = estacionamento.calcularValor();
            System.out.printf("O valor a ser pago pelo estacionamento é: R$ %.2f%n", valor);
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, tente novamente.");
        } finally {
            scanner.close();
        }
    }
}
