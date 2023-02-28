
import java.util.Arrays;

/**
 *
 * @author Hanood
 */
public class Floyd {

    public static void main(String[] args) {
        int n = 7;
        int[][] w = {
            {0, 4, 1000, 1000, 1000, 10, 1000},
            {3, 0, 1000, 18, 1000, 1000, 1000},
            {1000, 6, 0, 1000, 1000, 1000, 1000},
            {1000, 5, 15, 0, 2, 19, 5},
            {1000, 1000, 12, 1, 0, 1000, 1000},
            {1000, 1000, 1000, 1000, 1000, 0, 10},
            {1000, 1000, 1000, 8, 1000, 1000, 0}
        };

        Floyd f = new Floyd(n, w);
        f.Floyd();
        System.out.println(f.Floyd_D());
        System.out.println("---------------------");
        System.out.println(f.Floyd_P());
    }
    
    private int n;
    private int[][] w;
    private int[][] D;
    private int[][] P;
    String s = ""; // To return path

    public Floyd(int n, int[][] w) {
        this.n = n;
        D = new int[n][n];
        P = new int[n][n];
        this.w = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            System.arraycopy(w[i], 0, this.w[i], 0, n);
        }
    }

    public void Floyd() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                P[i][j] = -1;
            }
        }
        D=w;
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(D[i][k]+D[k][j]<D[i][j]){
                        P[i][j]=k;
                        D[i][j]=D[i][k]+D[k][j];
                    }
                }
            }
        }

        // Complete...
        



    }

    public void path(int q, int r) {

        if (P[q][r] != -1) {
            path(q, P[q][r]);
            s += "V" + (P[q][r] + 1) + " , ";
            path(P[q][r], r);
        }

    }

    public String getPath(int q, int r) {
        path(q, r);
        return s;
    }

    public String Floyd_D() {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += Arrays.toString(D[i]) + "\n";
        }
        return s;
    }

    public String Floyd_P() {
        int[][] P1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(P[i], 0, P1[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                P1[i][j] += 1;
            }
        }

        String s = "";
        for (int i = 0; i < n; i++) {
            s += Arrays.toString(P1[i]) + "\n";
        }
        return s;
    }

    public int[][] getD() {
        return D;
    }

    public int[][] getP() {
        return P;
    }
}
