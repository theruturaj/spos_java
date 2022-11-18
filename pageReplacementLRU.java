import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class pageReplacementLRU {
    static void pageFaults (int pages[],int n,int capacity) {
        HashSet<Integer> s = new HashSet<>(capacity);
        HashMap<Integer,Integer> indexes = new HashMap<>();

        int page_faults = 0;
        int page_hits = 0;
        for (int i=0;i<n;i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);
                    page_faults++;
                } else {
                    page_hits++;
                }
                indexes.put(pages[i],i);
            } else {
                if (!s.contains(pages[i])) {
                    int lru = Integer.MAX_VALUE, val = Integer.MIN_VALUE;
                    Iterator<Integer> itr = s.iterator();

                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru) {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    } 
                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);
                    page_faults++;
                } else {
                    page_hits++;
                }
                indexes.put(pages[i],i);
            }
        } 
        System.out.println("page faults = " + page_faults + "\tpage hits = " + page_hits);
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter no of pages : ");
        int n = in.nextInt();
        int pages[] = new int[n];
        System.out.println("Enter the pages : ");
        for (int i=0;i<n;i++) {

            pages[i] = in.nextInt();
        }
        System.out.println("Enter the capacity : ");
        int capacity = in.nextInt();
            
        pageFaults(pages, pages.length, capacity);
        
        in.close();
    }
}
