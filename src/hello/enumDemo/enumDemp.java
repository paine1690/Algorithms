package hello.enumDemo;

public class enumDemp {

	
	private static boolean isRed(Color color){
		return color.equals(Color.RED);
	}
	
	private static void showColor(Color color){		
		switch(color){
		case RED:
			System.out.println("is red");
            break;            
		case GREEN:
			System.out.println("is green");
		case YELLOW:
			System.out.println("is yellow");
		default:
			break;
		}
	}	
	
	public static void main(String[] args) {
		System.out.println(Color.RED);
		System.out.println(isRed(Color.RED));
		System.out.println(isRed(Color.GREEN));
		showColor(Color.RED);
//		System.out.println(Color.getValue());
//		System.out.println(Color.RED.getType());
		

	}

}
