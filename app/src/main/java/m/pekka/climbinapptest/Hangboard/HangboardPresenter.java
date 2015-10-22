package m.pekka.climbinapptest.Hangboard;

import m.pekka.climbinapptest.IMainActivity;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class HangboardPresenter {

    private IMainActivity iMainActivity;
    private HangboardInteractor hangboardInteractor;

    public HangboardPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        this.hangboardInteractor = new HangboardInteractor(iMainActivity.getContext());
    }

    public void addHang() {
        long id = this.hangboardInteractor.addHang(this.iMainActivity.getInput());
        if (this.iMainActivity.getInput() != -1 && id != -1) {
            this.iMainActivity.setResultMsg("Hang added to db. ID: " + id);
        }
        else {
            this.iMainActivity.setResultMsg("Sum shite happened.... ");
        }
    }

    public void getTotalHang() {
        this.iMainActivity.setResultMsg("Total time hanged: " + Long.toString(hangboardInteractor.getTotalHang()));
    }
}
