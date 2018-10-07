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
      System.out.println("ECHO removeHead()");
        Task result;

        if(head == null){
    			return null;
    		}
    		count--;
    		TaskListNode removed = head;
    		head = head.next;
    		return removed.task;



    }


    public Task remove(int number) {
        System.out.println("ECHO remove(task with number " + number
            + ")" );
            TaskListNode temp = head;
            temp.next = head;

          	if(head.equals(null)) {
              System.out.println("null");
              return null;
            }

            while(true){
              int currentNumber = temp.next.task.getNumber();
              //System.out.println(currentNumber);
              //System.out.println(temp.next.task);
              if(currentNumber != number){
                if(temp.next.equals(null)){
                  System.out.println("null");
                  return null;
                }
                //System.out.println(temp.next.task);
            		temp = temp.next;
                System.out.println("continue");
                continue;
            	}
            	temp.next = temp.next.next;
            	count--;
              return temp.next.task;
            }


    }


    public boolean insert(int priority, int number) {
        System.out.println("ECHO insert(Task(" + priority + " " +
            number + "))");

            Task newTask = new Task(priority, number);
            TaskListNode newNode = new TaskListNode(newTask, head);

        		count++;
        		if(head == null){
        			head = newNode;
        			return true;
        		}

        		TaskListNode temp = head;
            while(true){
              boolean compare;
              if(temp.task.compareTo(newTask) == -1){
                compare = false;
              }
              else {
                compare = true;
              }

              if(!(temp.next == null && compare)){

                temp = temp.next;

              }
              else{
                newNode = temp;
                return true;
              }




            }

    }


    public Task retrieve(int pos) {
        System.out.println("ECHO retrieve(" + pos + ")");
        TaskListNode temp = head;
    		for(int i = 0; i <= pos; i++){
    			if(i == pos){
    				return temp.task;
    			}
    			temp = temp.next;


    		}
        return null;
    }
}
