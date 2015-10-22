package m.pekka.climbinapptest.Campus;

import m.pekka.climbinapptest.IMainActivity;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class CampusPresenter {

    private IMainActivity iMainActivity;
    private CampusInteractor campusInteractor;

    public CampusPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        this.campusInteractor = new CampusInteractor(iMainActivity.getContext());
    }

    public void addCampus() {
        long id = this.campusInteractor.addCampus(this.iMainActivity.getInput());
        if (this.iMainActivity.getInput() != -1 && id != -1) {
            this.iMainActivity.setResultMsg("Campus added to db. ID: " + id);
        }
        else {
            this.iMainActivity.setResultMsg("Sum shite happened.... ");
        }
    }

    public void getTotalSteps() {
        this.iMainActivity.setResultMsg("Total steps campused: " + Long.toString(campusInteractor.getTotalSteps()));
    }
}
