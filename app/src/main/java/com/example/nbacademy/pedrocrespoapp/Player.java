package com.example.nbacademy.pedrocrespoapp;

/**
 * Created by NBAcademy on 01/11/2017.
 */
public class Player {

    private int id;
    private int number;
    private String name;
    private String playerPosition;
    private int age;
    private String description;
    private String strengths;
    private String improvementAspects;
    private boolean isInClub;


    public Player(int number, String name, String playerPosition, int age, String description, String strengths, String improvementAspects, boolean isInClub) {
        this.number = number;
        this.name = name;
        this.playerPosition = playerPosition;
        this.age = age;
        this.description = description;
        this.strengths = strengths;
        this.improvementAspects = improvementAspects;
        this.isInClub = isInClub;
    }

    public boolean isInClub() {
        return isInClub;
    }

    public void setInClub(boolean inClub) {
        isInClub = inClub;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getImprovementAspects() {
        return improvementAspects;
    }

    public void setImprovementAspects(String improvementAspects) {
        this.improvementAspects = improvementAspects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return number + " - " + name;
    }
}