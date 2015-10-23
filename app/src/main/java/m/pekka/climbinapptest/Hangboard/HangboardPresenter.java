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

    public void addHang(String time) {
        try {
            this.hangboardInteractor.addHang(Integer.parseInt(time));
            this.activityInterface.setResultMsg("Hang added to db.");
        } catch (NumberFormatException e) {
            this.activityInterface.setResultMsg("Input field error.");
        } catch (Exception e) {
            this.activityInterface.setResultMsg("Database error.");
        }
    }

    public void getHangboardCount() {
        this.activityInterface.setResultMsg("Total hangboard hangs: " + this.hangboardInteractor.getHangboardCount());
    }

    public void getTotalHang() {
        this.activityInterface.setResultMsg("Total time hanged: " + Long.toString(hangboardInteractor.getTotalHang()));
    }
}
