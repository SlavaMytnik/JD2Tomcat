package org.example.tomcat1.bean;

import java.io.Serializable;
import java.time.LocalDate;

public class News implements Serializable {
	private static final long serialVersionUID = 4815906095162267588L;
	
	private int id;
	private String title;
	private String brief;
	private String content;
	private LocalDate date;
	private String status;

	public News() {
		super();
	}	

	public News(int id, String title, String brief) {
		super();
		
		this.id = id;
		this.title = title;
		this.brief = brief;
	}	

	public News(int id, String title, String brief, String content, LocalDate date) {
		super();
		
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
	}

	public News(int id, String title, String brief, String content, LocalDate date, String status) {
		super();
		
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.date = date;
		this.status = status;
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

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", brief=" + brief + ", content=" + content + ", date=" + date
				+ ", status=" + status + "]";
	}	
}
