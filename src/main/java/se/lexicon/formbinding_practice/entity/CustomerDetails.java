package se.lexicon.formbinding_practice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @NotBlank(message= "Field email is required")
    private String detailsId;

    @Column(columnDefinition = " 123 test st, test city, TT 12345")
    @Pattern(regexp = "/\\d{1,6}\\s(?:[A-Za-z0-9#]+\\s){0,7}(?:[A-Za-z0-9#]+,)\\s*(?:[A-Za-z]+\\s){0,3}(?:[A-Za-z]+,)\\s*[A-Z]{2}\\s*\\d{5}/gm")
    private String street;
//    123 test st, test city, TT 12345

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String homePhone;

    @Column(nullable = false)
    private String cellPhone;
}
