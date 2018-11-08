/**
 * 
 */
package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int tagId;

	@Column(name = "name")
	private String tagName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "tags")
	private Set<News> news = new HashSet<>();

	/**
	 * @param tagId
	 * @param tagName
	 */
	public Tag() {
		super();
	}

	/**
	 * @return the news
	 */
	public Set<News> getNews() {
		return news;
	}

	/**
	 * @param news the news to set
	 */
	public void setNews(Set<News> news) {
		this.news = news;
	}
	
	/**
	 * @param news the news to set
	 */
	public void addNews(News news) {
		this.news.add(news);
	}

	/**
	 * @return the tagId
	 */
	public int getTagId() {
		return tagId;
	}

	/**
	 * @param tagId the tagId to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	/**
	 * @return the tagName
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * @param tagName the tagName to set
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
