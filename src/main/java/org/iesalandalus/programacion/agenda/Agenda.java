/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

/**
 *
 * @author Usuario
 * 
 */
//Ejercicio 7.Crear clase Agenda con los atributos.
public class Agenda {
    
    
    private int numContactos;
    private static int MAX_CONTACTOS;
    private Contacto contacto;
 
 //Ejercicio 8. Crear métodos get.Tener en cuenta getContactos devuelve una copia del array de contactos.
    
        public String getContactos(){
                return contacto;
        } 
         public int getNumContactos(){
                return numContactos;
        } 
        
    
    
}
