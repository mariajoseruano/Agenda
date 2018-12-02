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
    private static Contacto [] agenda=new Contacto[MAX_CONTACTOS];
 
 //Ejercicio 8. Crear métodos get.Tener en cuenta getContactos devuelve una copia del array de contactos.
    
        public Contacto getContacto(){
                return contacto;
        } 
         public int getNumContactos(){
                return numContactos;
        } 
        
/* Ejericio 9.Crear método añadir.Para añadir un contacto a la agenda de forma que ésta se quede ordenada
por orden de inserción y sin que admita contactos repetidos. Apóyate en los métodos privados
buscarPrimerIndiceComprobandoExistencia e IndiceNoSuperaTamano. El método debe informar de todos los posibles
errores mediante la excepcion OperationNotSupportedException: ya existe ese contacto, el array está lleno, etc.*/ 
         
         
        public void añadir(Contacto contacto)
        { 
             String nuevoContacto;
            nuevoContacto=agenda.getContacto();     
            
        {    
                     
            contacto=new Contacto(nuevoContacto);
            System.out.println("El nuevo contacto es:"+ nuevoContacto);  
       
        }
        } 
                        
       
       
        private static int buscaPrimerIndiceLibreExistencia(Contacto contacto ) throws OperationNotSupportedException
        {
             int indiceLibre=0;
             boolean encontradoContacto=false;
        
            for(int i=0;i<agenda.length && !encontradoContacto;i++)
            {
                if (agenda[i]==null)
                {
                    encontradoContacto=true;
                    indiceLibre=i;
                }
            else if (agenda[i].equals(contacto))
            {
                throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
            }               
        }
        
            return indiceLibre;
        }
    
    
        private static boolean noSuperaTamaño(int j)
        {
            if (j>=agenda.length)
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
            Contacto contacto;
            
            System.out.println("Introduce el nombre del contacto a buscar");
            nombre=Entrada.cadena();        
        
            //Creamos el libro con los restantes atributos inventados
            Contacto contacto=new Contacto(nombre, "657678987","maria@ruano.com");
        
            i=buscarIndiceClientes(contacto);
        
            if (i==-1){
                throw new OperationNotSupportedException("El contacto buscado no se encuentra en la agenda");
            }else
                System.out.println("El contacto se encuentra en la posición "+i);
        }
    
    
        
         private static int buscarIndiceCliente(Contacto contacto)
        {
             int indice=-1;
        
            for(int i=0;i<agenda.length;i++)
        {
            if (agenda[i]!=null && agenda[i].equals(contacto))
                return indice=i;            
        }
        
        return indice;
        }
        
  }
    
