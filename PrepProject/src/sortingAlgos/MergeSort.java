package sortingAlgos;

public class MergeSort extends Basic_Functionality{
	
	 private int[] array;
	    private int[] tempMergArr;
	
	public static void main(String[] args)
	{
		MergeSort obj = new MergeSort();
		obj.assignValuesToArray();
		obj.displayArray();
		obj.doMergeSort();
		obj.displayArray();
	}
	
	private void doMergeSort()
	{
		int low = 0;
		array = intAray;
		this.tempMergArr = new int[intAray.length];
		do_Merge_Sort(low, intAray.length-1);
		intAray = array;
	}
	
	private void do_Merge_Sort(int low, int high)
	{
		System.out.println("Low: "+low+" High: "+high);
		if(low<high)
		{
			int mid = low+(high-low)/2;
			do_Merge_Sort(low, mid);
			do_Merge_Sort(mid+1, high);
			perform_Merge(low, mid, high);
		}
	}
	
	private void perform_Merge(int low, int mid, int high)
	{
		System.out.println("Low: "+low+" Mid: "+mid+" High: "+high);
		
		for (int i = low; i <= high; i++) {
            tempMergArr[i] = array[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }
}
