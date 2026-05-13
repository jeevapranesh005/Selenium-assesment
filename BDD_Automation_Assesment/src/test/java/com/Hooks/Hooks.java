package com.Hooks;

import com.utilites.helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	helper init = new helper();
	
	@Before
	public void setup() {
		init.setup();
	}
	
	@After
	public void end() {
		init.end();
	}
}
