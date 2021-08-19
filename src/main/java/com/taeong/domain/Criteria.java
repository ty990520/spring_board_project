package com.taeong.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;	//페이징
	private int amount;		//페이징
	
	private String type;	//검색
	private String keyword;	//검색
	
	public Criteria(){		//페이징
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {	//페이징
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	/*여러개의 파라미터들을 연결해서 url형태로 만들어줌*/
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
		.queryParam("pageNum", this.getPageNum())
		.queryParam("amount", this.getAmount())
		.queryParam("type", this.getType())
		.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
		
	/*public String[] getTypeArr() {				//검색
		return type == null ? new String[] {}: type.split("");
	}*/
}
