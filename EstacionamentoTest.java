import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EstacionamentoTest {
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private boolean isVIP;
    private double valorEsperado;

    public EstacionamentoTest(LocalDateTime entrada, LocalDateTime saida, boolean isVIP, double valorEsperado) {
        this.entrada = entrada;
        this.saida = saida;
        this.isVIP = isVIP;
        this.valorEsperado = valorEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            // Cortesia
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 1, 8, 15), false, 0.0 },
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 1, 8, 15), true, 0.0 },
            // Exatamente 60 minutos
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 1, 9, 0), false, 5.90 },
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 1, 9, 0), true, 2.95 },
            // 90 minutos (acima de 60 minutos)
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 1, 9, 30), false, 8.40 },
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 1, 9, 30), true, 4.20 },
            // Pernoite
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 2, 8, 1), false, 50.0 },
            { LocalDateTime.of(2024, 10, 1, 8, 0), LocalDateTime.of(2024, 10, 2, 8, 1), true, 25.0 },
        });
    }

    @Test
    public void testCalcularValor() {
        Estacionamento estacionamento = new Estacionamento(entrada, saida, isVIP);
        assertEquals(valorEsperado, estacionamento.calcularValor(), 0.01);
    }
}
