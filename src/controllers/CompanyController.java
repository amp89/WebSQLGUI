package controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.DBDAO;
import data.Results;

@Controller
public class CompanyController {
	DBDAO dao = new DBDAO();
	
	@RequestMapping("performQuery.do")
	public ModelAndView query(@RequestParam("query") String query){
		ModelAndView mv = new ModelAndView();
		System.out.println("QUERY PASSED IN: " + query);
		
		
		
		try{

		Results r = dao.doQuery(query);
		if( r.getColumns() != null){
			mv.addObject("results",r);
		}
		else{
			mv.addObject("results",r);
		}

		}catch(SQLException sqlException){
			mv.addObject("errorMessage",sqlException);
			sqlException.printStackTrace();
		}
		
		mv.setViewName("index.jsp");
		
		return mv;

	}
	/*
	 * stop try throwing
	 */

	
	

}
