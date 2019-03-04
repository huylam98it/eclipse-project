package com.example.upload_download_file.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.upload_download_file.model.File;

@Repository("fileDao")
public interface FileDao extends JpaRepository<File, Integer> {

	@Query("select f from File f where f.nameFile = :name")
	public File getFileByName(@Param("name") String name);
}
