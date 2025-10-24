package com.bankstech.blogapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseMessage {
    private String type;
    private String message;
    private Object data;
    private HttpStatus httpStatus;
}
