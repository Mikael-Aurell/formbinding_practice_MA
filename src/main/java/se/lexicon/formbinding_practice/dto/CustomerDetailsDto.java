package se.lexicon.formbinding_practice.dto;

import lombok.Data;

@Data
public class CustomerDetailsDto {
    private String detailsId;
    private String street;
    private String zipCode;
    private String city;
    private String homePhone;
    private String cellPhone;
}
