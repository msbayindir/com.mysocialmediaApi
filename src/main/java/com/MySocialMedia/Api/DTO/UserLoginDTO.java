package com.MySocialMedia.Api.DTO;
import jakarta.annotation.Nullable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UserLoginDTO {
    @Nullable
    private int id;
    @NotEmpty(message = "Username not null")
    //@Pattern(regexp = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$")
    private String userName;
    @NotEmpty(message = "Password not null")
    private String password;
}
