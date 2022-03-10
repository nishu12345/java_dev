package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
*   Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
*   If not, return the index where it would be if it were inserted in order.
*   Input  -> [1,3,8,10,15]   elementToSearch  -> 16
*   Output -> 5
*   Explanation -> 16 should be inserted after 15 i.e. on 5th index.
* */
public class SortedInsertPosition {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortedInsertPosition.class);

    public static void main(String[] args) {
        int[] input = {1,3,8,10,15};
        int elementToInsert = 16;
        int insertPosition = getInsertPosition(input, elementToInsert);
        LOGGER.info("Position at which element should be inserted in given input is {}",insertPosition);
    }

    public static int getInsertPosition(int[] input, int elementToInsert){
        int start = 0, mid, end = input.length-1;
        while(start<=end){
            mid = start + ((end-start)/2);
            if(input[mid]==elementToInsert || (mid==0 && input[0]>elementToInsert) || (mid!=0 && (input[mid-1]<elementToInsert && input[mid]>elementToInsert)))
                return mid;
            else if(mid == input.length-1 && input[mid]<elementToInsert)
                return input.length;
            else if(input[mid] > elementToInsert)
                end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
