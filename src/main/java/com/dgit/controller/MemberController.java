package com.dgit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dgit.domain.FileVO;
import com.dgit.domain.MemberVO;
import com.dgit.service.FileService;
import com.dgit.service.MemberService;
import com.dgit.util.MediaUtils;
import com.dgit.util.UploadFileUtils;

@Controller
@RequestMapping("/member/*")	
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	

	@Resource(name="uploadPath")
	private String outUploadPath;
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private FileService fileService;
	
	
	@RequestMapping("/home")
	public String home(HttpServletRequest req, Model model) throws Exception{
		logger.info("home");
		
		HttpSession session = req.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		if(vo!=null){
			List<FileVO> filelist = fileService.fileList(vo.getUserid());
						
			model.addAttribute("filelist", filelist);
		}
		return "/member/home";
	}
	
	@RequestMapping("/logoutHome")
	public String logouthome(HttpServletRequest req, Model model) throws Exception{
		logger.info("home");
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/member/home";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(){
		logger.info("join");
		return "/member/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(MemberVO vo) throws Exception{
		logger.info("register POST");
		System.out.println(vo.getUserid());
		
		service.regist(vo);
		return "redirect:/member/home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		logger.info("login");
		return "/member/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method=RequestMethod.GET)
	public ResponseEntity<String> idCheck(String id) throws Exception{
		logger.info("login join");
		ResponseEntity<String> entity =null;
		
		MemberVO vo = service.read(id);
		if(vo==null){
			entity = new ResponseEntity<String>("false",HttpStatus.OK);
		}else{
			entity = new ResponseEntity<String>("true",HttpStatus.OK);
		}
		return entity;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpServletRequest req, Model model) throws Exception{
		logger.info("login POST");
		
		MemberVO member = service.read(vo.getUserid());
		
		HttpSession session = req.getSession();
		
		if(member!=null){
			if(member.getUserpw().equals(vo.getUserpw())){
				System.out.println(member.toString());
				session.setAttribute("member", member);
				System.out.println("=============");
				
				
				
				return "redirect:/member/home";
			}
			model.addAttribute("error", "password");
			return "/member/login";
		}else{
			model.addAttribute("error", "id");
			return "/member/login";	
		}					
	}
	
	@RequestMapping(value="/uploadPreviewForm",method=RequestMethod.GET)
	public String uploadPreviewForm(HttpServletRequest req){
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		System.out.println(vo);
		
		return "/member/uploadPreviewForm";
	}
	
	
	@RequestMapping(value="/uploadPreview",method=RequestMethod.POST)
	public String uploadPreviewResult(HttpServletRequest req, List<MultipartFile> file, Model model) throws Exception{
		logger.info("[uploadPreview] POST");
		//logger.info("userid : " +userid);
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("member");
		
		String userid = vo.getUserid();
		Date date = new Date();
		
		FileVO filevo = new FileVO();
		
		filevo.setUserid(userid);
		//filevo.setRegdate(date);
				
		for(MultipartFile files : file){
			logger.info(files.getOriginalFilename());
		}
		
		ResponseEntity<String> entity =null;  		
		
		File dirPath = new File(outUploadPath);
		
		if(dirPath.exists()==false){
			dirPath.mkdirs();
		}
		List<String> list= new ArrayList<>();
		
		try {
			for(MultipartFile files : file){
				String savedName = UploadFileUtils.uploadFile(outUploadPath, 
						files.getOriginalFilename(), 
						files.getBytes());		
				list.add(savedName);
				System.out.println(savedName);
				filevo.setFullName(savedName);
				
				fileService.fileUpload(filevo);
			}
			
			entity = new ResponseEntity<String>("succece",HttpStatus.OK);
						
			//model.addAttribute("writer", user);
			
			//model.addAttribute("filename", list);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		//return entity;		
		return "redirect:/member/home";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/displayFile",method=RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		logger.info("[displayfile]" +filename);
		
		try {
			String formatName = filename.substring(filename.lastIndexOf(".")+1);
			MediaType type = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(type);
			
			in = new FileInputStream(outUploadPath+filename);
			
			entity = new ResponseEntity<>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

	@RequestMapping(value="/deleteFile",method=RequestMethod.GET)
	public String deleteFile(String filename){
		ResponseEntity<String> entity =null;
		logger.info("deleteFile : " + filename);
				
		try {
			
			System.gc();
						
			//Thumbnail 삭제
			File file = new File(outUploadPath+filename);
			file.delete();
			
			System.gc();
			String s1= filename.substring(0,12);
			String s2 = filename.substring(14);
			//System.out.println(s1+s2);
			
			//원본 삭제
			File file1 = new File(outUploadPath+s1+s2);
			file1.delete();
			
			fileService.fileDelete(filename);
			
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST);
		}
		return "redirect:/member/home";
		//return entity;
	}
	
}
