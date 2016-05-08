package sues.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content implements Serializable {
	
	@Id
	@Column(name="row")
	private String row;
	
	@Column(name="contents")
	private String contents;
	
	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public Content() {
		
	}
	
	public Content(String row, String contents) {
		this.row = row;
		this.contents = contents;
	}
	
}
