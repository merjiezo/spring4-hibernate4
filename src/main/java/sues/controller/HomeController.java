package sues.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;

import sues.Service.ContentService;
import sues.model.Content;

@Controller
@RequestMapping("/site")
public class HomeController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping({"/index","/"})
	public String homePage() {
		return "site/index";
	}
	
	@RequestMapping(value="/loginhandle", method=RequestMethod.POST)
	public String loginHandle(@RequestParam("row") String row, Model model) {
		System.out.println(row);
		List<Content> content = contentService.getContent(row);
		String str = content.get(0).getContents();
		System.out.println(str);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("site/success");
//		mv.addObject("row", str);
		model.addAttribute("contents", str);
		return "site/success";
	}
	
	@RequestMapping(value="/a")
	public void lalala(HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Content-type", "application/json");
		String str = "{\"merjiezo\":\"Is so cool\", \"success\":true}";
		PrintWriter pw = res.getWriter();
		pw.println(str);
		pw.close();
	}
}
