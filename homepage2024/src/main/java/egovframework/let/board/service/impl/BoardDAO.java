package egovframework.let.board.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;

import egovframework.let.board.service.BoardVO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractMapper{

	//게시물 목록 가져오기
	public List<EgovMap> selectBoardList(BoardVO vo) throws Exception {
		return selectList("boardDAO.selectBoardList", vo);
	}
	
	//게시물 목록 수
	public int selectBoardListCnt(BoardVO vo) throws Exception {
		return selectOne("boardDAO.selectBoardListCnt", vo);
	}
	
	//게시물 상세정보
	public BoardVO selectBoard(BoardVO vo) throws Exception {
		return selectOne("boardDAO.selectBoard", vo);
	}
	
	//조회수 업
	public void updateViewCnt(BoardVO vo) throws Exception {
		update("boardDAO.updateViewCnt", vo);
	}
	
	//게시물 등록
	public void insertBoard(BoardVO vo) throws Exception {
		insert("boardDAO.insertBoard", vo);
	}
	
	//게시물 수정
	public void updateBoard(BoardVO vo) throws Exception {
		update("boardDAO.updateBoard", vo);
	}
	
	//게시물 삭제
	public void deleteBoard(BoardVO vo) throws Exception {
		update("boardDAO.deleteBoard", vo);
	}
}
