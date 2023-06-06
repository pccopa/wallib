package com.wallib.challenge.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class User {

    private Long id;

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @Email
    private String email;

    private Date createdBy;
    private Date createdAt = new Date();

}
