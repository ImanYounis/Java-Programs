package QueuesPractice;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class priqueue {

	public static void main(String[] args) {
		PriorityQueue<String> q1=new PriorityQueue<String>();
		q1.offer("Pakistan");
		q1.offer("Saudia Arabia");
		q1.offer("Makkah");
		q1.offer("Madinah");
		 System.out.print("priority queue using comparable:-\n");
		 while(q1.size()>0) {
			 System.out.print(q1.remove()+" ");
		 }
		
		 PriorityQueue<String> q2=new PriorityQueue<String>(4, Collections.reverseOrder());
			q2.offer("Pakistan");
			q2.offer("Saudia Arabia");
			q2.offer("Makkah");
			q2.offer("Madinah");
			 System.out.print("priority queue using comparator:-\n");
			 while(q2.size()>0) {
				 System.out.print(q2.remove()+" ");
			 }
		//simple queue
			 Queue<String> q=new LinkedList<String>();
			 q.offer("Pakistan");
				q.offer("Saudia Arabia");
				q.offer("Makkah");
				q.offer("Madinah");
				 System.out.print("\nsimple queue:-\n");
				 while(q.size()>0) {
					 System.out.print(q.remove()+" ");
				 }
	}

}
