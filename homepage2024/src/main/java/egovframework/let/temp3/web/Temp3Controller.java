package egovframework.let.temp3.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp3.service.Temp3Service;
import egovframework.let.temp3.service.Temp3VO;
import egovframework.let.utl.fcc.service.EgovStringUtil;

	@Controller 
	public class Temp3Controller {
	
	@Resource(name="temp3Service") 
	private Temp3Service temp3Service;
	
	//임시데이터 목록 가져오기
	@RequestMapping(value="/temp3/selectList.do")
	public String selectList(Temp3VO temp3VO, HttpServletRequest request, ModelMap model)throws Exception{
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(temp3VO.getPageIndex());
		paginationInfo.setRecordCountPerPage(temp3VO.getPageUnit());
		paginationInfo.setPageSize(temp3VO.getPageSize());
		
		temp3VO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		temp3VO.setRecordCountPerPage(paginationInfo.getLastRecordIndex());
		temp3VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<EgovMap> resultList = temp3Service.selectTempList(temp3VO);
		model.addAttribute("resultList",resultList);
		
		int totCnt = temp3Service.selectTempListCnt(temp3VO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo",paginationInfo);
		
		return "temp3/TempSelectList";
		/*
		List<EgovMap> resultList = temp3Service.selectTempList(temp3VO);
		model.addAttribute("resultList",resultList);
		
		int totCnt = temp3Service.selectTempListCnt(temp3VO);
		model.addAttribute("totCnt", totCnt);
		*/
	}	
	
	//임시데이터 가져오기
	@RequestMapping(value="/temp3/select.do")
	public String select(Temp3VO temp3VO, HttpServletRequest request, ModelMap model)throws Exception{
		Temp3VO result = temp3Service.selectTemp(temp3VO);
		model.addAttribute("result",result);
		return "temp3/TempSelect";
	}
	
	//임시데이터 등록/수정
	@RequestMapping(value="/temp3/tempRegist.do")
	public String tempRegist(Temp3VO temp3VO, HttpServletRequest request, ModelMap model)throws Exception{
		Temp3VO result = new Temp3VO();
		if(!EgovStringUtil.isEmpty(temp3VO.getTempId())){
			result = temp3Service.selectTemp(temp3VO);
		}
		model.addAttribute("result",result);
		
		return "temp3/TempRegist";
	}
	
	//임시데이터 등록하기
	@RequestMapping(value="/temp3/insert.do")
	public String insert(Temp3VO temp3VO,HttpServletRequest request, ModelMap model)throws Exception{
		temp3Service.insertTemp(temp3VO);
		return "forward:/temp3/selectList.do";
	}
	
	//임시데이터 수정하기
	@RequestMapping(value="/temp3/update.do")
	public String update(Temp3VO temp3VO,HttpServletRequest request, ModelMap model)throws Exception{
		temp3Service.updateTemp(temp3VO);
		return "forward:/temp3/selectList.do";
	}
	
	//임시데이터 삭제하기
	@RequestMapping(value="/temp3/delete.do")
	public String delete(Temp3VO temp3VO,HttpServletRequest request, ModelMap model)throws Exception{
		temp3Service.deleteTemp(temp3VO);
		return "forward:/temp3/selectList.do";
	}
}
