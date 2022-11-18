import java.util.*;

public class fcfs {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of processes :");
        int n = sc.nextInt();
        int pn[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        //int temp;
        float agwt = 0, agtat = 0;

        //input the process name, arrival time, burst time
        for(int i=0;i<n;i++){
            System.out.println("enter process " + (i+1) + " arrival time : ");
            at[i] = sc.nextInt();
            System.out.println("enter process " + (i+1) + " burst time : ");
            bt[i] = sc.nextInt();
            pn[i] = i+1; 
        }

        for(int i=0;i<n;i++){
            if(i == 0){
                ct[i] = at[i] + bt[i];
            }else{
                if(at[i] > ct[i-1]){
                    ct[i] = at[i] + bt[i];
                }else{
                    ct[i] = ct[i-1] + bt[i];
                }
            }
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            agwt += wt[i];
            agtat += tat[i];
        }
        
        System.out.println("P.No\tAT\tBT\tCT\tTAT\tWT");
        for(int i=0;i<n;i++){
            System.out.println(pn[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+tat[i]+"\t"+wt[i]);
           

        }
        System.out.println("average turn around time is "+ agtat/n);
        System.out.println("average waiting time is "+ agwt/n);
        
    }
}
