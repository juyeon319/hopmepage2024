package egovframework.let.temp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;

@Service("temp2Service")
public class Temp2ServiceImpl extends EgovAbstractServiceImpl implements TempService{
	
	//DAO 연결
	@Resource(name = "temp2DAO")
	private Temp2DAO temp2DAO;
	
	@Resource(name = "egovTempIdGnrService")
	private EgovIdGnrService idgenSevice;
	
	//임시데이터 가져오기
	public TempVO selectTemp(TempVO vo) throws Exception {
		return temp2DAO.selectTemp(vo);
	}

	//임시데이터 목록 가져오기
	@Override
	public List<EgovMap> selectTempList(TempVO vo) throws Exception {
		return temp2DAO.selectTempList(vo);
	}

	//임시데이터 목록 수
	@Override
	public int selectTempListCnt(TempVO vo) throws Exception {
		return temp2DAO.selectTempListCnt(vo);
	}

	//임시데이터 등록하기
	@Override
	public String insertTemp(TempVO vo) throws Exception {
		String id = idgenSevice.getNextStringId();
		vo.setTempId(id);
		temp2DAO.insertTemp(vo);
		
		return id;
	}

	//임시데이터 수정하기
	@Override
	public void updateTemp(TempVO vo) throws Exception {
		temp2DAO.updateTemp(vo);
	}

	//임시데이터 삭제하기
	@Override
	public void deleteTemp(TempVO vo) throws Exception {
		temp2DAO.deleteTemp(vo);
	}
}
