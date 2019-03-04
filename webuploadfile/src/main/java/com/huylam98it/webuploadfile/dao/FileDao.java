package com.huylam98it.webuploadfile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huylam98it.webuploadfile.model.Fileupload;

@Repository("fileDao")
public interface FileDao extends JpaRepository<Fileupload, Integer> {

}
