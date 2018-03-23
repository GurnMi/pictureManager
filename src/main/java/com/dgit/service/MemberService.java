package com.dgit.service;

import com.dgit.domain.MemberVO;

public interface MemberService {
	public void regist(MemberVO vo) throws Exception;
	public MemberVO read(String userid)  throws Exception;
}
