package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.FileVO;

@Repository
public class FileDAOImpl implements FileDAO {

	private static final String namespace="com.dgit.mapper.MemberMapper";
	
	@Autowired
	private SqlSession session;
	
	
	@Override
	public void fileUpload(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".fileUpload", vo);
	}

	@Override
	public List<FileVO> fileList(String userid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".fileList",userid);
	}

	@Override
	public void fileDelete(String fullName) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace+".fileDelete",fullName);
	}

}
