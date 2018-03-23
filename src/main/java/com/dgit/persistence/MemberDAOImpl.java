package com.dgit.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	private static final String namespace="com.dgit.mapper.MemberMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void create(MemberVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace+".create",vo);
	}

	@Override
	public MemberVO read(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", userid);
	}

}
