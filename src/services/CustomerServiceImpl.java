package services;

import data.repositories.CustomerInterface;
import data.repositories.CustomerInterfaceImpl;
import dto.ProfileResponse;
import dto.RegisterRequest;
import dto.RegisterResponse;
import dto.UpdateRequest;
import utils.Mapper;

public class CustomerServiceImpl implements CustomerService{
    CustomerInterface customerInterface = new CustomerInterfaceImpl();

    @Override
    public RegisterResponse registerCustomer(RegisterRequest registerRequest) {
        var mappedCustomer = Mapper.map(registerRequest);
        var savedCustomer = customerInterface.saveCustomer(mappedCustomer);
        return Mapper.map(savedCustomer);
    }

    @Override
    public ProfileResponse viewProfile(int customerId) {
        var foundCustomer = customerInterface.findCustomerById(customerId);
        var mappedCustomer = Mapper.map(foundCustomer);
       return Mapper.map(mappedCustomer);
    }

    @Override
    public ProfileResponse updateFirstName(UpdateRequest updateRequest) {
        var foundCustomer =  customerInterface.findCustomerById(updateRequest.getCustomerId());
        foundCustomer.setFirstName(updateRequest.getFirstName());
        foundCustomer.setEmail(updateRequest.getEmail());
        foundCustomer.setLastName(updateRequest.getLastName());
        var updatedCustomer = customerInterface.saveCustomer(foundCustomer);
        var mappedUpdatedCustomer = Mapper.map(updatedCustomer);
        return Mapper.map(mappedUpdatedCustomer);
    }

    @Override
    public ProfileResponse updateLastName(UpdateRequest updateRequest) {
        var foundCustomer =  customerInterface.findCustomerById(updateRequest.getCustomerId());
        foundCustomer.setFirstName(updateRequest.getFirstName());
        foundCustomer.setEmail(updateRequest.getEmail());
        foundCustomer.setLastName(updateRequest.getLastName());
        var updatedCustomer = customerInterface.saveCustomer(foundCustomer);
        var mappedUpdatedCustomer = Mapper.map(updatedCustomer);
        return Mapper.map(mappedUpdatedCustomer);
    }

    @Override
    public ProfileResponse updateEmail(UpdateRequest updateRequest) {
        var foundCustomer =  customerInterface.findCustomerById(updateRequest.getCustomerId());
        foundCustomer.setFirstName(foundCustomer.getFirstName());
        foundCustomer.setEmail(updateRequest.getEmail());
        var updatedCustomer = customerInterface.saveCustomer(foundCustomer);
        var mappedUpdatedCustomer = Mapper.map(updatedCustomer);
        return Mapper.map(mappedUpdatedCustomer);
    }

    @Override
    public String deleteAccount(int customerId) {
        var foundCustomer = customerInterface.findCustomerById(customerId);
        var deletedCustomer = customerInterface.delete(foundCustomer.getId());
        return "deleted successfully";
    }

}
