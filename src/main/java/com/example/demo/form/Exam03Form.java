package com.example.demo.form;

public class Exam03Form {
	private Integer item1Price;
	private Integer item2Price;

	public Integer getItem1Price() {
		return item1Price;
	}

	public void setItem1Price(Integer item1Price) {
		this.item1Price = item1Price;
	}

	public Integer getItem2Price() {
		return item2Price;
	}

	public void setItem2Price(Integer item2Price) {
		this.item2Price = item2Price;
	}

	public Integer getItem3Price() {
		return item3Price;
	}

	public void setItem3Price(Integer item3Price) {
		this.item3Price = item3Price;
	}

	@Override
	public String toString() {
		return "Exam03Form [item1Price=" + item1Price + ", item2Price=" + item2Price + ", item3Price=" + item3Price
				+ "]";
	}

	private Integer item3Price;
}
