package m.pekka.climbinapptest.Campus;

import m.pekka.climbinapptest.ActivityInterface;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class CampusPresenter {

    private ActivityInterface activityInterface;
    private CampusInteractor campusInteractor;

    public CampusPresenter(ActivityInterface activityInterface) {
        this.activityInterface = activityInterface;
        this.campusInteractor = new CampusInteractor(activityInterface.getContext());
    }

    public void addCampus(int steps) {
        if (steps == -1) {
            this.activityInterface.setResultMsg("Input field error");
        }
        else {
            long id = this.campusInteractor.addCampus(steps);
            if (id == -1) {
                this.activityInterface.setResultMsg("Sum shite happened...");
            }
            else {
                this.activityInterface.setResultMsg("Campus added to db.");
            }

        }
    }

    public void getCampusCount() {
        this.activityInterface.setResultMsg("Total campus workouts: " + this.campusInteractor.getCampusCount());
    }

    public void getTotalSteps() {
        this.activityInterface.setResultMsg("Total steps campused: " + Long.toString(campusInteractor.getTotalSteps()));
    }
}
