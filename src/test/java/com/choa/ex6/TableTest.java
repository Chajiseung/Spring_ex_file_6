package com.choa.ex6;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstractTest{
	
	@Inject
	private TableService tableService;

	@Test
	public void test() throws Exception{
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(4);
		tableADTO.setTitle("t3");
		tableADTO.setWriter("t3");
		int result = tableService.insertTable(tableADTO, 3);
		
		assertNotEquals(0, result);
	}

}
