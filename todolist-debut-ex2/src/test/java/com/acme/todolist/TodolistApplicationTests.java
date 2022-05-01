package com.acme.todolist;


import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.acme.todolist.domain.TodoItem;

@SpringBootTest
class TodolistApplicationTests {
	
	private static TodoItem item;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test_isLate() {
		item = new TodoItem("test1", Instant.now().minus(2, ChronoUnit.DAYS), "test1");
		Assertions.assertTrue(item.finalContent().contains("[LATE!]"));
	}
	
	@Test
	public void test_isNotLate() {
		item = new TodoItem("test2", Instant.now(), "test2");
		Assertions.assertFalse(item.finalContent().contains("[LATE!]"));
	}
	

}
