package hello.enumDemo;

public enum Operation {
  PLUS("+") {
    double apply(double x, double y) { return x + y; }
  }, 
  MINUS("-") {
    double apply(double x, double y) { return x - y; }
  }, 
  TIMES("*") {
    double apply(double x, double y) { return x * y; }
  }, 
  DIVIDE("/") {
    double apply(double x, double y) { return x / y; }
  };
  
  private final String symbol;
  
  Operation(String symbol) {
    this.symbol = symbol;
  }
  
  @Override
  public String toString() {
    return symbol;
  }
  
  abstract double apply(double x, double y);
  
  private static boolean isPLUS(Operation op) {
    return op.equals(Operation.PLUS);
  }
  
  private static void showOperation(Operation op) {
    switch (op) {
      case PLUS: 
        System.out.println("I am PLUS");
        break;
      case MINUS: 
        System.out.println("I am MINUS");
        break;
      case TIMES: 
        System.out.println("I am TIMES");
        break;
      case DIVIDE: 
        System.out.println("I am DIVIDE");
        break;
       default:
          break;
    }
  }
  
  public static void main(String[] args) {
    double x = 0.1234;
    double y = 3.6789;
    for (Operation op : Operation.values()) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
    
    System.out.println(Operation.PLUS);//+
    System.out.println(isPLUS(Operation.PLUS));//true
    System.out.println(isPLUS(Operation.MINUS));//false
    showOperation(Operation.DIVIDE);//I am DIVIDE
  }
}
