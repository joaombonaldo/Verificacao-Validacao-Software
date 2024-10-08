import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstacionamentoTest {

    @ParameterizedTest(name = "{0} -> {1}, VIP: {2} = {3}")
    @CsvSource({
        "2024-10-01T08:00, 2024-10-01T08:15, false, 0.0",  // Cortesia até 15 minutos
        "2024-10-01T08:00, 2024-10-01T08:15, true, 0.0",   // Cortesia VIP
        "2024-10-01T08:00, 2024-10-01T09:00, false, 5.90",  // Exatamente 1 hora
        "2024-10-01T08:00, 2024-10-01T09:00, true, 2.95",   // Exatamente 1 hora VIP
        "2024-10-01T08:00, 2024-10-01T09:30, false, 8.40",  // 90 minutos
        "2024-10-01T08:00, 2024-10-01T09:30, true, 4.20",   // 90 minutos VIP
        "2024-10-01T08:00, 2024-10-02T08:01, false, 50.0",  // Pernoite
        "2024-10-01T08:00, 2024-10-02T08:01, true, 25.0"    // Pernoite VIP
    })
    void testCalcularValor(String entradaStr, String saidaStr, boolean isVIP, double valorEsperado) {
        // Convertendo as strings para LocalDateTime
        LocalDateTime entrada = LocalDateTime.parse(entradaStr);
        LocalDateTime saida = LocalDateTime.parse(saidaStr);
        
        // Criando o objeto Estacionamento com os valores de entrada, saída e VIP
        Estacionamento estacionamento = new Estacionamento(entrada, saida, isVIP);
        
        // Verificando se o valor calculado corresponde ao valor esperado
        assertEquals(valorEsperado, estacionamento.calcularValor(), 0.01);
    }
}
