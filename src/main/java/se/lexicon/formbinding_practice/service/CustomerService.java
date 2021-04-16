package se.lexicon.formbinding_practice.service;

import se.lexicon.formbinding_practice.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto saveOrUpdate(CustomerDto customerDto);
    List<CustomerDto> getAll();
    CustomerDto findByCustomerId(String id);
}
