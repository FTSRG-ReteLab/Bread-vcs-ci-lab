package hu.bme.mit.train.controller;

import hu.bme.mit.train.Tachograph;
import hu.bme.mit.train.interfaces.TrainController;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TrainControllerImpl implements TrainController {

	private int stepperChange = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 10;
	private int reverseSpeedLimit = 0;

	private Tachograph tachograph = new Tachograph();
	private Timer timer = new Timer();

	@Override
	public void followSpeed() {
		if (referenceSpeed < reverseSpeedLimit) {
			referenceSpeed = reverseSpeedLimit;
		} else {
			if(referenceSpeed+stepperChange > reverseSpeedLimit) {
				referenceSpeed += stepperChange;
			} else {
				referenceSpeed = reverseSpeedLimit;
			}
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();

	}

	@Override
	public void setReverseSpeedLimit(int reverseSpeedLimit) {
		this.reverseSpeedLimit = reverseSpeedLimit;
		enforceSpeedLimit();

	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		} else if (referenceSpeed < reverseSpeedLimit){
			referenceSpeed = reverseSpeedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.stepperChange = joystickPosition;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                followSpeed();
            }
        }, 200);

		tachograph.addToTable(Calendar.getInstance().getTime().toString(),
				String.valueOf(joystickPosition),
				String.valueOf(referenceSpeed));
	}



}
