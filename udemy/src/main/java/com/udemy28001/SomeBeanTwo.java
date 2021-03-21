package com.udemy28001;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanTwoFilter")
//@JsonIgnoreProperties(value= {"field1"}) // static filtering
public class SomeBeanTwo {
	
	private int field1;
	private int field2;
	//@JsonIgnore //will not show
	private int field3;
	public SomeBeanTwo(int string, int string2, int string3) {
		super();
		this.field1 = string;
		this.field2 = string2;
		this.field3 = string3;
	}
	public int getField1() {
		return field1;
	}
	public void setField1(int field1) {
		this.field1 = field1;
	}
	public int getField2() {
		return field2;
	}
	public void setField2(int field2) {
		this.field2 = field2;
	}
	public int getField3() {
		return field3;
	}
	public void setField3(int field3) {
		this.field3 = field3;
	}

}
