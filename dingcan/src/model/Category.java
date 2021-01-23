package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Category")
public class Category implements Serializable{


	private static final long serialVersionUID = -4350171000214458094L;

	private long id;
	
	private String catename;
	
	private int catelock;

	

	public int getCatelock() {
		return catelock;
	}

	public void setCatelock(int catelock) {
		this.catelock = catelock;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	
}
