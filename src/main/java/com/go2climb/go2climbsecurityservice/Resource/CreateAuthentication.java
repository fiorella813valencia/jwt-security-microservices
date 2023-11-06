package com.go2climb.go2climbsecurityservice.Resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthentication {
    private String username;
    private String password;
}
