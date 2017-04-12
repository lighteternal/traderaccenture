package traderproject.repo;

import org.springframework.data.repository.CrudRepository;

import traderproject.model.Activity;

public interface ActivityRepo extends CrudRepository<Activity, Integer>{

}
