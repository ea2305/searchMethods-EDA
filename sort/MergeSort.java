package sorts;

public class MergeSort {
	
    private int count;
    
    long time;
    
    public MergeSort(){
        count = 0;
        this.time = 0;
    }
    
    public long getTime(){
        return this.time;
    }
    
    public void mergeSort( Integer a[ ]){
        long TInicio = System.currentTimeMillis();
        Integer tmpArray[] = new Integer[ a.length ];
        
        mergeSort( a, tmpArray, 0, a.length - 1 );
        
        long TFin = System.currentTimeMillis();//END
        this.time=TFin-TInicio;
        
    }
    
    private void mergeSort( Integer a[ ], Integer tmpArray[],int left, int right ){
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            mergeSort( a, tmpArray, center + 1, right );
            merge( a, tmpArray, left, center + 1, right );
        }
    }

    private void merge( Integer a[ ],Integer tmpArray[],int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd ){
            if( a[ leftPos ]<( a[ rightPos ] ) ){
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            }
            else{
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];
            }
        }
        while( leftPos <= leftEnd ){    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        }
        while( rightPos <= rightEnd ){  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        }
        // Copy TmpArray back
        for( int i = 0; i < numElements; i++, rightEnd-- ){
            ++count;//Cambios
            a[ rightEnd ] = tmpArray[ rightEnd ];
        }
    }
    
    public int getIndex(){
        return this.count;
    }
    
    public void restartIndex(){
        this.count = 0;
    }
}