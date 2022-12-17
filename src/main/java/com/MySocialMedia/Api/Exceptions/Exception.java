package com.MySocialMedia.Api.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exception {
    private MessageException exceptionDetails;
    private int httpStatusCode;

}
