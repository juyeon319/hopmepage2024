package egovframework.let.temp4.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.string.EgovStringUtil;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp4.service.Temp4Service;
import egovframework.let.temp4.service.Temp4VO;

@Controller
public class Temp4Controller {

	@Resource(name = "temp4Service")
	private Temp4Service temp4Service;
	
	//임시데이터 목록 가져오기
	@RequestMapping(value = "/temp4/selectList.do")
	public String selectList(Temp4VO temp4VO, HttpServletRequest request, ModelMap model) throws Exception {
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(temp4VO.getPageIndex());
		paginationInfo.setRecordCountPerPage(temp4VO.getPageUnit());
		paginationInfo.setPageSize(temp4VO.getPageSize());
		
		temp4VO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		temp4VO.setLastIndex(paginationInfo.getLastRecordIndex());
		temp4VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<EgovMap> resultList = temp4Service.selectTempList(temp4VO);
		model.addAttribute("resultList", resultList);
		
		int totCnt = temp4Service.selectTempListCnt(temp4VO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		/*
		List<EgovMap> resultList = temp3Service.selectTempList(temp3VO);
		model.addAttribute("resultList", resultList);
		
		int totCnt = temp3Service.selectTempListCnt(temp3VO);
		model.addAttribute("totCnt", totCnt);
		*/
		
		return "temp4/TempSelectList";
	}
	
	//임시데이터 가져오기
	@RequestMapping(value = "/temp4/select.do")
	public String select(Temp4VO temp4VO, HttpServletRequest request, ModelMap model) throws Exception {
		Temp4VO result = temp4Service.selectTemp(temp4VO);
		model.addAttribute("result", result);
		return "temp4/TempSelect";
	}
	
	//임시데이터 등록/수정
	@RequestMapping(value = "/temp4/tempRegist.do")
	public String tempRegist(Temp4VO temp4VO, HttpServletRequest request, ModelMap model) throws Exception {
		Temp4VO result = new Temp4VO();
		if(!EgovStringUtil.isEmpty(temp4VO.getCrudId())) {
			result = temp4Service.selectTemp(temp4VO);
		}
		model.addAttribute("result", result);
		
		return "temp4/TempRegist";
	}

	//임시데이터 등록하기
	@RequestMapping(value = "/temp4/insert.do")
	public String insert(Temp4VO temp4VO, HttpServletRequest request, ModelMap model) throws Exception {
		temp4Service.insertTemp(temp4VO);
		return "forward:/temp4/selectList.do";
	}
	
	//임시데이터 수정하기
	@RequestMapping(value = "/temp4/update.do")
	public String update(Temp4VO temp4VO, HttpServletRequest request, ModelMap model) throws Exception {
		temp4Service.updateTemp(temp4VO);
		return "forward:/temp4/selectList.do";
	}
	
	//임시데이터 삭제하기
	@RequestMapping(value = "/temp4/delete.do")
	public String delete(Temp4VO temp4VO, HttpServletRequest request, ModelMap model) throws Exception {
		temp4Service.deleteTemp(temp4VO);
		return "forward:/temp4/selectList.do";
	}
}