package co.clean_architecture.model.restaurant;

import co.clean_architecture.model.exception.InvalidFieldException;
import lombok.Getter;

@Getter
public class Restaurant {

    private Long id;

    private final String name;

    private final String nit;

    private final String address;

    private final String phone;

    private final String logoUrl;

    private final Long ownerId;

    private Restaurant(Long id, String name, String nit, String address, String phone, String logoUrl, Long ownerId) {
        validateRequiredFields(name, nit, address, phone, logoUrl, ownerId);
        validateName(name);
        validateNit(nit);
        validatePhone(phone);

        this.id = id;
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.logoUrl = logoUrl;
        this.ownerId = ownerId;
    }

    public static Restaurant create(String name, String nit, String address, String phone, String logoUrl, Long ownerId) {
        return new Restaurant(null, name, nit, address, phone, logoUrl, ownerId);
    }

    public static Restaurant restore(Long id,  String name, String nit, String address, String phone, String logoUrl, Long ownerId) {
        return new Restaurant(id, name, nit, address, phone, logoUrl, ownerId);
    }

    private static void validateRequiredFields(String name, String nit, String address,
                                               String phone, String logoUrl, Long ownerId) {

        if (name == null || name.isBlank()) {
            throw new InvalidFieldException("Name is required");
        }
        if (nit == null || nit.isBlank()) {
            throw new InvalidFieldException("NIT is required");
        }
        if (address == null || address.isBlank()) {
            throw new InvalidFieldException("Address is required");
        }
        if (phone == null || phone.isBlank()) {
            throw new InvalidFieldException("Phone is required");
        }
        if (logoUrl == null || logoUrl.isBlank()) {
            throw new InvalidFieldException("Logo URL is required");
        }
        if (ownerId == null) {
            throw new InvalidFieldException("Owner ID is required");
        }
    }

    private static void validateName(String name) {
        if (name.matches("\\d+")) {
            throw new InvalidFieldException("Restaurant name cannot be only numbers");
        }
    }

    private static void validateNit(String nit) {
        if (!nit.matches("\\d+")) {
            throw new InvalidFieldException("NIT must contain only numbers");
        }
    }

    private static void validatePhone(String phone) {
        if (!phone.matches("^\\+?\\d{1,13}$")) {
            throw new InvalidFieldException("Phone must be numeric, max 13 digits, can include '+'");
        }
    }


}
