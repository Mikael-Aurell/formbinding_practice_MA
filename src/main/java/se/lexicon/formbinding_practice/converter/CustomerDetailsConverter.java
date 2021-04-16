package se.lexicon.formbinding_practice.converter;

import org.springframework.stereotype.Component;
import se.lexicon.formbinding_practice.dto.CustomerDetailsDto;
import se.lexicon.formbinding_practice.entity.CustomerDetails;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomerDetailsConverter implements Converter<CustomerDetails, CustomerDetailsDto> {
    @Override
    public CustomerDetails toModel(CustomerDetailsDto dto) {
        CustomerDetails customerDetails = new CustomerDetails();
        if (dto != null){
            customerDetails.setDetailsId(dto.getDetailsId());
            customerDetails.setStreet(dto.getStreet());
            customerDetails.setZipCode(dto.getZipCode());
            customerDetails.setCity(dto.getCity());
            customerDetails.setHomePhone(dto.getHomePhone());
            customerDetails.setCellPhone(dto.getCellPhone());
        }
        return customerDetails;
    }

    @Override
    public CustomerDetailsDto toDTO(CustomerDetails model) {
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        if (model != null){
            customerDetailsDto.setDetailsId(model.getDetailsId());
            customerDetailsDto.setStreet(model.getStreet());
            customerDetailsDto.setZipCode(model.getZipCode());
            customerDetailsDto.setCity(model.getCity());
            customerDetailsDto.setHomePhone(model.getHomePhone());
            customerDetailsDto.setCellPhone(model.getCellPhone());
        }
        return customerDetailsDto;
    }

    @Override
    public Collection<CustomerDetails> toModels(Collection<CustomerDetailsDto> collection) {
        Collection<CustomerDetails> customerDetailsCollection = new ArrayList<>();
        if (collection != null){
            for (CustomerDetailsDto dto: collection){
                customerDetailsCollection.add(toModel(dto));
            }
        }
        return customerDetailsCollection;
    }

    @Override
    public Collection<CustomerDetailsDto> toDTOs(Collection<CustomerDetails> collection) {
        Collection<CustomerDetailsDto> customerDetailsDtoCollection = new ArrayList<>();
        if (collection != null){
            for (CustomerDetails model: collection){
                customerDetailsDtoCollection.add(toDTO(model));
            }
        }
        return customerDetailsDtoCollection;
    }
}
