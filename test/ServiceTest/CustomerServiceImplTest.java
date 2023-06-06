package ServiceTest;

import data.models.Customer;
import dto.RegisterRequest;
import dto.UpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.CustomerService;
import services.CustomerServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceImplTest {
    CustomerService customerService;
    Customer customer;
    RegisterRequest registerRequest;
    UpdateRequest updateRequest;
    @BeforeEach
    public void setUp(){
        customerService = new CustomerServiceImpl();
        customer = new Customer();
        registerRequest = new RegisterRequest();
        updateRequest = new UpdateRequest();
    }

    @Test
    public void testThatCustomerCanRegister(){
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obiali@goodnessshhdfegb");
        var registeredCustomer = customerService.registerCustomer(registerRequest);
        assertEquals(registeredCustomer.getFirstName(),customerService.registerCustomer(registerRequest).getFirstName());
    }
    @Test
    public void testThatCustomerCanViewProfile(){
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obiali@goodnessshhdfegb");
        var registeredCustomer = customerService.registerCustomer(registerRequest);
        var customerId = registeredCustomer.getCustomerId();
        assertEquals(registerRequest.getLastName(),customerService.viewProfile(customerId).getLastName());
    }
    @Test
    public void testThatCustomerCanUpdateEmail(){
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obialigoodness@gmail.com");
        var registeredCustomer = customerService.registerCustomer(registerRequest);
        var customerId = registeredCustomer.getCustomerId();
        updateRequest.setCustomerId(customerId);
        updateRequest.setEmail("goodnessobinali@gmail.com");
        customerService.updateEmail(updateRequest);
//        System.out.println(customerService.viewProfile(customerId).getLastName());
        assertEquals("goodness",customerService.viewProfile(customerId).getFirstName());
        assertEquals("obinali",customerService.viewProfile(customerId).getLastName());
        assertEquals("goodnessobinali@gmail.com",customerService.viewProfile(customerId).getEmail());
    }

    @Test
    public void testThatCustomerCanDeleteAccount(){
        registerRequest.setFirstName("goodness");
        registerRequest.setLastName("obinali");
        registerRequest.setEmail("obiali@goodnessshhdfegb");
        var registeredCustomer = customerService.registerCustomer(registerRequest);
        var customerId = registeredCustomer.getCustomerId();
        assertEquals("deleted successfully",customerService.deleteAccount(customerId));
    }
}
