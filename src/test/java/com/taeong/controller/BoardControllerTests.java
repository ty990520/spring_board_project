package com.taeong.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		log.info("[CONTROLLER]testList : " + mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum","2")
				.param("amount","50")
				//.param(name, values)
				)
		.andReturn()
		.getModelAndView()
		.getModelMap());
	}

	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register")
						.param("title", "테스트 새글 제목")
						.param("content", "테스트 새글 내용")
						.param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
		log.info("결과페이지 경로 : "+resultPage);
	}
	
	@Test	//조회하는 경우는 다 GET방식이라고 생각할 것
	public void testGet() throws Exception {
		log.info("get테스트를 진행합니다..."+
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc
			.perform(MockMvcRequestBuilders.post("/board/modify")
			.param("bno", "1")
			.param("title", "수정된 테스트 새글 제목")
			.param("content", "수정된 테스트 새글 내용")
			.param("writer", "user00"))
			.andReturn().getModelAndView().getViewName();
		log.info("결과페이지 경로 : "+resultPage);
	}
	
	@Test
	public void testRemove() throws Exception {
	// 삭제전 데이터베이스에 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "2"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		log.info("결과페이지 경로 : "+resultPage);
	}
}
