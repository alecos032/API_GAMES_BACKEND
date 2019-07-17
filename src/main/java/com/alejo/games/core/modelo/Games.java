package com.alejo.games.core.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="games")
@EntityListeners(AuditingEntityListener.class)

public class Games {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String image;
	
	@Temporal(TemporalType.DATE)
	private Date create_at;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Long getID() {
		return ID;
	}
	
}