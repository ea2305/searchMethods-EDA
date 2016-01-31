/**
 * Some sentences to handle menu system and calls about methods 
 *@author Elihu Alejandro Cruz Albores
 *@author Carlos Maximiliano Ortiz Escobar
 *@author Luis Angel Farelo Toledo
 *@author Julio de Buen Hernandez
 *@author Luis Alcocer
 *@version 1.2
 */

import java.util.Scanner;
import menu.*;
import sorts.*;
import search.*;
import util.*;

class Vista{

    String [] string_data;
    Integer data_Search [];
    Integer data_Sort [];
    
    Integer target;   
    private boolean SEARCH_OPTION;
    private boolean stateSort;
    
    //default constructor
    public Vista(){
        target = 0;   
        boolean SEARCH_OPTION = false;
        stateSort = false;
    }
    
    //menu of system search
    public void startSearchMenu(){//Print all content of menu search
        
        String kindSearch [] = {"Ordenar Elementos","Buscar","Imprimir arreglo","Salir =>"};

        Menu searchMenu = new Menu("BUSQUEDA ELEMENTOS", kindSearch);//Callback
        menuReader(searchMenu,false);
    }

    //Callback to secuential search    
    public  void secuentialSearch(){//Setting
     
        if(string_data == null){//Return if the file doesn't be loaded
            System.out.println("*xxxxxxxxxx[ NO SE HAN CARGADO DATOS :C ]xxxxxxxxxx*");
            return;
        }
        SEARCH_OPTION = true;
        startSearchMenu();
    }
    
    //Callback to binary search
    public  void binarySearch(){
        
        if(string_data == null){//Return if the file doesn't be loaded
            System.out.println("*xxxxxxxxxx[ NO SE HAN CARGADO DATOS :C ]xxxxxxxxxx*");
            return;
        }
        
        SEARCH_OPTION = false;
        startSearchMenu();
    }

    //call methods    
    public  void callSecuential(){
        
        this.target = targetSearch();
        Integer [] selection_Target = (stateSort) ? data_Sort : data_Search;

        Secuencial mySearch = new Secuencial();
        System.out.println(">>>Busqueda con algoritmo no optimizado"); 
        printFormatTest(mySearch.simpleSearch(selection_Target,this.target),mySearch.getCount() );

        
        //Search with method more complex and reduction of iterations
        System.out.println(">>>Busqueda con algoritmo optimizado");
        if(isOrdenate(selection_Target)){
            System.out.println("ARREGLO ORDENADO =>"); 
            printFormatTest(mySearch.complexSearch(selection_Target,this.target),mySearch.getCount());
        }else{
            System.out.println("ARRELGO DESORDENADO =x se necesita que el arreglo este metodo de busqueda");
        }
    }
    
    public boolean isOrdenate(Integer A []){
        
        int size = A.length - 1;
        
        for(int i = 0 ; i < size; i++){
            if(A[i] > A[i + 1])
                return false;
        }
        return true;
    }
    
    public void printFormatTest(int ok,int comparaciones){
        System.out.println("\n\t*************[ RESULTADOS ]****************");
        System.out.println("\n\tComparaciones : " + comparaciones);
        if(ok >= 0)
            System.out.println("\tDato encontrado en la posicion : " + ok + "\n");
        else
            System.out.println("\tDato no localizado\n");
        System.out.println("\n\t*************[ FIN - RESULTADOS ]****************\n");            
    }
    
    public Integer[] copyArray(Integer [] A){
        Integer [] temp = new Integer[A.length];
        for(int i = 0; i < A.length ; i++){
            temp[i] = A[i];
        }
        return temp;
    }
    
    public  void callBinary(){//Call binary search method

        this.target = targetSearch();
        Integer [] selection_Target = (stateSort) ? data_Sort : data_Search;
        
        Binary myBinary = new Binary();

        if(isOrdenate(selection_Target)){
            System.out.println(">>>Busqueda con algoritmo no optimizado"); 
            //Incresed count 'cause select the position in array.
            
            printFormatTest(myBinary.simpleSearch(selection_Target,this.target) + 1,myBinary.getCount() );            
        }else
            System.out.println("ARRELGO DESORDENADO =x se necesita que el arreglo este metodo de busqueda");
        
    }
    
        //Flow selector
     protected  int switcherMenu(int option){

        switch(option){
            case 1: 
                //load file external directory
                AnalizaFile myReader = new AnalizaFile();
                string_data = myReader.loadFile();
                data_Search = myReader.parseInformation(string_data);//Transform string to integer
                return option;
            case 2:
                secuentialSearch();
                return option;
            case 3:
                binarySearch();
                return option;
            default:
                return -1;
        }
     }
     
     protected  int switcherSort(int option){

        switch(option){
            case 1:      
                if(data_Search.length > 10000){//Select optimal option
                    
                    MergeSort myMerge = new MergeSort();
                    this.data_Sort = copyArray(data_Search);//Move data to sorter array. save information
                    myMerge.mergeSort(data_Sort);
                    stateSort = true;
                    
                }else{//Select optimal option
                    
                    Seleccion mySelection = new Seleccion();
                    this.data_Sort = copyArray(data_Search);
                    mySelection.seleccion(data_Sort);//Send array with copied information
                    stateSort = true;
                }
                    
                return option;
                
            case 2:
                if(SEARCH_OPTION)
                    callSecuential();
                else
                    callBinary();
                        
                return option;
                
            case 3:
                Integer [] selection_Target = (stateSort) ? data_Sort : data_Search; 
                printArray(selection_Target);
                return option;
                    
            default:
                return -1;
        }
     }
     
     //Setting menu
     public  void menuReader(Menu myMenu, boolean flow){
         
        Scanner read = new Scanner(System.in);//Object to read
        int option = 0;//exit condition variable
         
        while(option != -1){//Waiting for defalut case
            myMenu.printAllMenu();//Menu content
            
            try{
                System.out.println("\nSeleciona una opcion");
                if(flow)
                    option = switcherMenu(read.nextInt());
                else
                    option = switcherSort(read.nextInt());

            }catch(Exception e){
                //Restart read for caractrers because chars are corrupted
                System.out.println("Importante! => Introduzca solo numeros.");
                read = new Scanner(System.in);
            }
        }  
     }
     
    //Print content of array has gotten
    public  void printArray(Integer A[]){
        int index = 1;
        for(Integer e : A)
            System.out.println( (index++) + " : [ " + e + " ]");
    }
    
    public Integer targetSearch(){
        Integer A = -1;//Error posibility
        
        Scanner myReader =new Scanner(System.in);
        try{
            System.out.println("Ingrese un numero: ");
            A = myReader.nextInt();
        }catch(Exception e){
            A = targetSearch();
        }
        return A;
    }
    
    //Call all system, with menu and reader function
    public void start(){
                
        //Contents
        String [] items = {"Cargar Archivo externo","Busqueda secuencial o lineal","Busqueda Binaria","Salir =>"};
        
        //Initialize object
        Menu myMenu = new Menu("METODOS DE BUSQUEDA",items);
        menuReader(myMenu,true);
        //Read option
 
    }    
}