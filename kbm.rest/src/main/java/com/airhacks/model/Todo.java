package com.airhacks.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the todo database table.
 * 
 */
@Entity
@NamedQuery(name="Todo.findAll", query="SELECT t FROM Todo t")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String datecompleted;

	private String datecreated;

	private String duedate;

	private Boolean iscompleted;

	private String task;

	public Todo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatecompleted() {
		return this.datecompleted;
	}

	public void setDatecompleted(String datecompleted) {
		this.datecompleted = datecompleted;
	}

	public String getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}

	public String getDuedate() {
		return this.duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public Boolean getIscompleted() {
		return this.iscompleted;
	}

	public void setIscompleted(Boolean iscompleted) {
		this.iscompleted = iscompleted;
	}

	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}