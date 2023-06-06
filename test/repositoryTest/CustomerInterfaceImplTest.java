package repositoryTest;

import data.models.Customer;
import data.repositories.CustomerInterface;
import data.repositories.CustomerInterfaceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerInterfaceImplTest {
    Customer customer;
    CustomerInterface customerInterface;
    @BeforeEach
    public void setUp(){
        customer = new Customer();
        customerInterface = new CustomerInterfaceImpl();
        customer.setFirstName("Goodness");
        customer.setLastName("obinali");
        customer.setEmail("obinaliGoodness@gmail.com");
        customerInterface.saveCustomer(customer);
    }

    @Test
    public void testThatCustomerSaves(){
        assertEquals(1,customer.getId());
    }

    @Test void saveOneCustomerTwice_idIsStillOne(){
        customerInterface.saveCustomer(customer);
        assertEquals(1, customer.getId());
    }

    @Test
    public void testThatCustomerCanBeFoundById(){
        System.out.println(2);
        Customer customer1 = new Customer();
        customer1.setFirstName("Moyinoluwa");
        customer1.setLastName("Michael");
        customer1.setEmail("Michael@gmail.com");
        customerInterface.saveCustomer(customer1);
        System.out.println(customer1.getId());
        assertEquals("Moyinoluwa", customerInterface.findCustomerById(customer1.getId()).getFirstName());
    }
    @Test
    public void testThatACustomerCanBeDeleted(){
        System.out.println(3);
        customerInterface.delete(customer.getId());
        assertEquals(null, customerInterface.findCustomerById(customer.getId()));
    }
}

