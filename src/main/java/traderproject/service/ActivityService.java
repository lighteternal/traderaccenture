package traderproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import traderproject.model.Activity;
import traderproject.model.Customer;
import traderproject.repo.ActivityRepo;
import traderproject.repo.CustomerRepo;

@Service("activityService")
@Transactional
public class ActivityService {

	@Autowired
	private ActivityRepo activityRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	public ActivityService(ActivityRepo activityRepo) {

		this.activityRepo = activityRepo;
	}

	public List<Activity> findAll() {

		return activityRepo.findAll();
	}

	public void save(Activity activity) {
		activityRepo.save(activity);
	}

	public void delete(int txid) {
		activityRepo.delete(txid);
	}

	public Activity findOne(Integer txID) {

		return activityRepo.findOne(txID);
	}

	public void updateActivity(Integer txID, Activity activity) {

		activityRepo.save(activity);

	}

	public List<Activity> findbyCustomerId(int customerID) {
		Customer cust = customerRepo.findOne(customerID);
		List<Activity> activ = cust.getAccount().getActivities();
		return activ;
	}

}
