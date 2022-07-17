package net.ericsonj.todosistemas.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.GeneratedValue;

/**
 *
 * @author ericson
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    private long id;
    private String name;
    private String state;
    private Timestamp endDate;
    private long assignedTo;
    private long deleyed;
//

    public Task() {
    }
    
    public Task(String name, Timestamp endDate, long assignedTo) {
        this.name = name;
        this.state = "DOING";
        this.endDate = endDate;
        this.assignedTo = assignedTo;
        Date now = new Date();
        Date end = new Date(endDate.getTime());    
        this.deleyed = now.getTime() > end.getTime() ? 0 : 1;
    }

    public void updateTask(Task task) {
        if (task.getName() != null) {
            this.setName(task.getName());
        }
        if (task.getState() != null) {
            this.setState(task.getState());
        }
        if (task.getEndDate()!= null) {
            this.setEndDate(task.getEndDate());
        }
        if (task.getAssignedTo() != 0) {
            this.setAssignedTo(task.getAssignedTo());
        }
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public long getDeleyed() {
        return deleyed;
    }

    public void setDeleyed(long deleyed) {
        this.deleyed = deleyed;
    }

}
