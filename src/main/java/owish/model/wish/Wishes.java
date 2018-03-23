package owish.model.wish;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "owish", type = "wishes")
public class Wishes {
	@Id
	private String id;
	private String title;
	private String active;

	public Wishes() {
	}

	public Wishes(String id, String title, String active) {
		super();
		this.id = id;
		this.title = title;
		this.active = active;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Wishes [id=" + id + ", title=" + title + ", active=" + active + "]";
	}

}
