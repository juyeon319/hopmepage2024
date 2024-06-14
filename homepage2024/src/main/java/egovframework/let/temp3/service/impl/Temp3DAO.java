package egovframework.let.temp3.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;

import egovframework.let.temp3.service.Temp3VO;

@Repository("temp3DAO")
public class Temp3DAO extends EgovAbstractMapper{
	
	//임시데이터 가져오기
	public Temp3VO selectTemp(Temp3VO vo) throws Exception{
		return selectOne("temp3DAO.selectTemp", vo);
	}
	
	//임시데이터 목록 가져오기
	public List<EgovMap> selectTempList(Temp3VO vo) throws Exception{
		return selectList("temp3DAO.selectTempList", vo);
	}
	
	//임시데이터 목록 수 
	public int selectTempListCnt(Temp3VO vo) throws Exception{
		return selectOne("temp3DAO.selectTempListCnt", vo);
	}
	
	//임시데이터 등록하기
	public void insertTemp(Temp3VO vo) throws Exception{
		insert("temp3DAO.insertTemp", vo);
	}
	
	//임시데이터 수정하기
	public void updateTemp(Temp3VO vo) throws Exception{
		update("temp3DAO.updateTemp", vo);
	}
	
	//임시데이터 삭제하기 
	public void deleteTemp(Temp3VO vo) throws Exception{
		delete("temp3DAO.deleteTemp", vo);
	}
}
