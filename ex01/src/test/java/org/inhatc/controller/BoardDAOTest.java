package org.inhatc.controller;

import java.util.List;

import javax.inject.Inject;

import org.inhatc.domain.BoardVO;
import org.inhatc.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.inhatc.persistence.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class BoardDAOTest {

	@Inject
	private BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testCreate() throws Exception {

		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다. ");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("user00");

		dao.create(board);
	}

	@Test
	public void testRead() throws Exception {

		logger.info(dao.read(1).toString());
	}

	@Test
	public void testUpdate() throws Exception {

		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 글입니다.");
		board.setContent("수정 테스트");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception {

		dao.delete(1);
	}

	@Test
	public void testListCriteria() throws Exception {

		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);

		List<BoardVO> list = dao.listCriteria(cri);

		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}

	@Test
	public void testURI() throws Exception {

		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/board/read").queryParam("bno", 12)
				.queryParam("perPageNum", 20).build();

		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
}
