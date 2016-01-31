package search;

public class Binary{
    
    int Count;
    
    public Binary(){
        this.Count = 0;
    }
    
    public int simpleSearch(Integer [] A,Integer target){
        
        this.Count = 0;//Restart values
        
        //initialize values
        int left = 0, right = A.length - 1, center = 0;//Asign some utils variables
        boolean bandera = false;//System flag
        
        while((left <= right) && (!bandera)){//Start loop
            
            this.Count++;//increment count for iterations
            
            center = getIntegerPart(left, right );
            
            if(target.equals(A[center])){//Veficate the center value
                bandera = true;
            }else{
                if( target.compareTo(A[center]) > 0 )
                    left = center + 1;
                else
                    right = center - 1;
            }
        }
        
        if(bandera)
            return center;
        else
            return -1;        

    }
    
    public int comactSearch(Integer [] A,Integer target){
        
        this.Count = 0;//Restart values
        
        //initialize values
        int right = 1, left = A.length, center = 0;//Asign some utils variables
        
        while(left <= right){//Start loop
            
            this.Count++;
            
            center = getIntegerPart(left, right);//Move center
            
            if(target.equals(A[center]))//Vefication the center value
                return center;
            else
                if( target.compareTo(A[center]) > 0 )
                    left = center + 1;
                else
                    right = center - 1;
        }
        
        return -1;        

    }
    
    public Integer getIntegerPart(Integer A, Integer B){
        System.out.println((A + B)/2);
        return (A + B)/2;//Get integer part parsing data
    }
    
    public int getCount(){
        return this.Count;
    }
    
}