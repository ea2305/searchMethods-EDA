/**
 * basic menu with title, and sub elements to list in output
 *@verison 1.1
 */

package menu;

public class Menu implements StructMenu{
    
    String Title;
    String [] menuContent;
    int numberOptions;
    String endMessage;
    
//Constructors

    public Menu(){
        this.Title = "";
        this.menuContent = null;
        this.numberOptions = 0;
        this.endMessage = "";
    }
    
    public Menu(String Title){
        this.Title = "";
        this.menuContent = null;
        this.numberOptions = 0;
        this.endMessage = "";
    }
    
    public Menu(String Title, String [] menuContent){
        this.Title = Title;
        this.menuContent = menuContent;
        this.numberOptions = 0;
        this.endMessage = "";
    }
    
    public Menu(String Title, String [] menuContent,int numberOptions,String endMessage){
        this.Title = Title;
        this.menuContent = menuContent;
        this.numberOptions = numberOptions;
        this.endMessage = endMessage;
    }

//Class Setter, to change content

    /**
     *@param Title : String with title of menu
     */
    public void setTitle(String Title){
        this.Title = Title;
    }

    /**
     *@param menuContent : ArrayString. Content sub elements with information of class
     */    
    public void setContent(String [] menuContent){
        this.menuContent = menuContent;
    }

    /**
     *@param numberOptions : int. Primitive variable
     */    
    public void setNumberElements(int numberOptions){
        this.numberOptions = numberOptions;
    }
    
    /**
     *@param endMessage : String end message
     */
    public void setEndMessage(String endMessage){
        this.endMessage = endMessage;
    }
    
    //Print content of title 
    public void  printTitle(){
        System.out.println("\n\t******************[ " + this.Title + " ]******************\n");
    }
    
    //Print all options in array
    public void printOptions(){
        int index = 0;
        for(String e : this.menuContent)
            System.out.println( (++index)  + ".-" + e);
    }
    
    //print end message
    public void exitMessage(){
        System.out.println("\n\t>> [ " + this.endMessage + " ]");
    }
    
    //print all elements of menu
    public void printAllMenu(){
        printTitle();
        printOptions();
    } 
}