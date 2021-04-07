package ru.sibadi.demowebapp.domain;

public class Payment {
    private  final int id;
    private final int personId;
    private int salary;
    private int prize;
    private String date;

    public Payment(int id, int personId, int salary, int prize, String date) {
        this.id = id;
        this.personId = personId;
        this.salary = salary;
        this.prize = prize;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getPrize() {
        return prize;
    }

    public String getDate() {
        return date;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPersonId() {
        return personId;
    }
}
