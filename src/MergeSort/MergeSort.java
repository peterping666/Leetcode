package MergeSort;

import java.util.Arrays;

public class MergeSort {
//    public static void main(String[] args) {
//        int[] arr = new int[]{7,4,2,9,5,1,0};
//        MergesortHelper mergeSort = new MergesortHelper();
//        mergeSort.sort(arr, 0, 6);
//        for (int i = 0; i < 7; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//public static void main(String[] args) {
//    int []array={80,30,60,20,10,60,50,70};
//    int []copy=new int[array.length];
//    //为数组分配一个数组空间来进行排序，排完序后还要复制给原数组
//    for(int i=0;i<array.length;i++)
//    {
//        copy[i]=array[i];
//    }
//    mergeSort(array,copy,0,array.length-1);
//    System.out.println(Arrays.toString(array));
//}
    public static void mergeSort(int []array,int []copy,int start,int end)
    {
        if(start==end)
        {
            return;
            //如果数组长度为0则直接返回
        }
        int length=(end-start)/2;
        //将数组分为左右两部分，分别对左右两部分进行排序
        mergeSort(array, copy, start, start+length);
        mergeSort(array, copy, start+length+1, end);
        int copyindex=end;
        int i=start+length;
        int j=end;
        //将左右两个排好序的数组进行排序，将结果保存到copy数组中
        while(i>=start&&j>=start+length+1)
        {
            //将左右数组由大到小复制到copy数组中
            if(array[i]>array[j])
            {
                copy[copyindex--]=array[i--];

            }
            else {
                copy[copyindex--]=array[j--];
            }
        }
        while(i>=start)
        {
            copy[copyindex--]=array[i--];
            //因为左数组中剩下的肯定比copy数组中最小的还小，如果左边的数组还有，则将其复制到copy数组中，
        }
        while (j>=start+length+1) {
            copy[copyindex--]=array[j--];
            //因为右数组中剩下的肯定比copy数组中最小的还小如果右边的数组还有，则将其复制到copy数组中
        }
        for(i=start;i<=end;i++)
        {
            array[i]=copy[i];
            //将copy数组复制到array数组中。
        }
    }



//    public static void mergeSort1(int []array,int []copy,int low,int high)
//    {
//        int len=high-low+1;
//        if(len<7)
//        {
//            for(int i=low;i<=high;i++)
//            {
//                for(int j=i;j>low&&array[j]<array[j-1];j--)
//                {
//                    swap(array, j, j-1);
//                }
//            }
//            return;
//        }
//        int mid=(low+high)>>>1;
//        mergeSort1(copy, array, low, mid);
//        //交换了copy 和array数组，这样便省去了将array数组复制给copy数组。
//        mergeSort1(copy, array, mid+1, high);
//        //如果左数组的最大值小于右数组的最小值，则数组已经排好序，直接进行复制。
//        if(copy[mid]<copy[mid+1])
//        {
//            System.arraycopy(copy, low, array, low, len);
//            return ;
//        }
//        int left=low,right=mid+1;
//        for(int i=low;i<=high;i++)
//        {
//            if(right>high||left <=mid &&copy[left]<copy[right])
//                array[i]=copy[left++];
//            else {
//                array[i]=copy[right++];
//            }
//        }
//    }
//    private static void swap(int[] x, int a, int b) {
//        int t = x[a];
//        x[a] = x[b];
//        x[b] = t;
//    }
}

//class MergesortHelper {
//
//    public void sort(int[] arr, int left, int right) {
//        if(left < right) {
//            int mid = left + (right - left) / 2;
//            sort(arr, left, mid);
//            sort(arr, mid + 1, right);
//            merge(arr, left, mid, right);
//        }
//    }
//
//    public void merge(int[] arr, int left, int mid, int right) {
//        int n1 = mid - left + 1;
//        int n2 = right - mid;
//
//        int[] l_arr = new int[n1];
//        int[] r_arr = new int[n2];
//
//        for(int i = 0; i < n1; ++i) {
//            l_arr[i] = arr[left + i];
//        }
//        for(int i = 0; i < n2; ++i) {
//            r_arr[i] = arr[mid + 1 + i];
//        }
//
//        int i = 0, j = 0;
//
//        int k = left;
//        while (i < n1 && j < n2) {
//            if(l_arr[i] <= r_arr[j]) {
//                arr[k] = l_arr[i++];
//            } else {
//                arr[k] = r_arr[j++];
//            }
//            k++;
//        }
//        while (i < n1) {
//            arr[k] = l_arr[i];
//            i++;
//            k++;
//        }
//        while ((j < n2)) {
//            arr[k] = r_arr[j];
//            k++;
//            j++;
//        }
//    }
//}






