package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
* Return index of given element in a rotated array. If not found return -1
* Input->   [18,21,25,10,12,15]
*           elementToFind = 10
* Output->  3
* Explanation-> 10 is placed at 3rd Index in given array.
* */
public class BinarySearchOnRotatedArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearchOnRotatedArray.class);

    public static void main(String[] args) {
        int[] input = {18,21,25,10,12,15};
//        int[] input = {1,2,3,4,5,6,7,0};
        int elementToFind = 10;
        int partitionIndex = getPartitionIndex(input);
        int searchedElementIndex = getSearchedElementIndex(input, 0, partitionIndex, elementToFind);
        if(searchedElementIndex==-1)
            searchedElementIndex= getSearchedElementIndex(input,partitionIndex+1,input.length-1,elementToFind);
        LOGGER.info("Index of element {} in given input array is {} ",elementToFind,searchedElementIndex);

    }

    public static int getPartitionIndex(int[] input){
        int start = 0,mid = -1, end = input.length-1;
        while(start<=end){
            mid = start + ((end-start)/2);
            if(mid!=input.length-1 && input[mid]>input[mid+1])
                return mid;
            else if(input[mid]>input[start])
                start = mid+1;
            else end = mid-1;
        }
     return mid;
    }

    public static int getSearchedElementIndex(int[] input, int startIndex, int endIndex, int elementToSearch){
        int mid = -1;
        while(startIndex<=endIndex){
            mid = startIndex+((endIndex-startIndex)/2);
            if(input[mid] == elementToSearch)
                return mid;
            else if(input[mid] > elementToSearch)
                endIndex = mid-1;
            else startIndex = mid+1;
        }
        return -1;
    }
}
