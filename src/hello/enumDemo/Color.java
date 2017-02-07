package hello.enumDemo;

public enum Color {
	RED{
		public String getType(){
			return "i am red";
		}
	}, GREEN {
		@Override
		public String getType() {
			return "i am green";
		}
	}, YELLOW {
		@Override
		public String getType() {
			return "you guess";
		}
	};
	
	static int value;	
	public static int getValue(){
		return value;
	}
	
	String type;
	public abstract String getType();
}

