
import java.util.*;      //We use a BubbleSort function to sort the array the user inputs
public class Task1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();                         //inputting the number of elements in array
		int arr[]=new int[n];                       //initializing array
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();                   //inputting the array
		}
		System.out.print("The unsorted array is : ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");          //printing the unsorted array
		}
		System.out.println();                      //formatting the output nicely
		int sorted[]=BubbleSort(arr);              //calling the bubblesort function
		System.out.print("The sorted array is: ");
		for(int i=0;i<n;i++) {
			System.out.print(sorted[i]+" ");//printing the sorted array
		}
	}
	public static int[] BubbleSort(int arr[]){
		int n=arr.length;           //storing length of array
		for(int i=0;i<n-1;i++) {    //running the outer loop
			boolean swap=false;      //boolean swap variable to check if any swaps happen or not
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {     //check if there is need of swap
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					swap=true;       //changing the swap variable
				}
			}
			if(!swap)break;        // i.e. the array is sorted now no need to run loop
		} 
		return arr;
	}
}


         /*
          * Time complexity of Bubble Sort algorithm is--->
          * Best Case-->O(n)   (if the array is already sorted)
          * Average Case-->O(n^2)   
          * Worst case--->O(n^2)
          * 
          * Time complexity of Insertion Sort algorithm is--->
          * Best Case-->O(n)   (if array already sorted)
          * Average Case-->O(n^2)
          * Worst Case-->O(n^2)
          * 
          * Time complexity of Merge Sort algorithm is--->
          * Best Case-->O(nlogn)
          * Average Case-->O(nlogn)
          * Worst Case-->O(nlogn)
          * 
          * Time complexity of Selection Sort algorithm is--->
          * Best Case-->O(n^2)
          * Average Case-->O(n^2)
          * Worst Case-->O(n^2)
          * 
          * So we can see Bubble Sort is not the most optimal algorithm for sorting and merge sort has the most
          * optimal time complexity among these 4 options.There are other complex sorting 
          * algorithms as well(Counting Sort,Radix Sort etc) which also we can use and can give
          * linear time complexities but are far more complicated to code out.
          */
