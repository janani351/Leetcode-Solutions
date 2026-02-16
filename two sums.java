// Source - https://stackoverflow.com/q/26173073
// Posted by Alexander, modified by community. See post 'Timeline' for change history
// Retrieved 2026-02-16, License - CC BY-SA 4.0

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
            int len = numbers.length;

        int[] result = new int[2] ;
        int number1 = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            number1 = numbers[i];

            for(int j = i+1; j < len; j++)
            {

                sum = number1+numbers[j];       
                if(sum == target)
                {
                    result[0]=i;
                    result[1]=j;
                }
            }
        
        }
        return result;
    }
}
