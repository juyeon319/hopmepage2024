package egovframework.let.temp4.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.fdl.idgnr.impl.EgovSequenceIdGnrServiceImpl;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import egovframework.let.temp4.service.Temp4Service;
import egovframework.let.temp4.service.Temp4VO;

@Service("temp4Service")
public class Temp4ServiceImpl extends EgovSequenceIdGnrServiceImpl implements Temp4Service{

	@Resource(name = "temp4DAO")
	private Temp4DAO temp4DAO;
	
	@Resource(name = "egovTempIdGnrService")
	private EgovIdGnrService idgenService;

	
	//임시데이터 목록 가져오기
	public List<EgovMap> selectTempList(Temp4VO vo) throws Exception {
		return temp4DAO.selectTempList(vo);
	}
	
	//임시데이터 목록 수
	public int selectTempListCnt(Temp4VO vo) throws Exception {
		return temp4DAO.selectTempListCnt(vo);
	}
	
	//임시데이터 가져오기
	public Temp4VO selectTemp(Temp4VO vo) throws Exception {
		return temp4DAO.selectTemp(vo);
	}
	
	//임시데이터 등록하기
	public String insertTemp(Temp4VO vo) throws Exception {
		String id = idgenService.getNextStringId();
		vo.setCrudId(id);
		temp4DAO.insertTemp(vo);
		
		return id;
	}
	
	//임시데이터 수정하기
	public void updateTemp(Temp4VO vo) throws Exception {
		temp4DAO.updateTemp(vo);
	}
	
	//임시데이터 삭제하기
	public void deleteTemp(Temp4VO vo) throws Exception {
		temp4DAO.deleteTemp(vo);
	}
}