package traderproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import traderproject.model.Activity;

@Repository("activityRepo")
public interface ActivityRepo extends JpaRepository<Activity, Integer> {
	
//	@EntityGraph(value = "Activity.basic", type=EntityGraphType.LOAD)
//    @Override
//    List<Activity> findAll();
//
}