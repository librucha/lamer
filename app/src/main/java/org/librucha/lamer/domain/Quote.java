package org.librucha.lamer.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "quote")
public class Quote {

  @DatabaseField(columnName = "id", generatedId = true, canBeNull = false)
  private Integer id;
  @DatabaseField(columnName = "text", canBeNull = false)
  private String text;

  public Quote() {
  }

  public Quote(String text) {
	this.text = text;
  }

  public Quote(Integer id, String text) {
	this.id = id;
	this.text = text;
  }

  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  public String getText() {
	return text;
  }

  public void setText(String text) {
	this.text = text;
  }

  @Override
  public String toString() {
	final StringBuilder sb = new StringBuilder("Quote{");
	sb.append("id=").append(id);
	sb.append(", text='").append(text).append('\'');
	sb.append('}');
	return sb.toString();
  }
}