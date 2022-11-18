import java.util.Scanner;

public class priorityNonPreemptive {
    int burstTime[];
    int arrivalTime[];
    int priority[];
    String[] processId;
    int numberOfProcess;

    void getProcessData(Scanner input) {
        System.out.print("Enter the no of processes : ");
        int inputNumberOfProcess = input.nextInt();
        numberOfProcess = inputNumberOfProcess;
        burstTime = new int[numberOfProcess];
        arrivalTime = new int[numberOfProcess];
        priority = new int[numberOfProcess];
        processId = new String[numberOfProcess];
        String st = "P";
        for(int i=0;i<numberOfProcess;i++) {
            processId[i] = st.concat(Integer.toString(i));
            System.out.println("Enter the arrival time for the process " + i + " : " );
            arrivalTime[i] = input.nextInt();
            System.out.println("Enter the burst time for the process " + i + " : ");
            burstTime[i] = input.nextInt();
            System.out.println("Enter the priority for the process " + i + " : ");
            priority[i] = input.nextInt();
        }
    }
    void sortAccordingArrivalTimeAndPriority(int[] at,int[] bt, int[] prt, String[] pid) {
        int temp;
        String stemp;
        for(int i=0;i<numberOfProcess;i++) {
            for(int j=0;j<numberOfProcess;j++) {
                if(at[j] > at[j+1]) {
                    temp = at[j];       //swapping arrival time
                    at[j] = at[j+1];
                    at[j+1] = temp;
                    
                    temp = bt[j];       //swapping burst time
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;

                    temp = prt[j];      //swapping priorities
                    prt[j] = prt[j+1];
                    prt[j+1] = temp;

                    stemp = pid[j];     //swapping process identity
                    pid[j] = pid[j+1];
                    pid[j+1] = stemp;
                }

                if(at[j] == at[j+1]) {
                    if(prt[j] > prt[j+1]){
                        temp = at[j];       //swapping arrival time
                        at[j] = at[j+1];
                        at[j+1] = temp;
                        
                        temp = bt[j];       //swapping burst time
                        bt[j] = bt[j+1];
                        bt[j+1] = temp;

                        temp = prt[j];      //swapping priorities
                        prt[j] = prt[j+1];
                        prt[j+1] = temp;

                        stemp = pid[j];     //swapping process identity
                        pid[j] = pid[j+1];
                        pid[j+1] = stemp;
                    }
                }
            }
        }
    }
    void priorityNonPreemptiveAlgorithm() {
        int finishTime[] = new int[numberOfProcess];
        int bt[] = burstTime.clone();
        int at[] = arrivalTime.clone();
        int prt[] = priority.clone();
        String pid[] = processId.clone();
        int waitingTime[] = new int[numberOfProcess];
        int turnAroundTime[] = new int[numberOfProcess];

        sortAccordingArrivalTimeAndPriority(at, bt, prt, pid);

        finishTime[0] = at[0] + bt[0];
        turnAroundTime[0] = finishTime[0] - at[0];
        waitingTime[0] = turnAroundTime[0] - bt[0];

        for(int i=1;i<numberOfProcess;i++) {
            finishTime[i] = bt[i] + finishTime[i-1];
            turnAroundTime[i] = finishTime[i] - at[i];
            waitingTime[i] = turnAroundTime[i] - bt[i];
        }
        float sum = 0;
        for(int n : waitingTime) {
            sum += n;
        }
        float avgWaitingTime = sum / numberOfProcess;
        sum = 0;
        for(int n : turnAroundTime) {
            sum += n;
        }
        float avgTurnAroundTime = sum / numberOfProcess;

        System.out.println("Priority Scheduling Algorithm : ");
        System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId", "BurstTime", "ArrivalTime", "Priority", "FinishTime", "WaitingTime", "TurnAroundTime");
        for (int i = 0; i < numberOfProcess; i++) {
            System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", pid[i], bt[i], at[i], prt[i], finishTime[i], waitingTime[i], turnAroundTime[i]);
        }

        System.out.format("%100s%20f%20f\n", "Average", avgWaitingTime, avgTurnAroundTime);
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        priorityNonPreemptive obj = new priorityNonPreemptive();
        obj.getProcessData(input);
        obj.priorityNonPreemptiveAlgorithm();
    }
}
