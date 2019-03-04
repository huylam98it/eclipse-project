package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cus_id")
	private int cusId;

	@Column(name="cus_fullname")
	private String cusFullname;

	@Column(name="cus_password")
	private String cusPassword;

	@Column(name="cus_username")
	private String cusUsername;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role")
	private Role roleBean;

	//bi-directional many-to-one association to Fileupload
	@OneToMany(mappedBy="customer")
	private List<Fileupload> fileuploads;

	public Customer() {
	}

	public int getCusId() {
		return this.cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusFullname() {
		return this.cusFullname;
	}

	public void setCusFullname(String cusFullname) {
		this.cusFullname = cusFullname;
	}

	public String getCusPassword() {
		return this.cusPassword;
	}

	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}

	public String getCusUsername() {
		return this.cusUsername;
	}

	public void setCusUsername(String cusUsername) {
		this.cusUsername = cusUsername;
	}

	public Role getRoleBean() {
		return this.roleBean;
	}

	public void setRoleBean(Role roleBean) {
		this.roleBean = roleBean;
	}

	public List<Fileupload> getFileuploads() {
		return this.fileuploads;
	}

	public void setFileuploads(List<Fileupload> fileuploads) {
		this.fileuploads = fileuploads;
	}

	public Fileupload addFileupload(Fileupload fileupload) {
		getFileuploads().add(fileupload);
		fileupload.setCustomer(this);

		return fileupload;
	}

	public Fileupload removeFileupload(Fileupload fileupload) {
		getFileuploads().remove(fileupload);
		fileupload.setCustomer(null);

		return fileupload;
	}

}