package com.journey.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold account and customer info"
)
public class AccountsDto {


    @NotEmpty(message = "Account number can not be a null or empty")
    @Pattern(regexp = "($|[0-9]{10})", message = "Number must be 10 digits")
    private Long accountNumber;


    @Schema(
            description = "Account Type of the customer", example = "Saving"
    )
    @NotEmpty(message = "Account type cannot be a null or empty ")
    private String accountType;


    @Schema(
            description = "BranchAddress of the customer", example = "Easy Byte branch address"
    )
    @NotEmpty(message = "BranchAddress type cannot be a null or empty ")
    private String branchAddress;
}
