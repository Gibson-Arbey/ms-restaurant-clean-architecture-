package co.clean_architecture.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class User {

    private final Long id;

    private final String name;

    private final String lastName;

    private final String documentNumber;

    private final LocalDate birthDate;

    private final String phoneNumber;

    private final String mail;

    private final String status;

    private final Long roleId;


}
