package com.cmfspay.viewcollection.example.pieview;

import java.io.Serializable;

/**
 * @author zhang
 * @date 10/15/18
 * @desc
 */
public class PieBean implements Serializable {

	private String name;
	private float  value;
	private float  precent;

	private float angle = 0;
	private int   color = 0;

	public PieBean(String name, float value) {
		this.name = name;
		this.value = value;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getPrecent() {
		return precent;
	}

	public void setPrecent(float precent) {
		this.precent = precent;
	}

	@Override
	public String toString() {
		return "PieBean{" +
				"name='" + name + '\'' +
				", value=" + value +
				", precent=" + precent +
				'}';
	}
}
