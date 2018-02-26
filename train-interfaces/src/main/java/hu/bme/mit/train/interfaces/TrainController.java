package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setReverseSpeedLimit(int reverseSpeedLimit);

	void setJoystickPosition(int joystickPosition);

}
