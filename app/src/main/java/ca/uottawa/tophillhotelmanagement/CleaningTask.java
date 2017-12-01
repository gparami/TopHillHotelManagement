package ca.uottawa.tophillhotelmanagement;

import java.util.Date;

/**
 * @Author: parami
 * @Date: 2017-11-29
 * @Project: TopHillHotelManagement
 */

public class CleaningTask extends Task {

    private Room room;

    /**
     * Creates an unassigned cleaning task specified to a specific room.
     * @param taskName name of the task.
     * @param priority priority of the task
     * @param dueDate due date of the task.
     * @param room room to be cleaned.
     */
    public CleaningTask(String taskName, Priority priority, Date dueDate, Room room) {
        super(taskName, priority, dueDate);
        this.room = room;
    }

    /**
     * Creates an assigned cleaning task specified to a specific room.
     * @param taskName name of the task.
     * @param priority priority of the task
     * @param dueDate due date of the task.
     * @param room room to be cleaned.
     * @param assignedTo personnel that the task is assigned to.
     */
    public CleaningTask(String taskName, Priority priority, Date dueDate, Room room, Personnel assignedTo) {
        super(taskName, priority, dueDate, assignedTo);
        this.room = room;
    }

    public Room getRoom() { return room; }

    public void setRoom(Room room) { this.room = room; }
}
