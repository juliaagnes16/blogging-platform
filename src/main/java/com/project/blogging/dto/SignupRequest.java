package com.project.blogging.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
