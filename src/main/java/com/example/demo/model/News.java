/**
 * 
 */
package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int newsId;

	@Column(name = "title")
	private String title;

	@Column(name = "theDescription")
	private String description;

	@Column(name = "content")
	private String content;

	@Column(name = "createDate")
	private String createDate;

	@Column(name = "confirmDate")
	private String confirmDate;

	@Column(name = "pinned")
	private String pinned;

	@Column(name = "activeStatus")
	private String active;

	@Column(name = "upStatus")
	private String upStatus;

	@OneToMany(mappedBy = "news", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "news_tags", joinColumns = { @JoinColumn(name = "newsid") }, inverseJoinColumns = {
			@JoinColumn(name = "tagid") })
	private Set<Tag> tags = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator")
	private Hr creator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "confirmLeader")
	private Hr confirmer;

	/**
	 * @return the confirmer
	 */
	public Hr getConfirmer() {
		return confirmer;
	}

	/**
	 * @param confirmer the confirmer to set
	 */
	public void setConfirmer(Hr confirmer) {
		this.confirmer = confirmer;
		confirmer.addNewsConfirmed(this);
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @return the tags
	 */
	public Set<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	/**
	 * @return the creator
	 */
	public Hr getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(Hr creator) {
		this.creator = creator;
		creator.addNewsCreated(this);
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * @param comments the comments to set
	 */
	public void addComments(Comment comment) {
		this.comments.add(comment);
		comment.setNews(this);
	}

	/**
	 * @return the tags
	 */
	public Set<Tag> getTagss() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTagss(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTags(Tag tag) {
		this.tags.add(tag);
		tag.addNews(this);
	}

	/**
	 * 
	 */
	public News() {
		super();
	}

	/**
	 * @return the newsId
	 */
	public int getNewsId() {
		return newsId;
	}

	/**
	 * @param newsId the newsId to set
	 */
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the confirmDate
	 */
	public String getConfirmDate() {
		return confirmDate;
	}

	/**
	 * @param confirmDate the confirmDate to set
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}


	/**
	 * @return the pinned
	 */
	public String getPinned() {
		return pinned;
	}

	/**
	 * @param pinned the pinned to set
	 */
	public void setPinned(String pinned) {
		this.pinned = pinned;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the upStatus
	 */
	public String getUpStatus() {
		return upStatus;
	}

	/**
	 * @param upStatus the upStatus to set
	 */
	public void setUpStatus(String upStatus) {
		this.upStatus = upStatus;
	}

}
