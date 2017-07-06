package code.topcoder;

public class EllysBottles {
  
  
  static int getMax(double[] nums) {
    int re = 0;
    
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] > nums[re]) {
        re = i;
      }
    }
    return re;
  }
  
  static int getMin(double[] nums) {
    int re = 0;
    
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] < nums[re]) {
        re = i;
      }
    }
    return re;
  }
  
  public static double getVolume(int[] bottles, int k) {
    double[] nums = new double[bottles.length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = bottles[i];
    }
    
    
    for (int i = 0; i < k; i++) {
      int max = getMax(nums);
      int min = getMin(nums);
      double mid = (nums[max] + nums[min]) / 2;
      nums[max] = mid;
      nums[min] = mid;
      
    }
    return nums[getMin(nums)];
    

    
  }
  
  
  
  
  public static void main(String[] args) {
    System.out.print(getVolume(new int[]{937831252, 223252363, 706118333, 954711869, 819583497, 520873195, 879422756, 464831418,
        156067240, 646868794, 894534170, 23380905, 855234472, 319560027, 305097549, 374217481,
        86837363, 718892301, 952809474, 558293585, 91833518, 862607400, 982038771, 942620013,
        507984782, 546527456, 615697673, 237645185, 53645793, 780959476, 136257699, 969658933,
        959150775, 43875123, 9012, 349823412, 85123543, 349085123, 194357213, 229834565}, 1234567));
  }

}


/**
 * 
 * 
 * 
 * 
Problem Statement
    
There are a few minutes left before the start of a SRM. While waiting, Elly entertains herself in the following way: In front of her she has several bottles of the same capacity, containing various amount of water. She finds two bottles: one that contains the largest amount of water and one that contains the smallest amount of water. She then pours water from the first bottle she found into the second bottle she found until they both contain the same amount of water. After that she again looks at all the bottles, finding the most filled one and the least filled one and does this procedure again. Elly performs the above procedure exactly k times. Then the SRM starts and she switches to solving problems instead.  The initial amount of liquid in each of the bottles is provided to you in the int[] bottles. Can you calculate what is the amount of water in the least filled bottle, after executing the described procedure k times?
Definition
    
Class:
EllysBottles
Method:
getVolume
Parameters:
int[], int
Returns:
double
Method signature:
double getVolume(int[] bottles, int k)
(be sure your method is public)
Limits
    
Time limit (s):
2.000
Memory limit (MB):
256
Notes
-
Your return value must have an absolute or a relative error smaller than 1e-9.
-
If there are multiple choices for the most-filled or least-filled bottles, Elly chooses any of them. This does not influence the final answer.
Constraints
-
k will be between 1 and 1,000,000,000, inclusive.
-
bottles will contain between 2 and 50 elements, inclusive.
-
Each element in bottles will be between 0 and 1,000,000,000, inclusive.
Examples
0)

    
{42, 13, 17, 7, 22}
8
Returns: 20.0625
Elly has five bottles, initially filled with 42, 13, 17, 7, and 22 units of water. She does her procedure eight times.
She pours from a bottle containing 42 into a bottle containing 7 units of water, making the amount of water in the bottles {24.5, 13, 17, 24.5, 22}
She pours from a bottle containing 24.5 into a bottle containing 13 units of water, making the amount of water in the bottles {18.75, 18.75, 17, 24.5, 22}
She pours from a bottle containing 24.5 into a bottle containing 17 units of water, making the amount of water in the bottles {18.75, 18.75, 20.75, 20.75, 22}
She pours from a bottle containing 22 into a bottle containing 18.75 units of water, making the amount of water in the bottles {20.375, 18.75, 20.75, 20.75, 20.375}
She pours from a bottle containing 20.75 into a bottle containing 18.75 units of water, making the amount of water in the bottles {20.375, 19.75, 19.75, 20.75, 20.375}
She pours from a bottle containing 20.75 into a bottle containing 19.75 units of water, making the amount of water in the bottles {20.375, 20.25, 19.75, 20.25, 20.375}
She pours from a bottle containing 20.375 into a bottle containing 19.75 units of water, making the amount of water in the bottles {20.0625, 20.25, 20.0625, 20.25, 20.375}
She pours from a bottle containing 20.375 into a bottle containing 20.0625 units of water, making the amount of water in the bottles {20.21875, 20.25, 20.0625, 20.25, 20.21875}
The lowest amount of water in any of the bottles after the transactions is 20.0625.
1)

    
{42, 42, 42}
42
Returns: 42.0
In each of the 42 operations Elly chooses two bottles with 42 units of water and basically does nothing.
2)

    
{1111111, 2222222, 3333333, 4444444, 5555555, 6666666, 7777777, 8888888, 9999999}
4
Returns: 5555555.0
After the last operation all bottles end up containing the same amount of water: 5555555.
3)

    
{937831252, 223252363, 706118333, 954711869, 819583497, 520873195, 879422756, 464831418,
 156067240, 646868794, 894534170, 23380905, 855234472, 319560027, 305097549, 374217481,
 86837363, 718892301, 952809474, 558293585, 91833518, 862607400, 982038771, 942620013,
 507984782, 546527456, 615697673, 237645185, 53645793, 780959476, 136257699, 969658933,
 959150775, 43875123, 9012, 349823412, 85123543, 349085123, 194357213, 229834565}
1234567
Returns: 5.08428837725E8

4)

    
{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
1000000000
Returns: 0.5

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.
 * 
 * */

