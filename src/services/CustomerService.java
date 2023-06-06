package services;

import dto.ProfileResponse;
import dto.RegisterRequest;
import dto.RegisterResponse;
import dto.UpdateRequest;

public interface CustomerService {
    public RegisterResponse registerCustomer(RegisterRequest registerRequest);
    public ProfileResponse viewProfile(int customerId);
    public ProfileResponse updateFirstName(UpdateRequest updateRequest);
    public ProfileResponse updateLastName(UpdateRequest updateRequest);
    public ProfileResponse updateEmail(UpdateRequest updateRequest);
    public String deleteAccount (int customerId);
}
