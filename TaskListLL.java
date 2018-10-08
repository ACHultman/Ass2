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


            int tempentNumber = temp.next.task.getNumber();

              //System.out.println(tempentNumber);
              //System.out.println(temp.next.task);
              while(tempentNumber != number){
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
            TaskListNode temp = head;

        		count++;
        		if(head == null){
        			head = newNode;
        			return true;
        		}

      /*      for (int i = 0; i < this.getLength(); i++) {
                System.out.println(head.task);
                System.out.println(temp.task);
                int tempNumber = temp.task.getNumber();
                int tempPriority = temp.task.getPriority();


                        if (tempNumber == number && tempPriority == priority) {

                            return false;
                        }
                        temp = temp.next;
                    }
                    if (head == null || newNode.task.getPriority() > head.task.getPriority()) {
                        newNode.next = head;
                        head = newNode;
                    } else {
                        TaskListNode before = head;
                        TaskListNode after = head.next;
                        while (after != null) {
                            if (newNode.task.getPriority() > after.task.getPriority()) {
                                break;
                            }
                            before = after;
                            after = after.next;
                        }
                        newNode.next = after;
                        before.next = newNode;
                        return true;
                    }
                    return true;
                } */



              //System.out.println(temp.task);
              //boolean higherPriority;

              if(temp == null){
                temp = newNode;
                return true;
              }

              if (temp.task.getNumber() == number || temp.task.getPriority() == priority) {

                  return false;
              }
              temp = temp.next;


              if (head == null || newNode.task.getPriority() > head.task.getPriority()) {
                  newNode.next = head;
                  head = newNode;
              } else {
                  TaskListNode before = head;
                  TaskListNode after = head.next;
                  while (after != null) {
                      if (newNode.task.getPriority() > after.task.getPriority()) {
                          break;
                      }
                      before = after;
                      after = after.next;
                  }

                  newNode.next = after;
                  before.next = newNode;
                  //System.out.println(count);
                  return true;
              }
              return true;


            /*  if(priority > temp.task.getPriority()){

                higherPriority = false;

              }


              if(priority < temp.task.getPriority()){

                higherPriority = true;
              }

              else{
                System.out.println("4");
                temp.next =newNode;
                return true;
              }


              return true;*/

    }


    public Task retrieve(int pos) {
        System.out.println("ECHO retrieve(" + pos + ")");
        TaskListNode temp = head;


        if (pos < this.getLength() && pos >= 0) {
              for (int i = 0; i < pos; i++) {
                  temp = temp.next;
              }
              return temp.task;
          } else {
              return null;
          }
      }
}
