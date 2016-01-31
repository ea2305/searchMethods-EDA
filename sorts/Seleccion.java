package sorts;

public class Seleccion{


	private int index = 0;
    long time;

    public Seleccion(){
        this.time = 0;
    }

    public long getTime(){
        return this.time;
    }

	public int getIndex(){
		return this.index;
	}

    public Integer[] seleccion(Integer[] arreglo){
        
        long TInicio = System.currentTimeMillis();
        //TIMER
        Integer minimo;

        Integer aux=0;
        int n=0,intercambios=0;
        for(int i = 0; i<arreglo.length; i++){
            minimo = i;
            for(int j=i+1; j<arreglo.length; j++){
                if (arreglo[j]<arreglo[minimo]) {
                    minimo = j;
                }
                n++;
            }

            aux = arreglo[i];
            arreglo[i] = arreglo[minimo];
            arreglo[minimo] = aux;
            intercambios++;
        }

        long TFin = System.currentTimeMillis();

        this.time=TFin-TInicio;

        //System.out.println("Numero de iteraciones: "+n);
        //System.out.println("\n>> [ Numero de intercambios : " + intercambios + " ]");
        this.index = n;
        //System.out.println("El tiempo que el programa demoro en ordenar fue de : " + time + " milisegundos");
        return arreglo;
    }
}
