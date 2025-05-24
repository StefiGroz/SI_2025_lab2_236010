import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        SILab2 lab = new SILab2();

        Exception ex1 = assertThrows(RuntimeException.class, () -> lab.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(null, 100, 0, 1, "123"));
        Exception ex2 = assertThrows(RuntimeException.class, () -> lab.checkCart(items2, "1234567890123456"));
        assertEquals("Invalid item!", ex2.getMessage());

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item1", 100, 0, 1, "123"));
        Exception ex3 = assertThrows(RuntimeException.class, () -> lab.checkCart(items3, "123"));
        assertEquals("Invalid card number!", ex3.getMessage());

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item1", 400, 0, 5, "123"));
        double result4 = lab.checkCart(items4, "1234567890123456");
        assertEquals(400 * 5 - 30, result4);

        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("item1", 100, 0, 1, "123"));
        Exception ex5 = assertThrows(RuntimeException.class, () -> lab.checkCart(items5, "1234567890ABCDEF"));
        assertEquals("Invalid character in card number!", ex5.getMessage());

        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("item1", 50, 0, 2, "123"));
        double result6 = lab.checkCart(items6, "1234567890123456");
        assertEquals(50 * 2, result6);
    }

    @Test
    public void testMultipleCondition() {
        SILab2 lab = new SILab2();

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("item1", 350, 0, 1, "123"));
        lab.checkCart(items1, "1234567890123456");

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item1", 100, 5, 1, "123"));
        lab.checkCart(items2, "1234567890123456");

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item1", 100, 0, 15, "123"));
        lab.checkCart(items3, "1234567890123456");

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item1", 100, 0, 1, "123"));
        lab.checkCart(items4, "1234567890123456");
    }
}
