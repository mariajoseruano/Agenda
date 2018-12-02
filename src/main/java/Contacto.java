
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
                 
    /*6.Crea los demás métodos que se muestran en el diagrama de clases, teniendo en cuenta que el método toString
    nos devolverá una cadena con las iniciales del nombre y encerrado entre corchetes el teléfono y el correo separados 
    por comas. También debes tener en cuenta que un contacto será igual que otro si sus nombres, ignorando mayúsculas 
    y minúsculas, son iguales.*/
         

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono="+telefono+ ", correo=" + correo + '}';
    }
    
    public String getIniciales(){
            return nombre;
        } 
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

    
         
        
 
}

