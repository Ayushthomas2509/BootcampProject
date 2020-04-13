package ayushproject.ayushecommerce.services;

import ayushproject.ayushecommerce.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {
   @Autowired
    CustomerRepo customerRepo;
}

