package com.a5a5lab.module.common.fileuploaded;

import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadedDao {
	
	public int insertUploaded(FileUploadedDto dto);

}
