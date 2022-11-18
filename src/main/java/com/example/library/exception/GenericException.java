package com.example.library.exception;

import com.example.library.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GenericException  extends RuntimeException{

    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;

}
