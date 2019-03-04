package com.huylam98it.webuploadfile.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fileupload database table.
 * 
 */
@Entity
@Table(name="fileupload")
@NamedQuery(name="Fileupload.findAll", query="SELECT f FROM Fileupload f")
public class Fileupload implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateupload;

	private String filename;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cus_upload")
	private Customer customer;

	public Fileupload() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateupload() {
		return this.dateupload;
	}

	public void setDateupload(Date dateupload) {
		this.dateupload = dateupload;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}