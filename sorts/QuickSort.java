package sorts;

import java.util.*;

public class QuickSort  {
	
	private Integer[] numeros;
	private int c;
	private int Index;
    long time;
    
    public QuickSort(){
        this.Index = 0;
        this.time = 0;
    }
    
    public long getTime(){
        return this.time;
    }

	public void sort(Integer[] values) {
        
        long TInicio = System.currentTimeMillis();
        
        // validar arreglo vacio
        if (values ==null || values.length==0){
            return;
        }
        this.numeros = values;
        c = values.length;
        quicksort(0, c - 1);
        
        long TFin = System.currentTimeMillis();//END
        this.time=TFin-TInicio;
        
	}
	  
	
	private void quicksort(int izq, int der) {
		
        int i = izq, j = der;
        
        // pivote al centro de la lista
        int pivote = numeros[(der+izq)/2];
        
        //System.out.println("pivote =" + pivote);
        
        // Divide en 2 listas
        while (i <= j) {
            //this.Index++;
            // si el valor de la lista izq < pivote
            // obtener el siguiente de la lista izquierda
            while (numeros[i] < pivote) {
              //  this.Index++;
                i++;
            }
            // si el valor de la lista der > pivote
            // obtener el siguiente de la lista derecha
            while (numeros[j] > pivote) {
                //this.Index++;
                j--;
            }
            // si hay valores es la lista izquierda>pivote y
            // hay valores en la lista derecha<pivote
            // intercambiar valores e i++, j--
            if (i <= j) {
            //System.out.println( "i = " + i + " j = " + j);
            //System.out.println( "aux = " + numeros[i]);
            //System.out.println( "j = " + numeros[j]);
            exchange(i, j);
            i++;
            j--;
            }
        }
        // Recursion
        if (izq < j){
            //System.out.println("izq = " + Arrays.asList(numeros));
            quicksort(izq, j);
        }
        if (i < der){
            //System.out.println("der = " + Arrays.asList(numeros));
            quicksort(i, der);
        }
        //System.out.println("return = " + Arrays.asList(numeros));
	}
	
	private void exchange(int i, int j) {
        this.Index++;
        Integer temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
	}
	
	
	public int getIndex(){
        return this.Index;
	}
	
	public void restartIndex(){this.Index = 0;}
}