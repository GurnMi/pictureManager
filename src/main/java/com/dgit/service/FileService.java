package com.dgit.service;

import java.util.List;

import com.dgit.domain.FileVO;

public interface FileService {
	public void fileUpload(FileVO vo) throws Exception;
	public List<FileVO> fileList(String userid) throws Exception;
	public void fileDelete(String fullName) throws Exception;
}
