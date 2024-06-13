package com.journey.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response format"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "Error path representing the error happened"
    )
    private String apiPath;

    @Schema(
            description = "Error code representing that error happened"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message representing that error happened"
    )
    private String errorMessage;

    private LocalDateTime errorTime;



}
