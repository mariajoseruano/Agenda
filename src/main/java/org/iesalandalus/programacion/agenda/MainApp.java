package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
        
        static final String ERROR = "ERROR: ";
        static final String EXITO = "Operacion realizada satisfactoriamente.";
        private static Agenda agenda;
        private static Contacto contacto;
        private static final int MAX_CONTACTOS=10;
        private static Contacto [] lista=new Contacto[MAX_CONTACTOS];


        
	public static void main(String[] args) {
            
            System.out.println("Programa para gestionar una agenda de contactos");
                
            int opcion;
            
            do 
            {
                mostrarMenu();
                opcion = elegirOpcion();
                ejecutarOpcion(opcion);
            } while (opcion != 0);
		
            System.out.println("Fin de uso de la agenda.");
        
        }
    
        private static void mostrarMenu() 
        {
        
            System.out.println("Programa para operar con la Agenda");
            System.out.println("");
            System.out.println("1.- Añadir un Contacto");
            System.out.println("2.- Buscar un contacto");
            System.out.println("3.- Borrar el contacto");	
            System.out.println("4.- Listar todos los contactos no nulos");
            System.out.println("0.- Salir.");
            System.out.println("");
        }
    
        private static int elegirOpcion() 
        {
            int opcion;
            do 
            {
                System.out.println("Elige una opcion (0-4): ");
                opcion = Entrada.entero();
            } while (opcion < 0 || opcion > 4);

            return opcion;
        }
    
        private static void ejecutarOpcion(int opcion) 
        {
        
            switch (opcion) 
            {
          
                case 1:
                    try 
                    {
                        anadirContacto();
                    } 
                    catch (OperationNotSupportedException e) 
                    {
                        System.out.println("ERROR:" + e.getMessage());
                    }
		    break;
                case 2:
                    try 
                    {
                        buscarContacto();
                    } 
                    catch (OperationNotSupportedException e) 
                    {
                        System.out.println("ERROR: "+ e.getMessage());
                    }
                    break;
                case 3:
                    try 
                    {
                        borrarContacto();
                    } 
                    catch (OperationNotSupportedException e) 
                    {
			System.out.println("ERROR: " + e.getMessage());
                    }
        
                    break;
                    
                case 4:
                    listarAgenda();
                    break; 
            }
        }
    
    
        //Opción 1    
        private static void anadirContacto() throws OperationNotSupportedException
        {
            String nombre;
            String telefono;
            String correo;
            int i;
            
            System.out.println("Añadir nuevo contacto");
           
            System.out.println("Nombre: ");
            nombre=Entrada.cadena();
            System.out.println("Telefono: ");
            telefono=Entrada.cadena();
            System.out.println("Correo: ");
            correo=Entrada.cadena();
          
            
            Contacto contacto=new Contacto(nombre, telefono, correo);            
                
                  
                           
            //Buscamos donde insertar el libro
            try
            {
                i=buscaPrimerIndiceLibreExistencia(contacto);
            }
            catch(OperationNotSupportedException e)
            {
                 throw new OperationNotSupportedException("Ya existe un contacto con ese nombre.");
            }
        
            if (noSuperaTamano(i))
                lista[i]=contacto;
             else
                throw new OperationNotSupportedException("El array de contactos está lleno.");
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
    
    
        private static boolean noSuperaTamano(int j)
        {
            if (j>=lista.length)
                return true;
            else
                return false;
        }
   
        
        //Opción 2
        
        private static void buscarContacto() throws OperationNotSupportedException
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
       
        // Opción 3
         private static void borrarContacto() throws OperationNotSupportedException
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
         
    
        //Opcion 4
        private static void listarAgenda()
        {
            for(int i=0;i<lista.length;i++)
            System.out.println(lista[i]);
        }
    }    
        

    

