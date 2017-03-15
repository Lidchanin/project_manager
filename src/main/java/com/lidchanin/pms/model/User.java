package com.lidchanin.pms.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Class <code>User</code> is an entity.<code>User</code> implements
 * <code>Serializable</code> to support serialization.
 * @see Serializable
 *
 * Annotation <code>Entity</code> specify, that the class is an entity.
 * @see Entity
 *
 * Annotation <code>Table</code> specified the primary table for the annotated
 * table.
 * <code>name</code> matches the database table name.
 * <code>schema</code> matches the database schema, where located table.
 * @see Table
 */
@Entity
@Table(name = "users", schema = "project_management_system")
public class User implements Serializable {

    /**
     * Simple constructor for create empty user.
     */
    public User() {
    }

    /**
     * Constructor for create user with:
     * @param ssoId is the unique username of the user.
     * @param lastName is the last name of the user.
     * @param firstName is the first name of the user.
     * @param email is the email of the user.
     * @param password is the password of the user.
     */
    public User(String ssoId, String lastName, String firstName, String email, String password) {
        this.ssoId = ssoId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    /**
     * Field <code>id</code> adds a unique number to the object.
     *
     * Annotation <code>Id</code> Specifies the primary key of an entity.
     * @see Id
     *
     * Annotation <code>GeneratedValue</code> provides for the specification
     * of generation strategies for the values of primary keys.
     * <code>strategy</code> specify, how the field <code>id</code> will be filled.
     * @see GeneratedValue
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    /**
     * Field <code>ssoId</code> is the username of the object <code>User</code>.
     * <code>nullable = false</code> specify, that the username can't be empty
     * <code>unique = true</code> specify, that the column is a unique key.
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "sso_id", nullable = false, unique = true)
    private String ssoId;

    /**
     * Field <code>lastName</code> is the last name of the object <code>User</code>.
     * <code>nullable = false</code> specify, that the last name can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Field <code>firstName</code> is the first name of the object <code>User</code>.
     * <code>nullable = false</code> specify, that the name can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Field <code>email</code> is the email of the object <code>User</code>.
     * <code>nullable = false</code> specify, that the name can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Field <code>password</code> is the password of the object <code>User</code>.
     * <code>nullable = false</code> specify, that the password can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Field <code>role</code> is the user role of the object <code>User</code>.
     * <code>nullable = false</code> specify, that the user role can't be empty
     *
     * Annotation <code>Column</code> specifies the mapped column for a
     * persistent property or field.
     * @see Column
     *
     * Annotation <code>Enumerated</code> specifies that a persistent property or
     * field should be persisted as a enumerated type.
     * @see Enumerated
     */
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    /**
     * Field <code>userTasks</code> contains an all task tied to this developer.
     *
     * Annotation <code>OneToMany</code> need for specify a relationship.
     * @see OneToMany
     *
     * One to many relationship:
     * One developer - many tasks.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> userTasks;

    /**
     * Field <code>userTaskLogs</code> contains an all task logs tied to this developer.
     *
     * Annotation <code>OneToMany</code> need for specify a relationship.
     * @see OneToMany
     *
     * One to many relationship:
     * One developer - many task logs.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TaskLog> userTaskLogs;

    /**
     * Field <code>projects</code> contains an all projects tied to this developer.
     *
     * Annotation <code>ManyToMany</code> need for specify a relationship.
     * @see ManyToMany
     *
     * Annotation <code>JoinTable</code> used in the mapping of associations.
     * @see JoinTable
     *
     * Annotation <code>JoinColumn</code> specifies a column for joining an entity
     * association.
     * @see JoinColumn
     *
     * Many to many relationship:
     * One developer - many projects,
     * One project - many developers.
     */
    @ManyToMany
    @JoinTable(
            name = "projects_users",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private List<Project> projects;

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public List<Task> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(List<Task> userTasks) {
        this.userTasks = userTasks;
    }

    public List<TaskLog> getUserTaskLogs() {
        return userTaskLogs;
    }

    public void setUserTaskLogs(List<TaskLog> userTaskLogs) {
        this.userTaskLogs = userTaskLogs;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
