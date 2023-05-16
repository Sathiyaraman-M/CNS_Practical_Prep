import java.util.*;
public class PlayFair {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char s[][] = {{'M','O','N','A','R'},{'C','H','Y','B','D'},{'E','F','G','I','K'},{'L','P','Q','S','T'},{'U','V','W','X','Z'}};
        String st = sc.nextLine();
        String arr[]=new String[100];
        int k=0,i=0;
        while(i<st.length()){
            if(i==st.length()-1){
                String m = st.substring(i)+"X";
                arr[k] = m;
                break;
            }
            else if(st.charAt(i)!=st.charAt(i+1)){
                String sk = st.substring(i,i+1)+st.charAt(i+1);
                arr[k] = sk;
                i+=2;
            }
            else{
                String sks = st.substring(i,i+1)+"X";
                arr[k] = sks;
                i+=1;
            }
            k+=1;
        }
        System.out.println( );
        for(int j=0;arr[j]!=null;j++){
            System.out.println(arr[j]);
        }
        for(int c=0;arr[c]!=null;c++){
            char p = arr[c].charAt(0);
            char q = arr[c].charAt(1);
            if(p=='j'){
                p='i';
            }
            if(q=='j') {
                q='i';
            }
            //System.out.println(p+" "+q);
            int ax=0,ay=0,bx=0,by=0;
            for(int x=0;x<5;x++){
                for(int y=0;y<5;y++){
                    if(s[x][y]==p) {
                        ax=x;
                        ay=y;
                    }
                    else if(s[x][y]==q) {
                        bx=x;
                        by=y;

                    }


                }
            }
            if(ax != bx && ay != by){
                System.out.printf("%c%c",s[ax][by],s[bx][ay]);

            }
            else if(ax==bx){
                System.out.printf("%c%c",s[ax][(ay+1)%5],s[bx][(by+1)%5]);

            }
            else if(ay==by) {
                System.out.printf("%c%c",s[(ax+1)%5][ay],s[(bx+1)%5][by]);

            }
        }

    }
}
