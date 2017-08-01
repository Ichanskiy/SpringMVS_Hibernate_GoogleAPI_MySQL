package com.entity.subsidary;

import com.entity.User;
import lombok.*;

/**
 * Created by Ichanskiy on 2017-05-27.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorisationUser extends User {
    
    private String user_phone;
    private String user_email;
}
