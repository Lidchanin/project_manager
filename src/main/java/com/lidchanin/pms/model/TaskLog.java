package com.lidchanin.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "task_logs", schema = "project_management_system")
public class TaskLog implements Serializable {

    public TaskLog() {
    }

    public TaskLog(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    // todo: Need to receiving time from the client
    @Column(name = "time")
    private Timestamp time = new Timestamp(System.currentTimeMillis());

    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Many to one relationship
     * Many task logs - one developer
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "taskLog")
    private Task task;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}