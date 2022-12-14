package com.MySocialMedia.Api.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class UserLoginDTO {
    private int id;
    private String userName;
    private String password;
}
