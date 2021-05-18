package ru.sibadi.demowebapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final int id;
    private String name;
    private int salary;
    private List<Payment> payments = new ArrayList<>();

    public Person(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPayment(int id, int personId, int salary, int prize, String date) {
        payments.add(new Payment(id, personId, salary, prize, date));
    }

    public Payment searchPaymentById(int id) {
        Payment payment = null;
        for (Payment p : payments) {
            if (p.getId() == id) {
                payment = p;
            }
        }
        return  payment;
    }
}
