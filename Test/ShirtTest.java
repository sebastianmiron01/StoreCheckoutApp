import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShirtTest {
    @Test
    public void test()
    {
        Shirt s=new Shirt(1,"adidas T-shirt",200);
        assertEquals(s.getId(),1,"Wrong id.");
        s.initiateConverter();
        s.setName("Nike Crew-Neck");
        assertEquals(s.getName(),"Nike Crew-Neck","Problem with name setter.");
        s.add("L",20);
        s.sell(40,2,null);
        Employee employee=new Employee(2000,10000,"Cosmin");
        assertEquals(s.searchSize("L"),18,"Problem with sell function");
        s.sell(40,2,employee);
        assertEquals(employee.getSales(),400,"Problem with sales");
    }

}