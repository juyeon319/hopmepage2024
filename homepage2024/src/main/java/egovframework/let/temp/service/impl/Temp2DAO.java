package egovframework.let.temp.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;
import org.stringtemplate.v4.compiler.CodeGenerator.region_return;

import egovframework.let.temp.service.TempVO;

@Repository("temp2DAO")
public class Temp2DAO extends EgovAbstractMapper{
	
	//임시데이터 가져오기
	public TempVO selectTemp(TempVO vo) throws Exception{
		//xml에 입력한 이름과 동일해야함
		return selectOne("temp2DAO.selectTemp", vo);
	}
	
	//임시데이터 목록 가져오기
	public List<EgovMap> selectTempList(TempVO vo) throws Exception{
		//xml에 입력한 이름과 동일해야함
		return selectList("temp2DAO.selectTempList", vo);
	}
	
	//임시데이터 목록 수 
	public int selectTempListCnt(TempVO vo) throws Exception{
		return selectOne("temp2DAO.selectTempListCnt", vo);
	}
	
	//임시데이터 등록하기
	public void insertTemp(TempVO vo) throws Exception{
		insert("temp2DAO.insertTemp", vo);
	}
	
	//임시데이터 수정하기
	public void updateTemp(TempVO vo) throws Exception{
		update("temp2DAO.updateTemp", vo);
	}
	
	//임시데이터 삭제하기 
	public void deleteTemp(TempVO vo) throws Exception{
		delete("temp2DAO.deleteTemp", vo);
	}
}
