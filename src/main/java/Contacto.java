
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
// 3.Crear la clase Contacto con sus atributos.
public class Contacto {
    
        private String nombre;
        private String telefono;
        private String correo;
        private final String ER_TELEFONO= "[69][0-9]{8}";
        private final String ER_CORREO="^[A-Za-z0-9-_]+(\\.[A-Za-z0-9-_]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
         
               
//4. Crear los métodos get y set.
        
        public String getNombre(){
            return nombre;
        } 
     
        public String getTelefono(){
            return telefono;
        } 
     
        public String getCorreo(){
            return correo;
        } 
     
        public void setNombre(String Nombre) 
        {
            if (nombre.equals(""))
        
                throw new IllegalArgumentException("ERROR: No es posible asignar un nombre vacío.");
            
            this.nombre=nombre;
        } 
        
        public void setTelefono ( String telefono)
        {
            if (!(telefono.matches(ER_TELEFONO)))
            
                    throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido");
            
            
            this.telefono=telefono;
        }  
        public void setCorreo ( String correo)
        {
            if (!(correo.matches(ER_CORREO)))
            
                    throw new IllegalArgumentException("ERROR: El correo no tiene un formato válido");
            
            
            this.correo=correo;
        }  
        
    //5.Crea el constructor con los parametros adecuados y que haga el mismo control que en el caso anterior.
         public Contacto ( String nombre, String telefono, String correo)
         {
             setNombre(nombre);
             setTelefono(telefono);
             setCorreo(correo);
             
         }
                 
}