package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.agenda.Modelo.Agenda;
import org.iesalandalus.programacion.agenda.Modelo.Contacto;
import org.iesalandalus.programacion.utilidades.Entrada;


/*
 *
 * @author María José 
 * @version 3 junio
 * 
 */
public class MainApp {
        
        static final String ERROR = "ERROR";
        static final String EXITO = "Operacion realizada satisfactoriamente.";
        private static Agenda agenda=new Agenda();
      


        
	public static void main(String[] args) throws OperationNotSupportedException {
            
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
    
        private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException 
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
                    
                    buscarContacto();
                                      
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
        
            
            System.out.println("Añadir nuevo contacto");
           
            System.out.println("Nombre: ");
            nombre=Entrada.cadena();
            System.out.println("Telefono: ");
            telefono=Entrada.cadena();
            System.out.println("Correo: ");
            correo=Entrada.cadena();
          
            try
            {
       
            Contacto contacto=new Contacto(nombre, telefono, correo);            
                
            agenda.anadir(contacto);
           
             System.out.println(EXITO);
            }
            
            catch(IllegalArgumentException e){
                    
                throw new OperationNotSupportedException (ERROR);
            }
        } 
        
	    
 
                 
         
        //Opción 2
        
        private static void buscarContacto() 
        {
                 
          
    	    String nombre;
            System.out.println("Introduce el nombre del contacto que quieres buscar.");
            nombre = Entrada.cadena();
	
                if (agenda.buscar(nombre) == null) {
			System.out.println(ERROR );
		}else {
			System.out.println(EXITO);
			System.out.println(agenda.buscar(nombre).toString());
		}
	}
  
               
       
        // Opción 3
         private static void borrarContacto() throws OperationNotSupportedException
        {
            String nombre;
            
            
            System.out.println("Introduce el contacto de la agenda a borrar");
            nombre=Entrada.cadena();        
        
            
            try
            {
            agenda.borrar(nombre);
            
            System.out.println(EXITO);
            
            }
            catch (OperationNotSupportedException e) 
            {
                    System.out.println("ERROR: "+e.getMessage());
            }
            
        }
    
     		 
         
        
        //Opcion 4
        private static void listarAgenda()
        {
           if(agenda.getNumContactos()==0) {
		
                System.out.println(ERROR);
		System.out.println("La agenda no tiene contactos.");
	} else {
		System.out.println("La lista de contactos es:");
		
                Contacto[] contactos = agenda.getContactos();
		
                for(int i = 0; i<contactos.length && contactos[i]!=null; i++)
		
                    System.out.println(contactos[i]);
                   
		}
	}

 	
}

        
      

        


    





