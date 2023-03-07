import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void test()
    {
        Employee employee= new Employee(2000,10000,"Marco");
        assertEquals(employee.getBaseSalary(),2000,"Wrong Salary");
        employee.setTarget(7000);
        assertEquals(employee.getTarget(),7000,"Wrong Target");
        Shoe s1= new Shoe(1,"Nike",1000);
        Shoe s2= new Shoe(2,"Adidas",600);
        s1.add(40,1);
        s2.add(40,10);
        s1.sell(40,1,employee);
        assertEquals(employee.getSales(),1000,"Wrong sales");
        s2.sell(40,10,employee);
        assertEquals(employee.getSales(),employee.getTarget(),"Problem with sales or target");
        assertEquals(employee.getSalary(),2070,"Problem with updated salary");
    }

}