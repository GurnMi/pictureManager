package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.MemberVO;

public interface MemberDAO {
	
	public void create(MemberVO vo) throws Exception;
	public MemberVO read(String userid) throws Exception;
	//public void update(MemberVO vo) throws Exception;
	//public void delete(String userid) throws Exception;
	//public List<MemberVO> listAll() throws Exception;
	
	
}
