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

            if(count == 0) {
              System.out.println("null");
              return null;
            }


            int currentNumber = temp.next.task.getNumber();

              //System.out.println(currentNumber);
              //System.out.println(temp.next.task);
              while(currentNumber != number){
                if(temp.next.equals(null)){
                  System.out.println("null");
                  return null;
                }
                //System.out.println(temp.next.task);
            		temp = temp.next;
            	}
            	temp.next = temp.next.next;
            	count--;
              System.out.println(count);
              return temp.next.task;
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
              System.out.println(temp.task);
              boolean higherPriority;
              if(priority > temp.task.getPriority()){
                System.out.println("1");
                higherPriority = false;

              }
              else {
                System.out.println("2");
                higherPriority = true;
              }

              if (temp.next == null && !higherPriority) {
                System.out.println("3");
                temp.next = newNode;
                return true;
              }

              else if(!higherPriority){
                System.out.println("4");
                System.out.println(temp.next.task);
                temp = temp.next;
                continue;
              }

              else{
                System.out.println("5");
                temp.next =newNode;
                return true;
              }




            }

    }


    public Task retrieve(int pos) {
        System.out.println("ECHO retrieve(" + pos + ")");
        TaskListNode temp = head;
    		for(int i = 0; i <= count; i++){
          //if(temp == null){
          //  return null;
        //  }
    			if(i == pos){
            System.out.println(temp.task);

    				return temp.task;
    			}
    			temp = temp.next;


    		}
        return null;
    }
}
