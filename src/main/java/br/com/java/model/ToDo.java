package br.com.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {
    @Id
    private String id;
    private String name;
    private String details;
    private boolean done;
    public ToDo() {
    }
    public ToDo(String id, String name, String details, boolean done) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.done = done;
    }
    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * @return boolean return the done
     */
    public boolean isDone() {
        return done;
    }

    /**
     * @param done the done to set
     */
    public void setDone(boolean done) {
        this.done = done;
    }

}
