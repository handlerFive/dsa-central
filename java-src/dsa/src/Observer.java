/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author handler
 */
public interface Observer {
    void update();
}


class Subscriber implements Observer {
    private String name;
    private String email;

    public Subscriber(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println("Email sent to " + this.email);
    }
}

class Publisher {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Observer subscriber1 = new Subscriber("John", "john@gmail.com");
        Observer subscriber2 = new Subscriber("Jane", "jane@mary.com");
        
}