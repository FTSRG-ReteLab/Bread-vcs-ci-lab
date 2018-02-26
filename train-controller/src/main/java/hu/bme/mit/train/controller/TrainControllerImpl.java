package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController {

	private int stepperChange = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 10;
	private int reverseSpeedLimit = 0;

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
	}

}
