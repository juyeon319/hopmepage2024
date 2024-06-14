package egovframework.let.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.fdl.idgnr.impl.EgovSequenceIdGnrServiceImpl;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl extends EgovSequenceIdGnrServiceImpl implements BoardService{

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;
	
	@Resource(name = "egovBoardIdGnrService")
	private EgovIdGnrService idgenService;

	//게시물 목록 가져오기
	public List<EgovMap> selectBoardList(BoardVO vo) throws Exception {
		return boardDAO.selectBoardList(vo);
	}

	//게시물 목록 수
	public int selectBoardListCnt(BoardVO vo) throws Exception {
		return boardDAO.selectBoardListCnt(vo);
	}

	//게시글 상세정보
	public BoardVO selectBoard(BoardVO vo) throws Exception {
		boardDAO.updateViewCnt(vo);
		return boardDAO.selectBoard(vo);
	}
	
}
