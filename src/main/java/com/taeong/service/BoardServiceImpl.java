package com.taeong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taeong.domain.BoardVO;
import com.taeong.domain.Criteria;
import com.taeong.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("[SERVICE]register..."+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("[SERVICE]get..."+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("[SERVICE]modify..."+board);
		return mapper.update(board)==1;	//update()의 반환형은 int이기 때문에!
	}

	@Override
	public boolean remove(Long bno) {
		log.info("[SERVICE]remove..."+bno);
		return mapper.delete(bno)==1;
	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("[SERVICE]getList..."+cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
}
