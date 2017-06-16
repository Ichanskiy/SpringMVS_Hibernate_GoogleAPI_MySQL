package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Ichanskiy on 2017-05-27.
 */
@Getter
@Setter
@ToString
public class AuthorisationUser extends User {
    
    private String user_phone;
    private String user_email;
}
