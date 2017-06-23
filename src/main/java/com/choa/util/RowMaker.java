package com.choa.util;

public class RowMaker {
	private int startRow;
	private int lastRow;
	
	
	public void setRow(int curPage, int perPage){
		startRow = perPage*(curPage-1)+1;
		lastRow = perPage*curPage;
	}
	
	public int getStartRow() {
		return startRow;
	}

	public int getLastRow() {
		return lastRow;
	}	
	
	
	

}
