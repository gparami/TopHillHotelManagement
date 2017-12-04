package ca.uottawa.tophillhotelmanagement;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: parami
 * @Date: 2017-11-29
 * @Project: TopHillHotelManagement
 */

public class Task {

    private Personnel assignedTo;
    private String taskName;
    private Priority priority;
    private Date dueDate;
    private boolean isAssigned, isComplete;

    //Test code from Atrem
    // int ready =

    /**
     * Creates a task object with a name, priority, and a due date (no assigned person).
     * @param taskName name of the task.
     * @param priority priority of the task.
     * @param dueDate due date of the task.
     */
    public Task(String taskName, Priority priority, Date dueDate ) {
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    /**
     * Creates a task object with a name, priority, due date and assigns it to an employee.
     * @param taskName name of the task.
     * @param priority priority of the task.
     * @param dueDate due date of the task.
     * @param assignedTo personnel that the task is assigned to.
     */
    public Task(String taskName, Priority priority, Date dueDate, Personnel assignedTo ) {
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
        isAssigned = true;
    }

    public Personnel getAssignedTo() { return assignedTo; }
    public String getTaskName() { return taskName; }
    public Priority getPriority() { return priority; }
    public Date getDueDate() { return dueDate; }
    public boolean isAssigned() { return isAssigned; }
    public boolean isComplete() { return isComplete; }

    public void setAssignedTo(Personnel assignedTo) { this.assignedTo = assignedTo; this.isAssigned = true; }
    public void unassign() { this.assignedTo = null; this.isAssigned = false; }
    public void setTaskName(String taskName) { this.taskName = taskName; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
    public void setAssigned(boolean assigned) { isAssigned = assigned; }
    public void markComplete() { isComplete = true; }
    public void markIncomplete() { isComplete = false; }

    public Calendar getCalendarDueDate(){
        Date date = this.dueDate;
        date.setYear(117);
        date.setMonth(11);
        date.setDate(25);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
