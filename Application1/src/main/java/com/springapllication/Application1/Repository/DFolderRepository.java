package com.springapllication.Application1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springapllication.Application1.Model.Folder;
public interface DFolderRepository extends JpaRepository<Folder , Long> {

}
