class anyBaseToAnyBaseConversion{
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int sourceBase = scn.nextInt();
    int  destBase = scn.nextInt();

    int ans = getValueIndecimal(n, sourceBase);
    System.out.print(getValueInBase(ans, destBase));
  }

  // ANY BASE TO DECIMAL
  public static int getValueIndecimal(int n, int b) {
    int res = 0;
    int pow = 1;
    while(n != 0) {
        int rem = n % 10;
        n /= 10;
        res += rem*pow;
        pow *= b;
    }
    return res;
  }
  
  // DECIMAL TO ANY BASE
  public static int getValueInBase(int n, int b) {
    int res = 0;
    int pow = 1;
    while(n != 0) {
        int rem = n % b;
        n /= b;
        res += rem*pow;
        pow *= 10;
    }
    return res;
  }
}

//Time Complexity: O(N)
//Auxiliary Space: O(1)
