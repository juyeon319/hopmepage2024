package egovframework.let.temp3.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import egovframework.let.temp3.service.Temp3Service;
import egovframework.let.temp3.service.Temp3VO;

@Service("temp3Service")
public class Temp3ServiceImpl extends EgovAbstractServiceImpl implements Temp3Service{
	
		@Resource(name = "temp3DAO")
		private Temp3DAO temp3DAO;
		
		@Resource(name = "egovTempIdGnrService")
		private EgovIdGnrService idgenSevice;
		
		//임시데이터 가져오기
		public Temp3VO selectTemp(Temp3VO vo) throws Exception {
			return temp3DAO.selectTemp(vo);
		}

		//임시데이터 목록 가져오기
		public List<EgovMap> selectTempList(Temp3VO vo) throws Exception {
			return temp3DAO.selectTempList(vo);
		}

		//임시데이터 목록 수
		public int selectTempListCnt(Temp3VO vo) throws Exception {
			return temp3DAO.selectTempListCnt(vo);
		}

		//임시데이터 등록하기
		public String insertTemp(Temp3VO vo) throws Exception {
			String id = idgenSevice.getNextStringId();
			vo.setTempId(id);
			temp3DAO.insertTemp(vo);
			
			return id;
		}

		//임시데이터 수정하기
		public void updateTemp(Temp3VO vo) throws Exception {
			temp3DAO.updateTemp(vo);
		}

		//임시데이터 삭제하기
		public void deleteTemp(Temp3VO vo) throws Exception {
			temp3DAO.deleteTemp(vo);
		}
}
