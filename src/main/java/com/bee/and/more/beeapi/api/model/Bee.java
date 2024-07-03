package com.bee.and.more.beeapi.api.model;

import java.util.UUID;

public class Bee {
    private UUID id;
    private String species;
    private int age;
    private String role; // "Worker", "Queen", "Drone"
    private String temperament; // "Calm", "Aggressive"
    private double diseaseResistance;

    // Constructor
    public Bee(String species, int age, String role, String temperament, double diseaseResistance) {
        this.id = UUID.randomUUID();
        this.species = species;
        this.age = age;
        this.role = role;
        this.temperament = temperament;
        this.diseaseResistance = diseaseResistance;
    }

    // Getter for id
    public UUID getId() {
        return id;
    }

    // Getter for species
    public String getSpecies() {
        return species;
    }

    // Setter for species
    public void setSpecies(String species) {
        this.species = species;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }

    // Getter for temperament
    public String getTemperament() {
        return temperament;
    }

    // Setter for temperament
    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    // Getter for disease resistance
    public double getDiseaseResistance() {
        return diseaseResistance;
    }

    // Setter for disease resistance
    public void setDiseaseResistance(double diseaseResistance) {
        this.diseaseResistance = diseaseResistance;
    }

    // Method to display bee information
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age + " days");
        System.out.println("Role: " + role);
        System.out.println("Temperament: " + temperament);
        System.out.println("Disease Resistance: " + diseaseResistance);
    }

    // Method to simulate bee buzzing
    public void buzz() {
        System.out.println("Bzzz... Bzzz...");
    }
}





