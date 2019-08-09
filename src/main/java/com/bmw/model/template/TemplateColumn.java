package com.bmw.model.template;

public class TemplateColumn {
	private String label;
	private Integer marginLeft;
	private Integer marginRigth;
	private String fieldName;
	private Object data;
	private Integer type;

	public TemplateColumn() {
		this.type = Integer.valueOf(1);
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getMarginLeft() {
		return marginLeft;
	}
	public void setMarginLeft(Integer marginLeft) {
		this.marginLeft = marginLeft;
	}
	public Integer getMarginRigth() {
		return marginRigth;
	}
	public void setMarginRigth(Integer marginRigth) {
		this.marginRigth = marginRigth;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

}
