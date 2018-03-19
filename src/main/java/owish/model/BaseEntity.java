package owish.model;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public class BaseEntity {

	/*@Id
	protected int id;*/

	@Column(name = "creation_user")
	@CreatedBy
	protected String creationUser;

	@Column(name = "update_user")
	@LastModifiedBy
	protected String updateUser;

	@Column(name = "creation_date", updatable = false)
	@CreatedDate
	protected Date creationDate;

	@Column(name = "update_date")
	@LastModifiedDate
	protected Date updateDate;

	/*public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}*/

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}

