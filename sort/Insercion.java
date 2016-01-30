package sorts;

import java.util.*;

public class Insercion {

    long time;
    int contador;

    public Insercion(){
        this.time = 0;
        this.contador = 0;
    }

    public long getTime(){
        return this.time;
    }

  //  static final int DATOS = 100000;
    public Integer[] ordenarInsercion(Integer[] array){
        Integer aux;

        long TInicio = System.currentTimeMillis();//CAll

        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            for (int j = i-1; j >=0; j--) {
              if(array[j]<=aux){
                j=-1;
                contador++;
              }else {
                array[j+1]=array[j];
                array[j]=aux;
                contador++;
              }
            }
        }

        long TFin = System.currentTimeMillis();
        this.time=TFin-TInicio;

        return array;
    }

    public int getCount(){
        return contador;
    }
}
