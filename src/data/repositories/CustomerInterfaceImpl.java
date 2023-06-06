package data.repositories;

import data.models.Customer;

import java.util.ArrayList;

public class CustomerInterfaceImpl implements CustomerInterface {
    private static ArrayList<Customer> customers = new ArrayList<>();
    private int customerId = 0;

    @Override
    public Customer saveCustomer(Customer customer) {
        boolean customerHasBeenSaved = customer.getId() != 0;
        if (!customerHasBeenSaved) {
            customers.add(customer);
            int id = generateId();
            customer.setId(id);
        }
        return customer;
    }

    @Override
    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) return customer;
        }
        return null;
    }

    private int generateId() {
        return ++customerId;
    }

    @Override
    public ArrayList<Customer> findAllCustomer() {
        return customers;
    }

    @Override
    public Customer delete(int customerId) {
        var customer = findCustomerById(customerId);
        customers.remove(customer);
        return customer;
    }

}
