package m.pekka.climbinapptest.Climb;

import m.pekka.climbinapptest.IMainActivity;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class ClimbPresenter {

    private IMainActivity iMainActivity;
    private ClimbInteractor climbInteractor;

    public ClimbPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        this.climbInteractor = new ClimbInteractor(iMainActivity.getContext());
    }

    public void addClimb() {
        long id = this.climbInteractor.addClimb(this.iMainActivity.getInput());
        if (this.iMainActivity.getInput() != -1 && id != -1) {
            this.iMainActivity.setResultMsg("Climb added to db. ID: " + id);
        }
        else {
            this.iMainActivity.setResultMsg("Sum shite happened.... ");
        }
    }

    public void getAvgGrade() {
        this.iMainActivity.setResultMsg("Average grade climbed: " + Long.toString(climbInteractor.getAvgGrade()));
    }
}
