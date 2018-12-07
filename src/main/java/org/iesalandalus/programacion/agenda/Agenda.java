/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

/**
 *
 * @author Usuario
 * 
 */
//Ejercicio 7.Crear clase Agenda con los atributos.
public class Agenda {
    
    
    private int numContactos;
    private Contacto contacto;
    private static final int MAX_CONTACTOS=10;
    private static Contacto [] lista=new Contacto[MAX_CONTACTOS];
 
 //Ejercicio 8. Crear métodos get.Tener en cuenta getContactos devuelve una copia del array de contactos.
    
        public Contacto getContactos(){
                return contacto;
        } 
         public int getNumContactos(){
                return numContactos;
        } 
        
/* Ejericio 9.Crear método añadir.Para añadir un contacto a la agenda de forma que ésta se quede ordenada
por orden de inserción y sin que admita contactos repetidos. Apóyate en los métodos privados
buscarPrimerIndiceComprobandoExistencia e IndiceNoSuperaTamano. El método debe informar de todos los posibles
errores mediante la excepcion OperationNotSupportedException: ya existe ese contacto, el array está lleno, etc.*/ 
         
         
        public void añadir()
        { 
            String nombre,telefono,correo;
                
            
            System.out.println("Añadir nuevo contacto");
           
            System.out.println("Nombre: ");
            nombre=Entrada.cadena();
            System.out.println("Teléfono: ");
            telefono=Entrada.cadena();
            System.out.println("Correo: ");
            correo=Entrada.cadena();
        
            // Creamos el contacto:        
            Contacto contacto=new Contacto(nombre, telefono, correo);
            
        }
                        
              
        private static int buscaPrimerIndiceLibreExistencia(Contacto contacto ) throws OperationNotSupportedException
        {
             int indiceLibre=0;
             boolean encontradoContacto=false;
        
            for(int i=0;i<lista.length && !encontradoContacto;i++)
            {
                if (lista[i]==null)
                {
                    encontradoContacto=true;
                    indiceLibre=i;
                }
            else if (lista[i].equals(contacto))
            {
                throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
            }               
        }
        
            return indiceLibre;
        }
    
    
        private static boolean noSuperaTamaño(int j)
        {
            if (j>=lista.length)
                return true;
            else
                return false;
        }
   
   /*Ejercicio 10. Crea el método buscar que recibirá el nombre del contacto y devolverá el contacto.
    Apoyáte en el método privado buscarIndiceCliente.*/
        
        private static void buscar() throws OperationNotSupportedException
        {
            String nombre;
            int i;
                        
            System.out.println("Introduce el nombre del contacto a buscar");
            nombre=Entrada.cadena();        
        
            //Creamos el contacto con los restantes atributos inventados
            
            Contacto contacto=new Contacto(nombre,"656787878","maria@gmail.com");
            
            i=buscarIndiceCliente(contacto);
        
            if (i==-1){
                throw new OperationNotSupportedException("El contacto buscado no se encuentra en la agenda");
            }else
                System.out.println("El contacto se encuentra en la posición "+i);
             
        }
    
    
        
         private static int buscarIndiceCliente(Contacto contacto)
        {
             int indice=-1;
        
            for(int i=0;i<lista.length;i++)
        {
            if (lista[i]!=null && lista[i].equals(contacto))
                return indice=i;            
        }
        
        return indice;
        }
   
  /*Ejericio 11.Crea el método borrar que borrará un contacto de la lista dejando la misma compactada 
(los contactos válidos al principio y los nulos al final). Apóyate en el método desplazarUnaPosicionHaciaIzquierda. 
El método debe informar de los posibles errores mediante la excepcion OperationNotSupportedException. */
   
        private static void borraLibro() throws OperationNotSupportedException
        {
            String nombre;
            int i;
                
            System.out.println("Introduce el contacto de la agenda a buscar");
            nombre=Entrada.cadena();        
        
            //Creamos el libro con los restantes atributos inventados
            Contacto contacto=new Contacto(nombre,"654890345","juan@gmail.com");
        
            i=buscarIndiceCliente(contacto);
        
            if (i==-1){
            throw new OperationNotSupportedException("El contacto a borrar no existe.");
            }else
            desplazarUnaPosicionHaciaIzquierda(i);
        }
    
         
         
         
        private static void desplazarUnaPosicionHaciaIzquierda(int indice) 
        {
            for (int i = indice; i < lista.length - 1 && lista[i] != null; i++) 
            {
            lista[i] = lista[i+1];
            }
        }
         
    
        
}
    
