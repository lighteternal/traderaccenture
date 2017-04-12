package traderproject.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import traderproject.model.Activity;
import traderproject.repo.ActivityRepo;

@Service
@Transactional
public class ActivityService {
	private final ActivityRepo activityRepo;

	public ActivityService(ActivityRepo activityRepo) {

		this.activityRepo = activityRepo;
	}

	

	public void save(Activity activity) {
		activityRepo.save(activity);
	}

	public void delete(int id) {
		activityRepo.delete(id);
	}

	
}
