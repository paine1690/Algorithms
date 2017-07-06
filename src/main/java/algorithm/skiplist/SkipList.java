package algorithm.skiplist;

import java.util.Random;


/*
 * 跳表 SkipList
 * 参考地址：http://www.tuicool.com/articles/q6FvquE
 * 
 */
public class SkipList {

	SkipListEntry head, tail;//顶层的第一个元素和最后一个元素
	
	int n;
	int h;
	Random r;
	
	public SkipList(){
		head=new SkipListEntry(Integer.MIN_VALUE, 0);
		tail=new SkipListEntry(Integer.MAX_VALUE, 0);
		
		head.right=tail;
		tail.left=head;
		n=0;
		h=0;
		r=new Random();		
	}
	
	//在最下面一层，找到要插入的位置前面的那个key
	private SkipListEntry findEntry(int k){
		SkipListEntry p=head;
		while(true){
			/**
			 * 一直向右找，例: k=34. 
			 * 10 ---> 20 ---> 30 ---> 40 ^ | p 会在30处停止
			 * --------------------------------------------
			 ***/
			while(p.right.key!=Integer.MAX_VALUE&&p.right.key<=k){
				p=p.right;
			}
			if(p.down!=null){// 如果还有下一层，就到下一层继续查找
				p=p.down;
			}else{// 到了最下面一层 就停止查找
				break;
			}
		}
		return p;
	}
	
	/** 返回和key绑定的值 */
	public Integer get(int key){
		SkipListEntry entry=findEntry(key);
		if(entry.key==key){
			return entry.value;
		}else{
			return null;
		}		
	}
	
	/** 放一个key-value到跳跃表中, 替换原有的并返回 */
	public Integer put(int key, int value){
		SkipListEntry entry=findEntry(key);
		if(entry.key==key){
			Integer re=entry.value;
			entry.value=value;
			return re;
		}
		SkipListEntry newEntry=new SkipListEntry(key, value);
		newEntry.left=entry;
		newEntry.right=entry.right;
		entry.right.left=newEntry;
		entry.right=newEntry;
		
		int i=0;// 当前层 level = 0
		while(r.nextDouble()<0.5){
			if(h<=i){
				SkipListEntry p1=new SkipListEntry(Integer.MIN_VALUE, 0);
				SkipListEntry p2=new SkipListEntry(Integer.MAX_VALUE, 0);
				h++;
				p1.right=p2;
				p1.down=head;
				
				p2.left=p1;
				p2.down=tail;
				
				head.up=p1;
				tail.up=p2;
				
				head=p1;
				tail=p2;				
			}			
			while(entry.up==null){
				entry=entry.left;
			}
			entry=entry.up;
			
			SkipListEntry e=new SkipListEntry(key, value); 
			e.left=entry;
			e.right=entry.right;
			e.down=newEntry;
			newEntry.up=e;
			entry.right.left=e;
			entry.right=e;
			
			entry=e;
			i++;
		}
		n++;
		return null;
	}
	
	
	
	/** 返回 包含的元素个数 */
	public int size() {
		return n;
	}

	/** 跳跃表是否为空 */
	public boolean isEmpty() {
		return (n == 0);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
