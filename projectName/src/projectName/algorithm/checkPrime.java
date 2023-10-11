package projectName.algorithm;

public class checkPrime {
    public static boolean checkPrimefunc(int number){
        int n = (int)Math.sqrt(number) ;
        for(int i=2;i<=n;i++){
            if(number % i == 0){
                return false ;
            }
        }
        return true ;
    }
}
