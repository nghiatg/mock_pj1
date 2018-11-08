/**
 * 
 */
package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "hr")
public class Hr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int hrId;

	@Column(name = "name")
	private String name;

	@Column(name = "hrType")
	private boolean type;
	
	@OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<News> newsCreated = new ArrayList<>();
	
	@OneToMany(mappedBy = "confirmer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<News> newsConfirmed = new ArrayList<>();

	/**
	 * @return the newsCreated
	 */
	public List<News> getNewsCreated() {
		return newsCreated;
	}

	/**
	 * @param newsCreated the newsCreated to set
	 */
	public void setNewsCreated(List<News> newsCreated) {
		this.newsCreated = newsCreated;
	}
	
	/**
	 * @param newsCreated the newsCreated to set
	 */
	public void addNewsCreated(News news) {
		this.newsCreated.add(news);
	}

	/**
	 * @return the newsConfirmed
	 */
	public List<News> getNewsConfirmed() {
		return newsConfirmed;
	}

	/**
	 * @param newsConfirmed the newsConfirmed to set
	 */
	public void setNewsConfirmed(List<News> newsConfirmed) {
		this.newsConfirmed = newsConfirmed;
	}
	
	/**
	 * @param newsConfirmed the newsConfirmed to set
	 */
	public void addNewsConfirmed(News news) {
		this.newsConfirmed.add(news);
	}

	/**
	 * 
	 */
	public Hr() {
		super();
	}

	/**
	 * @return the hrId
	 */
	public int getHrId() {
		return hrId;
	}

	/**
	 * @param hrId the hrId to set
	 */
	public void setHrId(int hrId) {
		this.hrId = hrId;
	}

	/**
	 * @return the name
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
	 * @return the type
	 */
	public boolean isType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(boolean type) {
		this.type = type;
	}

}
