package egovframework.let.temp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;

@Service("tempService")
public class TempServiceImpl extends EgovAbstractServiceImpl implements TempService{
	
	//DAO 연결
	@Resource(name = "tempDAO")
	private TempDAO tempDAO;
	
	//임시데이터 가져오기
	public TempVO selectTemp(TempVO vo) throws Exception {
		return tempDAO.selectTemp(vo);
	}

	//임시데이터 목록 가져오기
	@Override
	public List<EgovMap> selectTempList(TempVO vo) throws Exception {
		return tempDAO.selectTempList(vo);
	}

	//임시데이터 목록 수
	@Override
	public int selectTempListCnt(TempVO vo) throws Exception {
		return tempDAO.selectTempListCnt(vo);
	}

	//임시데이터 등록하기
	@Override
	public String insertTemp(TempVO vo) throws Exception {
		tempDAO.insertTemp(vo);
		return null;
	}

	//임시데이터 수정하기
	@Override
	public void updateTemp(TempVO vo) throws Exception {
		tempDAO.updateTemp(vo);
	}

	//임시데이터 삭제하기
	@Override
	public void deleteTemp(TempVO vo) throws Exception {
		tempDAO.deleteTemp(vo);
	}
}
