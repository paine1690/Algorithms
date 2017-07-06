package algorithm.String_Array;

import java.util.Arrays;

/**
 * 最长不重复子串
 * 
 * leetcode:3. Longest Substring Without Repeating Characters
 * 利用一个数组保存字幕上次出现的位置
 * 
 * @author Paine
 *
 */
public class LongestSubstringWithoutrepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		int[] index=new int[128];
		int re=0;
		for(int i=0, j=0; j<s.length(); j++){
			i=Math.max(i, index[s.charAt(j)]);
			re=Math.max(re, j-i+1);
			index[s.charAt(j)]=j+1;
		}
		return re;
	}
	public static int lengthOfLongestSubstring2(String s) {
		int[] pos=new int[128];//考虑了所有的ascii字符，一共2^7即128个
		Arrays.fill(pos, Integer.MAX_VALUE);
		int start=0, count=0, re=0;
		for(int i=0; i<s.length(); i++){

			int chari=s.charAt(i);//从31个开始第一个是空格，所以减去空格来计算字符在数组中的位置
			if(i>=pos[chari]){
				for(int j=start; j<pos[chari]; j++){
					pos[s.charAt(j)]=Integer.MAX_VALUE;
					count--;
				}
				start=pos[chari]+1;
				pos[chari]=i;
			}else{
				pos[chari]=i;
				count++;
				re=Math.max(re, count);
			}
		}
		return re;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));

	}

}
