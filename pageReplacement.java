import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class pageReplacement{
    static int pageFaults(int[] pages,int n,int capacity){
        HashSet<Integer> set = new HashSet<>(capacity);
        Queue<Integer> indexes = new LinkedList<>();
        
        int pageFaults = 0;
        for(int i=0;i<n;i++){
            if (set.size() < capacity) {
                if (!set.contains(pages[i])) {
                    set.add(pages[i]);
                    pageFaults++;
                    indexes.add(pages[i]);
                }
            }else {
                if(!set.contains(pages[i])){
                    int val = indexes.peek();
                    indexes.poll();
                    set.remove(val);
                    set.add(pages[i]);
                    indexes.add(pages[i]);
                    pageFaults++;

                }
            }
        }
        return pageFaults;
    }
    public static void main(String []args){
        int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};

        int capacity = 4;
        System.out.println(pageFaults(pages, pages.length, capacity));
    }
}

