// import java.lang.reflect.Array;
import java.util.Scanner;

public class ShortestJobFirst {

    public static void main(String[] args) {
        int n; //no of processes
        Scanner scanner = new Scanner(System.in);
        System.out.println("No of processes : ");
        n = scanner.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];
        int st = 0,  tot = 0 , avgwt =0, avgta =0;

        for(int i=0;i<n;i++) {
            System.out.println("Arrival Time of process " + i+1 + " : ");
            at[i] = scanner.nextInt();
            System.out.println("Burst Time of process " + i+1 + " : ");
            bt[i] = scanner.nextInt();
            pid[i] = i+1;
            f[i] = 0;
        }

        while(true) {
            int c = n, min = 99;
            if(tot == n){
                break;
            }
            for(int i=0;i<n;i++) {
                if((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
                if(c == n) {
                    st++;
                }else {
                    ct[c] = st + bt[c];
                    st += bt[c];
                    tat[c] = ct[c] - at[c];
                    wt[c] = tat[c] - bt[c];
                    f[c] = 1;
                    tot++;
                }
            }
        }
            System.out.println("pid\t\tarrival\t\tburst\t\tcomplete\t\tturn\t\twaiting");
            for(int i=0;i<n;i++) {
                avgwt += wt[i];
                avgta += tat[i];
                System.out.println(pid[i]  + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i] );
            }
            System.out.println("avg waiting time : " + avgwt/n);
            System.out.println("avg turn around time : " + avgta/n);
            scanner.close();


    }
}



