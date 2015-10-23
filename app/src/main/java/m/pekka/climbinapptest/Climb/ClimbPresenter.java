package m.pekka.climbinapptest.Climb;

import m.pekka.climbinapptest.ActivityInterface;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class ClimbPresenter {

    private ActivityInterface activityInterface;
    private ClimbInteractor climbInteractor;

    public ClimbPresenter(ActivityInterface activityInterface) {
        this.activityInterface = activityInterface;
        this.climbInteractor = new ClimbInteractor(activityInterface.getContext());
    }

    public void addClimb(String grade) {
        if (grade.equals("")) {
            this.activityInterface.setResultMsg("Input fields empty.");
        }
        else {
            long id = this.climbInteractor.addClimb(grade);
            if (id == -1) {
                this.activityInterface.setResultMsg("Sum shite happened.... ");
            } else {
                this.activityInterface.setResultMsg("Climb added to db.");
            }
        }
    }

    public void getClimbCount() {
        this.activityInterface.setResultMsg("Total climbs: " + this.climbInteractor.getClimbCount());
    }

    public void getClimb(int id) {

    }

    public void getAvgGrade() {
        this.activityInterface.setResultMsg("Average grade climbed: " + Long.toString(climbInteractor.getAvgGrade()));
    }
}
