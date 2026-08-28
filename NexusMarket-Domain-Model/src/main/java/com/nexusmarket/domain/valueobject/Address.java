package com.nexusmarket.domain.valueobject;

import java.util.Objects;

public final class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String country;

    public Address(String street, String city, String state, String postalCode, String country) {
        this.street = Objects.requireNonNull(street);
        this.city = Objects.requireNonNull(city);
        this.state = Objects.requireNonNull(state);
        this.postalCode = Objects.requireNonNull(postalCode);
        this.country = Objects.requireNonNull(country);
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address other)) return false;
        return street.equals(other.street)
                && city.equals(other.city)
                && state.equals(other.state)
                && postalCode.equals(other.postalCode)
                && country.equals(other.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, postalCode, country);
    }
}
