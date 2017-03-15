package com.lidchanin.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    public Task() {
    }

    public Task(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status", nullable = false, unique = true, length = 15)
    private String status;

    // todo: Need to receiving time from the client
    @Column(name = "start_time")
    private Timestamp startTime = new Timestamp(System.currentTimeMillis());

    @Column(name = "final_time")
    private Timestamp finalTime;

    // todo: check, work default value or not
    @Column(name = "readiness", nullable = false, columnDefinition = "boolean default false")
    private boolean readiness;

    /**
     * Many to one relationship
     * Many tasks - one project
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    /**
     * Many to one relationship
     * Many tasks - one user
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id", nullable = false)
    private User user;

    /**
     * One to one relationship
     * One task - one task log
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_log_id")
    private TaskLog taskLog;

    public boolean isReadiness() {
        return readiness;
    }

    public void setReadiness(boolean readiness) {
        this.readiness = readiness;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Timestamp finalTime) {
        this.finalTime = finalTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskLog getTaskLog() {
        return taskLog;
    }

    public void setTaskLog(TaskLog taskLog) {
        this.taskLog = taskLog;
    }
}
