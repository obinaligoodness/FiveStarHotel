package data.repositories;

import data.models.Customer;

import java.util.ArrayList;

public interface CustomerInterface {

    public Customer saveCustomer(Customer customer);
    public Customer findCustomerById(int customerId);
    public ArrayList<Customer> findAllCustomer();
    public Customer delete(int customerId);
//    public Customer updateCustomer(Customer customer);
}
