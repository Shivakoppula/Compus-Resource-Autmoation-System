package com.project.compusResurce_Automation_System.Entities_Class;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notice {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String content;
	    private LocalDateTime postedAt;
	    private String postedBy;
		public Notice(String title, String content, LocalDateTime postedAt, String postedBy) {
			super();
			this.title = title;
			this.content = content;
			this.postedAt = postedAt;
			this.postedBy = postedBy;
		}
		public Notice(Long id, String title, String content, LocalDateTime postedAt, String postedBy) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.postedAt = postedAt;
			this.postedBy = postedBy;
		}
		public Notice() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public LocalDateTime getPostedAt() {
			return postedAt;
		}
		public void setPostedAt(LocalDateTime postedAt) {
			this.postedAt = postedAt;
		}
		public String getPostedBy() {
			return postedBy;
		}
		public void setPostedBy(String postedBy) {
			this.postedBy = postedBy;
		}
	    

}
