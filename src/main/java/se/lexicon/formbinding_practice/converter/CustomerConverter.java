package se.lexicon.formbinding_practice.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomerConverter implements Converter<Customer, CustomerDto> {

    CustomerDetailsConverter customerDetailsConverter;

    @Autowired
    public void setCustomerDetailsConverter(CustomerDetailsConverter customerDetailsConverter) {
        this.customerDetailsConverter = customerDetailsConverter;
    }

    @Override
    public Customer toModel(CustomerDto dto) {
        Customer customer = new Customer();

        if(dto != null){
            if (dto.getCustomerId() != null){
                customer.setCustomerId(dto.getCustomerId());
            }
            customer.setEmail(dto.getEmail());
            customer.setRegDate(dto.getRegDate());
            customer.setActive(dto.isActive());
            customer.setCustomerdetails(customerDetailsConverter.toModel(dto.getCustomerDetailsDto()));
        }
        return customer;
    }

    @Override
    public CustomerDto toDTO(Customer model) {
        CustomerDto customerDto = new CustomerDto();

        if(model != null){
            customerDto.setCustomerId(model.getCustomerId());
            customerDto.setEmail(model.getEmail());
            customerDto.setRegDate(model.getRegDate());
            customerDto.setActive(model.isActive());
            customerDto.setCustomerDetailsDto(customerDetailsConverter.toDTO(model.getCustomerdetails()));
        }
        return customerDto;
    }

    @Override
    public Collection<Customer> toModels(Collection<CustomerDto> collection) {
        Collection<Customer> customers = new ArrayList<>();
        if (collection != null){
            for (CustomerDto customerDto : collection){
                customers.add(toModel(customerDto));
            }
        }
        return customers;
    }

    @Override
    public Collection<CustomerDto> toDTOs(Collection<Customer> collection) {
        Collection<CustomerDto> customerDtos = new ArrayList<>();
        if (collection != null){
            for (Customer customer : collection){
                customerDtos.add(toDTO((customer)));
            }
        }
        return customerDtos;
    }
}
