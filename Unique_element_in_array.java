/*Given an integer array of size 2N + 1. 
In this given array, N numbers are present twice and one number is present only once in the array.*/

public class FindUnique{	

	public static int findUnique(int[] arr){
        int count;
        for(int i = 0 ; i < arr.length ; i++){
            count = 0;
            for(int j = 0 ; j < arr.length; j++){
                if(i!=j){
                    if(arr[i] == arr[j]){
                        count ++ ;
                    }
                }
                
            }
            if(count==0){
                return arr[i];
            }
            
            
        }
        return 0;

	}
}
