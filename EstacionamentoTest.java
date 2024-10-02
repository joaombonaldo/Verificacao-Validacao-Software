import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import org.junit.Test;

public class EstacionamentoTest {

    @Test
    public void testCortesia() {
        Estacionamento estacionamento = new Estacionamento(
            LocalDateTime.of(2024, 10, 1, 8, 0),
            LocalDateTime.of(2024, 10, 1, 8, 15),
            false
        );
        assertEquals(0.0, estacionamento.calcularValor(), 0.01);
    }

    @Test
    public void testUmaHora() {
        Estacionamento estacionamento = new Estacionamento(
            LocalDateTime.of(2024, 10, 1, 8, 0),
            LocalDateTime.of(2024, 10, 1, 9, 0),
            false
        );
        assertEquals(5.90, estacionamento.calcularValor(), 0.01);
    }

    @Test
    public void testVIP() {
        Estacionamento estacionamento = new Estacionamento(
            LocalDateTime.of(2024, 10, 1, 8, 0),
            LocalDateTime.of(2024, 10, 1, 9, 0),
            true
        );
        assertEquals(2.95, estacionamento.calcularValor(), 0.01);
    }

    @Test
    public void testPernoite() {
        Estacionamento estacionamento = new Estacionamento(
            LocalDateTime.of(2024, 10, 1, 8, 0),
            LocalDateTime.of(2024, 10, 2, 9, 1),
            false
        );
        assertEquals(50.0, estacionamento.calcularValor(), 0.01);
    }

    @Test
    public void testAcimaDeUmaHora() {
        Estacionamento estacionamento = new Estacionamento(
            LocalDateTime.of(2024, 10, 1, 8, 0),
            LocalDateTime.of(2024, 10, 1, 10, 0),
            false
        );
        assertEquals(8.40, estacionamento.calcularValor(), 0.01);
    }
}
