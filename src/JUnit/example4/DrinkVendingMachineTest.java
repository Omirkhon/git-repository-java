package JUnit.example4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkVendingMachineTest {
    private static DrinkVendingMachine machine;

    @BeforeEach
    public void createVendingMachine() {
        machine = new DrinkVendingMachine();
    }

    @Test
    public void shouldNotInsertWhenValueIsNotMoreThanZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class , () -> machine.insertCoin(-10));

        assertEquals("Число должно быть положительным", exception.getMessage());
    }

    @Test
    public void shouldInsertWhenValueIsMoreThanZero() {
        machine.insertCoin(250);

        assertEquals(250, machine.getBalance());
    }

    @Test
    public void shouldNotSellDrinkWhenNotAvailable() {
        String message = machine.selectDrink("Пепси");

        assertEquals("Такого напитка нет в автомате.", message);
    }

    @Test
    public void shouldNotSellWhenRunOutOfDrink() {
        String drink = "Фанта";
        String message = null;
        machine.insertCoin(2000);

        for (int i = 0; i <= 5; i++) {
             message = machine.selectDrink(drink);
        }

        assertEquals("Извините, " + drink + " закончился.", message);
    }

    @Test
    public void shouldNotSellWhenNotEnoughCoins() {
        String message = machine.selectDrink("Кола");

        assertEquals("Недостаточно средств.", message);
    }

    @Test
    public void shouldGetDrinkQuantity() {
        machine.getDrinkQuantity("Спрайт");
    }
}
