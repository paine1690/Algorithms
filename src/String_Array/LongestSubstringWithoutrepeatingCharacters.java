package String_Array;

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

	public int lengthOfLongestSubstring(String s) {
		int[] pos=new int[128-32];//考虑了所有的ascii字符，一共2^7即128个,前面32是控制符，可以不用考虑
		for(int i=0; i<pos.length; i++){
			pos[i]=Integer.MAX_VALUE;
		}
		
		int start=0;
		int count=0;
		int re=0;
		for(int i=0; i<s.length(); i++){
			char c=s.charAt(i);
			int position=c-' ';//从31个开始第一个是空格，所以减去空格来计算字符在数组中的位置
			if(i>pos[position]){//出现过
				for(int j=start; j<pos [position]; j++){
					pos[s.charAt(j)-' ']=Integer.MAX_VALUE;
					count--;
				}
				start=pos[position]+1;
				pos[position]=i;
			}else{//没出现过
				pos[position]=i;
				count++;
				re=Math.max(re, count);
			}
		}
		return re;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
