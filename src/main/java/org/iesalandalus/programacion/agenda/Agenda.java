/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;

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
   
        
        
  }
    
