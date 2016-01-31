package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
* Clase para la creacion de string con los datos de un archivo
* Obteniendolos con la clase "getLines" y almacenada en el string:
* BufferString, para su posterior uso.
* Creadores::
* @author Elihu Alejandro Cruz Albores
* @author Luis Fernando Herrera Pimentel
* @author Carlos Maximiliano Ortiz Escobar
* @version 1.8
*/

public class AnalizaFile{
	
	String NAME_FILE;//Atributo almacenador de nombre de archivo
	int Number_lines;//Obtine el numero de lineas del archivo,
					 // una vez llamada la funcion getLines.
	
	String BufferString;// Cadena que contiene los datos del archivo, 
							 // en un String separado por saltos de linea '\n'
                             
    String div_String;//Parametro para division de archivo

	public AnalizaFile(){//Constructor por defecto
	
		this.NAME_FILE = "";
		this.Number_lines = -7;
		this.BufferString = null;
        this.div_String = "\n"; 

	}

	public AnalizaFile(String NAME_STR){//Contructor que recibe el nombre del archivo
		
		this.Number_lines = -7;
		this.BufferString = null; 
		this.NAME_FILE = NAME_STR;
        this.div_String = "\n";

	}

	/**
     *@return Number_lines : int , con valor de numero de lineas
     */
	public int getLines()throws IOException{//Realiza la lectura de el archivo y obtiene el numer de lineas 
						  //Separados por \n , es llamado para obtener los datos.            
        						  
		if(Number_lines < 0){//Evitar lectura innecesaria						  	
			OpenFile();//Aperturamos el archivo para la carga de datos
        }
        //Contamos divisiones
        Number_lines = BufferString.split(div_String).length;       
			
		return Number_lines ;
	}

	/**
	*@return Cadena de caracters de la primer linea
	*/
	public String getFirstLine()throws IOException{//Obtiene la primer linea de un archivo
		
		if(Number_lines < 0)
            getLines();
	
		String DateToSend [] = BufferString.split("\n");

		return DateToSend[0];
	}
	
	/**
	*@param Ningun valor
	*@return Cadena de caracters de la ultima linea
	*/
	public String getLastLine()throws IOException{//Obtiene la ultima linea de un archivo

		if(Number_lines < 0)
			getLines();

		String DateToSend [] = BufferString.split("\n");

		return DateToSend[Number_lines-1];
	}

	/**
	*@param Cadena de caracteres que contiene el nombre del archivo
	*/
	public void setFileName(String nFile){//Contructor que recibe el nombre del archivo
		this.NAME_FILE = nFile;//Agregamos nuevo nombre.
		this.Number_lines = -7;//Reiniciamos lecutra.
		this.BufferString = "";
	}
	
	/**
	* @param Dato entero indicando posicion
	* @return String con datos 
	*/
	public String getAnyLine(int N)throws IOException{//Obtiene la primer linea de un archivo

		if(Number_lines < 0)
			getLines();
        
        if(N > Number_lines){
            System.out.println("El elemento que busca no existe, o excede le numero de elementos.");
            return "";
        }    
	
		String BUfferAsunder [] = BufferString.split("\n");

		return BUfferAsunder[N];
        
	}
    
    public String getAllFile() throws IOException{
        
        if(Number_lines < 0)
            getLines();
           
        return BufferString;
    }

	public void writeFile(String outFile,String put){
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter(outFile);
			pw = new PrintWriter(fichero);
			
				pw.println(put);
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			// Nuevamente aprovechamos el finally para 
			// asegurarnos que se cierra el fichero.
			if (null != fichero)
				fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
    
    /**
     *Metodo para la apertura de archivos
     */    
    private void OpenFile(){//Nuevo metodo de lectura evadiendo el lisado linea por linea
        
         try{
             String content = new String(Files.readAllBytes(Paths.get(NAME_FILE)));
             BufferString = content;//Reasignacion por seguridad
         }catch(IOException e){
            System.out.println("Error: archivo [" + this.NAME_FILE + "] no encontrado");
            BufferString = null; 
         }
        
    }
    
    /**
     *@param div_String : String con parametro para division de cadenas
     */
    public void setDivition(String div_String){
        this.div_String = div_String;
    }
    
         //Read file
     public String[] loadFile(){
         
           //instance of file reader => 
        Scanner read_file = new Scanner(System.in);
                
        //Declareation with name inside
        System.out.println("==============>[ LECTURA DE ARCHIVO PARA ORDENAMIENTO]<==============\n");
        System.out.println("===========[ INTRODUZCA EL NOMBRE DEL ARCHIVO]=============");
        System.out.print("Seleccion : ");
        setFileName(read_file.nextLine());//Lectura de datos y asignacion de datos.
        System.out.println();
         
        //Create fileReader             
        //AnalizaFile fileReader = new AnalizaFile(nameFile);
        //System.out.println(nameFile);
        System.out.println("Buscar en ::> " + this.NAME_FILE);
        
        try{
            getAllFile();
        }catch(IOException e){
            
        }
        
        if(BufferString == null || BufferString.equals("")){
            
            System.out.println("X =======> Error verifique el nombre he intente de nuevo\n");
            return null;
        }
                   
        System.out.println("==============> LOS DATOS SE HAN CARGADO CORRECTAMENTE !");
            
         return BufferString.split(div_String);
     }
     
     public Integer[] parseInformation(String[] Element){
         
         Integer [] Temp = new Integer[Element.length];
         Integer index = 0;
         for(String element : Element)
             Temp[index] = Integer.parseInt(Element[index++]);
         
         return Temp;
     } 
    
}

