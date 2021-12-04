package model;
//直列化
import java.io.Serializable;

public class Book implements Serializable{
	private int id;
	private String title;
	private String body;
	
	public Book() {}
	public Book(String title, String body) {
		this.title = title;
		this.body = body;
	}
	public Book(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public int getId() {return id;}
	public String getTitle() {return title;}
	public String getBody() {return body;}
}
