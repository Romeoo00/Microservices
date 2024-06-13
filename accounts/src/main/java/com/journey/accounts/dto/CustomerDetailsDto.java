package com.journey.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "CustomerDetails",
        description = "Schema to hold customer and account info"
)
@Data
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the customer", example = "Easy Byte"
    )
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "email of the customer", example = "Easy@gmail.com"
    )
    @NotEmpty(message = "Name can not be null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    @Schema(
            description = "number of the customer", example = "00000000000"
    )
    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "($|[0-9]{10})", message = "Number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;


    @Schema(
            description = "Loans details of the Customer"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Cards details of the Customer"
    )
    private CardsDto cardsDto;
}
