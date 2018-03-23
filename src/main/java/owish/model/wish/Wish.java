package owish.model.wish;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "wish")
@EntityListeners(AuditingEntityListener.class)
// public class Wish extends BaseEntity {
public class Wish {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String description;

	@Column(name = "completed_date")
	private String completedDate;
	@Column(name = "completed_user")
	private String completedUser;

	@Column(name = "creation_user", updatable = false)
	@CreatedBy
	protected String creationUser;
	@Column(name = "creation_date", updatable = false)
	@CreatedDate
	protected Date creationDate;

	@Column(name = "update_user")
	@LastModifiedBy
	protected String updateUser;



	@Column(name = "update_date")
	@LastModifiedDate
	protected Date updateDate;

	public Wish() {
		super();
	}

	public Wish(int id, String title, String description, String completedDate, String completedUser,
			String creationUser, Date creationDate, String updateUser, Date updateDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.completedDate = completedDate;
		this.completedUser = completedUser;
		this.creationUser = creationUser;
		this.creationDate = creationDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public String getCompletedUser() {
		return completedUser;
	}

	public void setCompletedUser(String completedUser) {
		this.completedUser = completedUser;
	}

	// @Override
	@Override
	public String toString() {
		return "Wish [title=" + title + ", description=" + description + "]";
	}

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
