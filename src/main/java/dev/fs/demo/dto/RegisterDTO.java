package dev.fs.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link dev.fs.demo.model.User}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO implements Serializable {
    String firstName;
    String lastName;
    String email;
    String password;
}