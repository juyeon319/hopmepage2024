package egovframework.let.temp.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;

@Controller
public class TempController {
	
	@Resource(name = "tempService")
	private TempService tempService;
	
	@Resource(name = "temp2Service")
	private TempService temp2Service;
	
	//임시데이터 가져오기
	@RequestMapping(value = "/temp/select.do")
	public String select(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		TempVO result = temp2Service.selectTemp(tempVO);
		model.addAttribute("result", result);			//jsp도 동일해야함
		
		return "temp/TempSelect";						//jsp경로
	}
	
	//임시데이터 목록 가져오기
	@RequestMapping(value = "/temp/selectList.do")
	public String selectList(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		//List => java.util
		List<EgovMap> resultList = temp2Service.selectTempList(tempVO);
		model.addAttribute("resultList", resultList);	//jsp도 동일해야함
		
		int totCnt = temp2Service.selectTempListCnt(tempVO);
		model.addAttribute("totCnt", totCnt);
		
		return "temp/TempSelectList";					//jsp경로
	}
	
	//임시데이터 등록/수정
	@RequestMapping(value = "/temp/tempRegist.do")
	public String tempRegist(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		TempVO result = new TempVO();
//		egovframework.let.utl.fcc.service.EgovStringUtil
		if(!EgovStringUtil.isEmpty(tempVO.getTempId())) {
			result = temp2Service.selectTemp(tempVO);
		}
		
		model.addAttribute("result", result);
		
		return "temp/TempRegist";
	}
	
	//임시데이터 등록하기
	@RequestMapping(value = "/temp/insert.do")
	public String insert(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		temp2Service.insertTemp(tempVO);
		
		return "forward:/temp/selectList.do";
	}
	
	//임시데이터 수정하기
	@RequestMapping(value = "/temp/update.do")
	public String update(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		temp2Service.updateTemp(tempVO);
		
		return "forward:/temp/selectList.do";
	}
	
	//임시데이터 삭제하기
	@RequestMapping(value = "/temp/delete.do")
	public String delete(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		temp2Service.deleteTemp(tempVO);
		
		return "forward:/temp/selectList.do";
	}
	
	//JSTL
	@RequestMapping(value = "/temp/jstl.do")
	public String jstl(HttpServletRequest request, ModelMap model) throws Exception{
		
		return "/temp/Jstl";
	}
	
	//JSTL Import 용
	@RequestMapping(value = "/temp/jstlImport.do")
	public String jstlImport(TempVO tempVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		return "/temp/JstlImport";
	}
}
