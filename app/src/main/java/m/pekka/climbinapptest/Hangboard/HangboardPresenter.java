package m.pekka.climbinapptest.Hangboard;

import android.util.Log;

import m.pekka.climbinapptest.ActivityInterface;

/**
 * Created by Pekka Melgin on 22.10.2015.
 */
public class HangboardPresenter {

    private ActivityInterface activityInterface;
    private HangboardInteractor hangboardInteractor;

    public HangboardPresenter(ActivityInterface activityInterface) {
        this.activityInterface = activityInterface;
        this.hangboardInteractor = new HangboardInteractor(activityInterface.getContext());
    }

    public void addHang(int time) {
        if (time == -1) {
            this.activityInterface.setResultMsg("Input field error");
        }
        else {
            long id = this.hangboardInteractor.addHang(time);
            if (id == -1) {
                this.activityInterface.setResultMsg("Sum shite happened...");
            }
            else {
                this.activityInterface.setResultMsg("Hang added to db.");
            }
        }
    }

    public void getHangboardCount() {
        this.activityInterface.setResultMsg("Total hangboard hangs: " + this.hangboardInteractor.getHangboardCount());
    }

    public void getTotalHang() {
        this.activityInterface.setResultMsg("Total time hanged: " + Long.toString(hangboardInteractor.getTotalHang()));
    }
}
