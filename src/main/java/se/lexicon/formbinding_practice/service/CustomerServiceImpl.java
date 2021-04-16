package se.lexicon.formbinding_practice.service;

import org.springframework.stereotype.Service;
import se.lexicon.formbinding_practice.converter.CustomerConverter;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    CustomerConverter customerConverter;

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setCustomerConverter(CustomerConverter customerConverter) {
        this.customerConverter = customerConverter;
    }

    @Override
    public CustomerDto saveOrUpdate(CustomerDto customerDto) {
        return null;
    }

    @Override
    public List<CustomerDto> getAll() {
        return null;
    }

    @Override
    public CustomerDto findByCustomerId(String id) {
        return null;
    }
}
