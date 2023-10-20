/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_recursividad;

/**
 *
 * @author andre
 */
public class Ticket {
    private String namePasajero;
    private double totalTicket;
    
    public Ticket(String namePasajero, double totalTicket) {
        this.namePasajero = namePasajero;
        this.totalTicket = totalTicket;
    }

    public String getNamePasajero() {
        return namePasajero;
    }

    public double getTotalTicket() {
        return totalTicket;
    }
    
    
    public void print(){
        System.out.println("Pasajero: "+namePasajero);
        System.out.println("Monto a pagar: "+totalTicket);
    }
}
