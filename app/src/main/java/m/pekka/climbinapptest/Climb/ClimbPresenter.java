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

    public void addClimb() {
        try {
            String[] input = this.activityInterface.getInput();
            if (input[0].equals("") || this.climbInteractor.addClimb(input) == -1) {
                this.activityInterface.setResultMsg("Input field error.");
            }
            else {
                this.activityInterface.setResultMsg("Climb added to db.");
            }
        }
        catch (Exception e) {
            this.activityInterface.setResultMsg("Database error.");
        }
    }

    public void getClimbCount() {
        this.activityInterface.setResultMsg("Total climbs: " + this.climbInteractor.getClimbCount());
    }

    public void getAvgGrade() {
        this.activityInterface.setResultMsg("Average grade climbed: " + this.climbInteractor.getAvgGrade());
    }
}
