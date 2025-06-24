package main.java.com.user.user.customer;
    


public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}