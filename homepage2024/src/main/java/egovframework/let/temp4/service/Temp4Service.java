package egovframework.let.temp4.service;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;

public interface Temp4Service {

	//임시데이터 목록 가져오기
	public List<EgovMap> selectTempList(Temp4VO vo) throws Exception;
	
	//임시데이터 목록 수
	public int selectTempListCnt(Temp4VO vo) throws Exception;

	//임시데이터 가져오기
	public Temp4VO selectTemp(Temp4VO vo) throws Exception;
	
	//임시데이터 등록하기
	public String insertTemp(Temp4VO vo) throws Exception;

	//임시데이터 수정하기
	public void updateTemp(Temp4VO vo) throws Exception;
	
	//임시데이터 삭제하기
	public void deleteTemp(Temp4VO vo) throws Exception;
}