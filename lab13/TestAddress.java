package ru.mirea.lab13;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class TestAddress {
    private static String removeSpaces(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    private static Address parseAddressFromString(String string, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, delimiter);
        Address address = new Address();
        address.setCountry(stringTokenizer.nextToken());
        address.setRegion(removeSpaces(stringTokenizer.nextToken()));
        address.setCity(removeSpaces(stringTokenizer.nextToken()));
        address.setStreet(removeSpaces(stringTokenizer.nextToken()));
        address.setBuildingNumber(Integer.parseInt(removeSpaces(stringTokenizer.nextToken())));
        address.setBuildingSecondNumber(Integer.parseInt(removeSpaces(stringTokenizer.nextToken())));
        address.setFlatNumber(Integer.parseInt(removeSpaces(stringTokenizer.nextToken())));
        return address;
    }

    private static Address createAddressFromList(List<String> arr) {
        Address address = new Address();
        address.setCountry(removeSpaces(arr.get(0)));
        address.setRegion(removeSpaces(arr.get(1)));
        address.setCity(removeSpaces(arr.get(2)));
        address.setStreet(removeSpaces(arr.get(3)));
        address.setBuildingNumber(Integer.parseInt(removeSpaces(arr.get(4))));
        address.setBuildingSecondNumber(Integer.parseInt(removeSpaces(arr.get(5))));
        address.setFlatNumber(Integer.parseInt(removeSpaces(arr.get(6))));
        return address;
    }

    public static void main(String[] args) {
        String string1 = "Russia, CentralRegion, Moscow, VernadskyProspect, 78, 1, 215";
        String string2 = "Russia.CentralRegion.Moscow.VernadskyProspect.78.1.215";
        String string3 = "Russia; CentralRegion; Moscow; VernadskyProspect; 78; 1; 215";
        String string4 = "Russia-CentralRegion-Moscow-VernadskyProspect-78-1-215";
        System.out.println(parseAddressFromString(string1, ","));
        System.out.println(parseAddressFromString(string2, "."));
        System.out.println(parseAddressFromString(string3, ";"));
        System.out.println(parseAddressFromString(string4, "-"));
        List<String> list = Arrays.asList(string1.split(","));
        System.out.println(createAddressFromList(list));
    }
}

class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private int buildingNumber;
    private int buildingSecondNumber;
    private int flatNumber;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setBuildingSecondNumber(int buildingSecondNumber) {
        this.buildingSecondNumber = buildingSecondNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", buildingSecondNumber=" + buildingSecondNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
