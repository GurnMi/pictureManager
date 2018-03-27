package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.FileVO;

public interface FileDAO {
	public void fileUpload(FileVO vo) throws Exception;
	public List<FileVO> fileList(String userid) throws Exception;
	public void fileDelete(String fullName) throws Exception;
}
