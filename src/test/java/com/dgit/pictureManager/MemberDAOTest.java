package com.dgit.pictureManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.MemberVO;
import com.dgit.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testCreate() throws Exception{
		MemberVO vo=new MemberVO("test","이름", "비밀번호","이메일","전화번호");
		
		dao.create(vo);
		MemberVO vo1 = dao.read("id");
		System.out.println(vo1.toString());
	}
	
	
}
