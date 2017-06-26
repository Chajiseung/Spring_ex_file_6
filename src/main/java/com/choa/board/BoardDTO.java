package com.choa.board;

import java.sql.Date;

public class BoardDTO extends BDTO{
	

	private String title;

	private int hit;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	

}
