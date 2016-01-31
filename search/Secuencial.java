package search;

public class Secuencial{
    
    int count;
    
    public Secuencial(){
        count = 0;
    }
    
    public int getCount(){
        return count;
    }
    
    /**
     * Busqueda simple, sin validacion de contendido mayor a el
     */
    public int simpleSearch(Integer[] A, Integer target){
        
        count = 0;//Reiniciamos contador
        int i = 0;
        boolean Bandera = false;
        
        while((i < A.length) && (!Bandera)){
            
            count++;//Incrementamos contador         
            if(target.equals(A[i])){
                    Bandera = true;//CAmbiamos la bandera 
            }
            i++;   
        }
        System.out.println(Bandera);
        if(Bandera){
            return i;//Retornamos 
        }else{
            return -1;
        }
    }
    
    /**
     *Busqueda con validacion de elementos mayores a el.
     */
     public int complexSearch(Integer[] A, Integer target){
        
        count = 0;//Reiniciamos contador        
        int i = 0;
        boolean Bandera = false;
        
        while((i < A.length) && (!Bandera) && (target.compareTo(A[i]) >= 0)){
            
            count++;//Incrementamos contador

            if(target.equals(A[i])){
                    Bandera = true;//Cambiamos la bandera 
            }
            i++;            
        }
        if(Bandera){
            return i;//Retornamos 
        }else{
            return -1;
        }
    }
    
    /**
     *Version comprimida
     */
    public int compresSearch(Integer [] A, Integer Target){
        
        count = 0;//Reiniciamos contador
        //Recorremos el arreglo en busqueda del elemento
        for(int i = 0; i < A.length; i++){
                count++;//incrementamos contador
                //Si el elemento de la posicion es el buscado
                if(Target.equals(A[i]))
                    return i;
        }
        
        return -1;//Retorna negativo en caso de no encontrar elemento.
    }
}