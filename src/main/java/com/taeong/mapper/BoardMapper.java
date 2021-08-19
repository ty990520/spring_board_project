package com.taeong.mapper;

import java.util.List;

import com.taeong.domain.BoardVO;
import com.taeong.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList();
	
	//페이징 처리 후 리스트 조회
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//insert
	public void insert(BoardVO board); 
	public void insertSelectKey(BoardVO board); 
	
	//read
	public BoardVO read(Long bno);
	
	//delete
	public int delete(Long bno);	//리턴타입이 int인 이유는 제대로 작업이 처리된 경우 1을 리턴하는지 확인하기 위함!
	
	//update
	public int update(BoardVO board);
	
	//count
	public int getTotalCount(Criteria cri);
	
}
