import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {
    @Test
    public void test1() {
        Shoe s = new Shoe(4, "Adidas Galaxy-6", 200);
        Employee employee = new Employee(2000, 10000, "Cosmin");
        assertEquals(s.getPrice(), 200, "Wrong price.");
        s.setName("Nike Blazer Mid");
        assertEquals(s.getName(), "Nike Blazer Mid", "Problem with name setter.");
        s.add(42, 20);
        s.sell(42, 2, employee);
        assertEquals(s.searchSize(42), 18, "Problem with sell function");
        assertEquals(employee.getSales(),400,"Problem with sales");
    }

}