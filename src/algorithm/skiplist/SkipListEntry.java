package algorithm.skiplist;

public class SkipListEntry {
	public int key;
	public int value;
	
	public int pos;//主要为了打印链表用
	
	public SkipListEntry up, down, left, right;// 上下左右 四个指针
	
	
	public SkipListEntry(int key, int value){
		this.key=key;
		this.value=value;		
	}
	
	public boolean equals(Object o){
		SkipListEntry ent;
		try{
			ent=(SkipListEntry)o;
		}catch(ClassCastException ex){
			return false;
		}
		return ent.key==this.key&&ent.value==this.value;
	}
	
}
