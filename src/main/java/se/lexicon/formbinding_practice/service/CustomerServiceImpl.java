package se.lexicon.formbinding_practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.formbinding_practice.converter.CustomerConverter;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;
import se.lexicon.formbinding_practice.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    CustomerRepository customerRepository;
    CustomerConverter customerConverter;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setCustomerConverter(CustomerConverter customerConverter) {
        this.customerConverter = customerConverter;
    }

    @Override
    public CustomerDto saveOrUpdate(CustomerDto customerDto) {
        if (customerDto == null) throw new IllegalArgumentException("CustomerDto is not valid.");
        Customer convertDtoToModel = customerConverter.toModel(customerDto);
        Customer savedObject = customerRepository.save(convertDtoToModel);

        return customerConverter.toDTO(savedObject);
    }

    @Override
    public List<CustomerDto> getAll() {
        Iterable<Customer> iterable = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        iterable.iterator().forEachRemaining(customerList::add);

        return new ArrayList<>(customerConverter.toDTOs(customerList));
    }

    @Override
    public CustomerDto findByCustomerId(String id) {
        if (id == null) throw new IllegalArgumentException("Customer id can't be null");
        Customer customer = customerRepository.findById(id).orElse(null);

        return customerConverter.toDTO(customer);
    }
}
