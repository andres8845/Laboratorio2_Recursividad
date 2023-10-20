/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_recursividad;

/**
 *
 * @author andre
 */
public class Palindromo_Air {

    public Palindromo_Air() {
    }
    
     Ticket asientos[] = new Ticket[30];
     public static String monto;

    private int firstAvailable(int num_asiento) {
        if(num_asiento<30){
        if (asientos[num_asiento] != null) 
            return firstAvailable(num_asiento + 1);
        return num_asiento;
        }
        return -1;
    }

    public int firstAvailable() {
        return firstAvailable(0);
    }

    public String dispatch(){
        String montos=income()+"";
        monto=montos;
        reset();
        return montos;
    }
    
    private int searchPassenger(String name, int num_asiento) {
        if (asientos[num_asiento].getNamePasajero() != null&&asientos[num_asiento].getNamePasajero().equals(name)) {
            if(asientos[num_asiento].getNamePasajero().equals(name))
                return num_asiento;
            return searchPassenger(name, num_asiento);
        }
        return -1;
    }

    public int searchPassenger(String name) {
        return searchPassenger(name,0);
    }
    
    private boolean isPalindromo(String palabra, int inicio, int fin){
       if (inicio > fin) {
            if (palabra.charAt(inicio) == palabra.charAt(fin)) {
                return isPalindromo(palabra, inicio + 1, fin - 1);
            }
            return false;
        }
        return true;
    }
    
    public boolean isPalindromo(String name){
        return isPalindromo(name, 0, name.length());
    }
    
    public String sellTicket(String name,String dato){
        int monto;
        if(firstAvailable()!=-1){
             if(isPalindromo(name)){
             asientos[firstAvailable()]=new Ticket(name, 640);
             monto=640;
             }else{
             asientos[firstAvailable()]=new Ticket(name, 800);
             monto=800;
             }
              dato="Pasagero: "+name+ " Monto a pagar: "+monto;
              System.out.println(dato);
              return dato;
        }
        return "";
    }
    
    public boolean cancelTicket(String name){
    if(searchPassenger(name)!=-1){
        if(asientos[searchPassenger(name)]!=null){
        asientos[searchPassenger(name)]=null;
        return true;
        }
    }
    return false;
    }
 
    public void reset(){
         reset(0);
    }
    private void reset(int i){
        
         if(i<asientos.length){
             asientos[i]=null;
           reset(i+1);
         }    
    }

     public String printPassengers(){
        return printPassengers(0,"");
    }
    
    private String printPassengers(int ind,String Datosgeneral){
        if(ind<30){
            if(asientos[ind]!=null){
            String datos="\nNombre: "+asientos[ind].getNamePasajero()+" - Monto: $"+asientos[ind].getTotalTicket();
            return printPassengers(ind+1,Datosgeneral+datos);
            }
        }
        return Datosgeneral;
    }
    
        private double income(int pos, double total){
        if(pos<30){
            if(asientos[pos]!=null){
            return income(pos+1,total+asientos[pos].getTotalTicket());
            }
        }
        return total;
    }
    
    
    public double income(){
   
     return income(0,0);
    }
    
}
