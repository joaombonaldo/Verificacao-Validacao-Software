import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento {
    private boolean isVIP;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Estacionamento(LocalDateTime entrada, LocalDateTime saida, boolean isVIP) {
        this.entrada = entrada;
        this.saida = saida;
        this.isVIP = isVIP;
    }

    public double calcularValor() {
        Duration duracao = Duration.between(entrada, saida);
        long minutos = duracao.toMinutes();
    
        if (minutos <= 15) {
            return 0.0;
        }
    
        double valor = 0.0;
    
        if (minutos <= 60) {
            valor = 5.90;
        } else {
            long horas = minutos / 60;
            long minutosRestantes = minutos % 60;
            
            valor = 5.90 + (horas - 1) * 2.50;
            
            if (minutosRestantes > 0) {
                valor += 2.50;
            }
    
            if (saida.toLocalDate().isAfter(entrada.toLocalDate()) && saida.getHour() >= 8) {
                valor = 50.0;
            }
        }
    
        if (isVIP) {
            valor *= 0.5;
        }
    
        return valor;
    }
    
}

