package algorithm.sort;

/**
 * 		位图排序
 * 编程珠玑第一章
 * 使用：海量数据，每个元素只出现一次。
 * 1000万个数
 * @author Paine
 *
 */
public class bitSort {
	
	private static int[] a=new int[10000000/32+1];

	/*
	 * 设置位数组中的从0开始的第i位为1
	 * i>>5，即i/32,因为一个int是32位，表示i在数组中第几个int中
	 * 1<<(i&0x1F) i&0x1F取低5位，即对32取余。表示在这个数的第几位
	 */
	private static void set(int i){
		a[i>>5]|=(1<<(i&0x1F));
	}
	
	private static int get(int i){	
		return a[i>>5]&(1<<(i&0x1F));
	}
	
	private static void clear(int i){
		a[i>>5]&=~(1<<(i&0x1F));
	}
	
	private static void sort(int[] nums){
		for(int num: nums){
			set(num);
		}
		for(int i=0; i<10000000; i++){
			if(get(i)!=0){
				System.out.println(i);
			}
			clear(i);
		}		
	}
	
	public static void main(String[] args) {
		int[] nums={1,4,1,32,2,6,4,2,69,9,4,185,2};
		sort(nums);			
		
		
		
		TwoBitMap map=new TwoBitMap();
		for(int num: nums){
			map.add(num);
		}		
		System.out.print("出现一次的数字：");
		for(int i=0; i<160000; i++){
			if(map.get(i)==1){
				System.out.print(i+" ");
			}
		}
		
	}
}

/*
 * 2位图
 * bitmap的升级版，用两个位来存储，00表示没出现，01表示出现一次，10表示出现多次，11无意义，总之可以表示4中状态
 * 因为每个数要两位表示，所以一个int最多只能表示16个数了。
 * 可以用于海量数据中找出只出现一次的数
 */
class TwoBitMap{

	int numSize=160000;//假设数据有16万
	public int[] a2Map=new int[numSize/16+1];//
	
	
	/*
	 * 给指定的数字num设置出现的次数
	 * x的范围是0-3
	 */
	private void set(int num, int x){
		int m=num>>4;//
		int n=num%16;//
		//先清零
		a2Map[m]&=~(3<<(n*2));
		//在设置指定的值
		a2Map[m]|=((3&x)<<(n*2));
	}
	
	/*
	 * 获取指定数字出现的次数
	 */
	public int get(int num){
		int m=num>>4;
		int n=num%16;
		return (a2Map[m]&(3<<(n*2)))>>(n*2);
	}
	
	/*
	 * 向bitMap中添加数
	 * 如果已经出现的次数小于3，即00 01 10，则将次数加1
	 * 如果次数已经为3，则不再变化
	 */
	public void add(int num){
		int x=get(num);
		if(x<3){
			set(num, x+1);
		}
	}
}