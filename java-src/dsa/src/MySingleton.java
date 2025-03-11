/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author handler
 */
public class MySingleton {
    
    private volatile static MySingleton instance;

    private MySingleton() {}

    public synchronized static MySingleton getInstance() {
        if(instance == null) {
            instance = new MySingleton();
        }
        return instance;   
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
