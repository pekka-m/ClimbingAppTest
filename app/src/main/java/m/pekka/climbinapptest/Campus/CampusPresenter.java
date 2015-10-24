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

    public void addCampus() {
        try {
            this.campusInteractor.addCampus(Integer.parseInt(this.activityInterface.getInput()[0]));
            this.activityInterface.setResultMsg("Campus added to db.");
        } catch (NumberFormatException e) {
            this.activityInterface.setResultMsg("Input field error.");
        } catch (Exception e) {
            this.activityInterface.setResultMsg("Database error.");
        }
    }

    public void getCampusCount() {
        this.activityInterface.setResultMsg("Total campus workouts: " + this.campusInteractor.getCampusCount());
    }

    public void getTotalSteps() {
        this.activityInterface.setResultMsg("Total steps campused: " + Long.toString(campusInteractor.getTotalSteps()));
    }
}
