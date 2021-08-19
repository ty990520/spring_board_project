package com.taeong.service;

import static org.junit.Assert.assertNotNull;

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
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@Test	//의존성 주입 확인
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

	@Test	//글 등록
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("태옹");

		service.register(board);
		log.info("생성된 게시물의 번호: " + board.getBno());
	}

	@Test // 리스트 조회
	public void testGetList() {
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}

	@Test // 글 조회
	public void testGet() {
		log.info(service.get(1L));
	}

	@Test	//글 삭제
	public void testDelete() {
		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT: " + service.remove(2L));
	}

	@Test	//글 수정
	public void testUpdate() {
		BoardVO board = service.get(6L);
		if (board == null) {
			return;
		}
		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}
}
