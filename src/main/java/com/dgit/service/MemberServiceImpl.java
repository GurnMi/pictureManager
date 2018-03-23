package com.dgit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.MemberVO;
import com.dgit.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public void regist(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		MemberVO vo1 = dao.read(vo.getUserid());
		if(vo1!=null){
			return;
		}else{
			dao.create(vo);
		}
		
	}

	@Override
	public MemberVO read(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(userid);
	}

}
