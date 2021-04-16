package se.lexicon.formbinding_practice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDto {
    private String customerId;
    private String email;
    private LocalDate regDate;
    private boolean active;
    private CustomerDetailsDto customerDetailsDto;
}
