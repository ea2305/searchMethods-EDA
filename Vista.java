import java.util.Scanner;
import menu.*;
import sort.*;
import search.*;

class Vista{

    public  Integer data_Search [] = {1,2,4,5,1,5,5,1,5,31,5,123,513,5,13,51,3,51,35,1,35,13,5,135}; 
    public  Integer target = 10;   
    private  boolean SEARCH_OPTION = false;
    
    
    public void startSearchMenu(){//Print all content of menu search
        
        String kindSearch [] = {"Ordenar Elementos","Buscar","Imprimir arreglo","Salir =>"};

        Menu searchMenu = new Menu("ORDEN DE ELEMENTOS", kindSearch);//Callback
        menuReader(searchMenu,false);
    }
    
    public  void secuentialSearch(){//Setting 
        SEARCH_OPTION = true;
        startSearchMenu();
    }
    
    public  void binarySearch(){
        SEARCH_OPTION = false;
        startSearchMenu();
    }
    
    public  void callSecuential(){
        int ok = 0;

        Secuencial mySearch = new Secuencial();
        System.out.println(">>>Busqueda con algoritmo no optimizado");
        ok = mySearch.simpleSearch(data_Search,target);
        if(ok >= 0)
            System.out.println("Dato encontrado en la posicion : " + ok);
        else
            System.out.println("Dato no localizado");
        
        //Search with method more complex and reduction of iterations
        System.out.println(">>>Busqueda con algoritmo optimizado");
        ok = mySearch.complexSearch(data_Search,target);
        
        if(ok >= 0)
            System.out.println("Dato encontrado en la posicion : " + ok);
        else
            System.out.println("Dato no localizado");
        
    }
    
    public  void callBinary(){
        
        //none
        
    }
    
        //Flow selector
     protected  int switcherMenu(int option){

        switch(option){
            case 1:
                secuentialSearch();
                return option;
            case 2:
                binarySearch();
                return option;
            default:
                return -1;
        }
     }
     
     protected  int switcherSort(int option){

        switch(option){
            case 1:      
                if(data_Search.length > 10000){
                    
                    MergeSort myMerge = new MergeSort();
                    myMerge.mergeSort(data_Search);
                    
                }else{
                    
                    Seleccion mySelection = new Seleccion();
                    mySelection.seleccion(data_Search);
                }
                    
                return option;
                
            case 2:
                if(SEARCH_OPTION){
                    callSecuential();
                }else{
                    callBinary();    
                }
                return option;
                
            case 3:
                printArray(data_Search);
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
        for(Integer e : A)
            System.out.println("[ " + e + " ]");
    }
    
    //Call all system, with menu and reader function
    public void start(){
                
        //Contents
        String [] items = {"Busqueda secuencial o lineal","Busqueda Binaria","Salir =>"};
        
        //Initialize object
        Menu myMenu = new Menu("METODOS DE BUSQUEDA",items);
        menuReader(myMenu,true);
        //Read option
 
    }    
}