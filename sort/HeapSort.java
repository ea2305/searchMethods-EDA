package sorts;

/*
*Metodos de ordenamiento con clases genericas
*@author Elihu Alejandro Cruz Albores
*@verison 1.2
*/

public class HeapSort{
        
    int Index;
    long time;
       
    public HeapSort(){
        this.time = 0;
        this.Index = 0;
    }
    
    public long getTime(){
        return this.time;
    }
 
    /*
    *Ordenacion por monticulos - HeapSort
    *@param Recive como parametros Arraylist<T> : con elementos a ordenar
    *@return Arraylist con datos ordenados
    */
    public void heapSort(Integer[] v) {
        
        long TInicio = System.currentTimeMillis();//CAll time
        final int N = v.length;
        
        
        for(int nodo = N/2; nodo>=0; nodo--) 
            makeHeap(v, nodo, N-1);
            
        for(int nodo = N-1; nodo>=0; nodo--) {    
            Integer tmp = v[0];
            v[0]    = v[nodo];
            v[nodo] = tmp;
            makeHeap(v, 0, nodo-1);
        }
        
        long TFin = System.currentTimeMillis();//end
        this.time=TFin-TInicio;
    }
 
 
     /*
    *Creacion de monticulos para ordenamiento de HeapSort
    *@param Recive como parametros Arraylist<T> : con elementos a ordenar
    *@param Integer : nodo : indica posicion del nodo actual
    *@param Integer : fin : define limite de busqueda le monticulo
    *@return Arraylist con datos del monticulo
    */
    public void makeHeap(Integer[] v, int nodo, int fin) {
        
        int izq = 2*nodo+1;
        int der = izq+1;
        int may;
        Index++;//Contador
        if(izq>fin) return;
        
        if(der>fin) may=izq;
        else may= v[izq]>v[der]?izq:der;
        
        if(v[nodo] < v[may]) {
            Integer tmp = v[nodo];
            v[nodo] = v[may];
            v[may]  = tmp;
            makeHeap(v, may, fin);
        }
    }
    
    /*
    *@return Integer : Index : contador de iteraciones de la ordenacion
    */
	public int getIndex(){
		return this.Index;
	}

    /*
    *   Reinicia el contador de la clase para poder realizar otra ordenacion
    *   posterior.
    */
    public void restartIndex(){this.Index = 0;}
}
