public class TaskListLL implements TaskList {

  private TaskListNode head;
  private int count;

    public TaskListLL() {
      head=null;
  		count=0;
    }


    public int getLength() {
        System.out.println("ECHO getLength()");
        return count;
    }


    public boolean isEmpty() {
        System.out.println("ECHO isEmpty()");
        if(count > 0){
          return false;
        }
        else{
          return true;
        }
    }


    public Task removeHead() {
        Task result;
        head = null;
    		count = 0;
        System.out.println("ECHO removeHead()");

    }


    public Task remove(int number) {
        System.out.println("ECHO remove(task with number " + number
            + ")" );
        return null;
    }


    public boolean insert(int priority, int number) {
        System.out.println("ECHO insert(Task(" + priority + " " +
            number + "))");

            INode newNode = new INode(x);
        		count++;
        		if(head == null){
        			head = newNode;
        			return;
        		}
        		INode temp = head;
        		while(temp.next != null){
        			temp = temp.next;
        		}
        		temp.next = newNode;
    }


    public Task retrieve(int pos) {
        System.out.println("ECHO retrieve(" + pos + ")");
        TaskListNode temp = head;
    		for(int i = 0; i <= pos; i++){
    			if(i == pos){
    				return temp.item;
    			}
    			temp = temp.next;


    		}
    		return -1;
    }
}
