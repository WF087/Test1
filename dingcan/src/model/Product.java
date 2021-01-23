package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 2429695896963809305L;

	private long id;
	
	private String name ;
	
	private String imgpath;
	
	private double price1;
	
	private double price2;
	
	private Date createtime;
	
	private Category cate; 
	
	private String info5;

	private int xiaoliang;
	
	private int newstuijian;
	
	private int productlock;

	public int getXiaoliang() {
		return xiaoliang;
	}

	public void setXiaoliang(int xiaoliang) {
		this.xiaoliang = xiaoliang;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@ManyToOne
	@JoinColumn(name="cateid")
	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

	public String getInfo5() {
		return info5;
	}

	public void setInfo5(String info5) {
		this.info5 = info5;
	}
	

	public double getPrice1() {
		return price1;
	}

	public void setPrice1(double price1) {
		this.price1 = price1;
	}

	public double getPrice2() {
		return price2;
	}

	public void setPrice2(double price2) {
		this.price2 = price2;
	}


	public int getNewstuijian() {
		return newstuijian;
	}

	public void setNewstuijian(int newstuijian) {
		this.newstuijian = newstuijian;
	}

	public int getProductlock() {
		return productlock;
	}

	public void setProductlock(int productlock) {
		this.productlock = productlock;
	}

}
