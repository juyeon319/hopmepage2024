package egovframework.let.temp4.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;

import egovframework.let.temp4.service.Temp4VO;

@Repository("temp4DAO")
public class Temp4DAO extends EgovAbstractMapper{
	
	//임시데이터 목록 가져오기
	public List<EgovMap> selectTempList(Temp4VO vo) throws Exception {
		return selectList("temp4DAO.selectTempList", vo);
	}
	
	//임시데이터 목록 수
	public int selectTempListCnt(Temp4VO vo) throws Exception {
		return selectOne("temp4DAO.selectTempListCnt", vo);
	}
	
	//임시데이터 가져오기
	public Temp4VO selectTemp(Temp4VO vo) throws Exception {
		return selectOne("temp4DAO.selectTemp", vo);
	}
	
	//임시데이터 등록
	public void insertTemp(Temp4VO vo) throws Exception {
		insert("temp4DAO.insertTemp", vo);
	}
	
	//임시데이터 수정
	public void updateTemp(Temp4VO vo) throws Exception {
		update("temp4DAO.updateTemp", vo);
	}
	
	//임시데이터 삭제
	public void deleteTemp(Temp4VO vo) throws Exception {
		delete("temp4DAO.deleteTemp",vo);
	}
}