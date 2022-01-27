package ru.netology.entity;

import java.util.Objects;

public class Location {

    private final String city;

    private final Country country;

    private final String street;

    private final int builing;

    public Location(String city, Country country, String street, int builing) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.builing = builing;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public int getBuiling() {
        return builing;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return  true;
        }
        if(o == null || getClass() != o.getClass()){
              return  false;
        }
        Location location = (Location) o;
        return builing == location.builing && Objects.equals(city, location.city) && country== location.country &&
                Objects.equals(street, location.street);
    }

    @Override
    public int hashCode(){
        int result = builing;
        result = 31 * result +(city!= null ? city.hashCode(): 0);
        result = 31 * result +(country!= null? country.hashCode():0);
        result = 31 * result +(street!= null? street.hashCode():0);
        return result;
    }
}
