package com.taeong.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taeong.domain.BoardVO;
import com.taeong.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);

		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}

	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		log.info(board);
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();

		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("태옹");

		mapper.insert(board);

		log.info(board);
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();

		board.setTitle("새로 작성하는 글SelectKey");
		board.setContent("새로 작성하는 내용SelectKey");
		board.setWriter("태옹");

		mapper.insertSelectKey(board);

		log.info(board);
	}

	@Test
	public void testDelete() {
		log.info("DELETE COUNT : " + mapper.delete(5L));
	}

	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();

		// 실행 전 존재하는 번호인지 확인할 것!
		board.setBno(1L);
		board.setTitle("수정하는 글");
		board.setContent("수정된 내용");
		board.setWriter("태옹");

		log.info("UPDATE COUNT : " + mapper.update(board));
	}

	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("테스트");
		cri.setType("TC");
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
