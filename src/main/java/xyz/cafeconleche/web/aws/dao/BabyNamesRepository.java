package xyz.cafeconleche.web.aws.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import xyz.cafeconleche.web.aws.vo.BabyName;

@EnableScan
public interface BabyNamesRepository extends CrudRepository<BabyName, Integer> {

	BabyName findByName(String name);
	
}
