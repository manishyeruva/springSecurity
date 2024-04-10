package com.springSecurity.springSecurityImplementation.repository;

import java.util.List;

import com.springSecurity.springSecurityImplementation.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
	@Query(value = "SELECT *\n" +
			"FROM notice_details\n" +
			"WHERE CURRENT_DATE BETWEEN notic_beg_dt AND notic_end_dt;\n",nativeQuery = true)
	List<Notice> findAllActiveNotices();

}
