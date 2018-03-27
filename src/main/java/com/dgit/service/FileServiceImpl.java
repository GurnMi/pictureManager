package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.FileVO;
import com.dgit.persistence.FileDAO;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private FileDAO dao;
	
	
	@Override
	public void fileUpload(FileVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.fileUpload(vo);
	}

	@Override
	public List<FileVO> fileList(String userid) throws Exception {
		// TODO Auto-generated method stub
		return dao.fileList(userid);
	}

	@Override
	public void fileDelete(String fullName) throws Exception {
		// TODO Auto-generated method stub
		dao.fileDelete(fullName);
	}

}
