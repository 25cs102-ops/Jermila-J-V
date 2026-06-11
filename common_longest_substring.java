import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      String m = sc.nextLine();
      String n = sc.nextLine();
      int x = m.length();
      int y = n.length();
      int dp[][] = new int[x+1][y+1];
      int maxlen = 0;
      for(int i=1;i<=x ; i++){
          for(int j=1;j<=y;j++){
              if(m.charAt(i-1) == n.charAt(j-1)){
                  dp[i][j] = dp[i-1][j-1] +1;
                  if(maxlen < dp[i][j]){
                      maxlen = dp[i][j];
                  }
              }
              else{
                  dp[i][j] = 0;
              }
          }
      }
      System.out.println(maxlen);
    }
}