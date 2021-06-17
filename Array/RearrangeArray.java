//Link : https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/

class RearrangeArray{
	 // Driver Code
    public static void main(String[] args)
    {
        RearrangeArray rearrange = new RearrangeArray();
        /* int arr[n] = {-5, 3, 4, 5, -6,
                         -2, 8, 9, -1, -4};
        int arr[] = {-5, -3, -4, -5, -6,
                     2 , 8, 9, 1 , 4};
        int arr[] = {5, 3, 4, 2, 1,
                     -2 , -8, -9, -1 , -4};
        int arr[] = {-5, 3, -4, -7,
                     -1, -2 , -8, -9, 1 , -4};*/
        int arr[] = { -5, -2, 5, 2, 4,
                     7, 1, 8, 0, -8 };
        int n = arr.length;
 
        System.out.println("Given array is ");
        rearrange.printArray(arr, n);
 
        rearrange.rearrange(arr, n);
 
        System.out.println("Rearranged array is ");
        rearrange.printArray(arr, n);
    }
	// A utility function to print
    // an array 'arr[]' of size 'n'
    void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
	
	private void rearrange(int[] arr, int n){
		int countPositive = 0;
		int countNegative = 0;
		
		//calculate count of positves and negatives
		 for(int i=0;i<n;i++){
			 if(arr[i] >= 0)
				 countPositive++;
			 else
				 countNegative++;
		 }
		int[] positive = new int[countPositive];
		int[] negative = new int[countNegative];
		
		int j=0,k=0;
		//add positives in positive array and negatives in negative array
		for(int i=0;i<n;i++){
			
			if(arr[i] >= 0){
				positive[j] = arr[i];
				j++;
			}
			else{
				negative[k] = arr[i];
				k++;
			}
		}
			
		//add positive and negative values alternatively in arr
		int rem_pos =0, rem_neg=0;
		if(countPositive >= countNegative)
					rem_pos = countPositive - countNegative;
		else
			rem_neg = countNegative - countPositive;
				
		int p=0, neg =0;
		for(int i=0;i<n;i++){
			
			if(i %2 == 0 && p<countPositive){
				arr[i] = positive[p];
				p++;
			}
			else if((i%2) != 0 && n<negative.length){
				arr[i] = negative[neg];
				neg++;
			}
			
			else{
				 if(rem_pos > rem_neg && p<positive.length){
					 arr[i] = positive[p];
					 p++;
				 }
				 else{
					 arr[i] = negative[neg];
					 neg++;
				 }
					 
					 
			}
		}	
	}
}