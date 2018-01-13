package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;

public class Claw {
	

	public void collect() {
		RobotMap._LeftClaw.set(-.5);
		RobotMap._RightClaw.set(-.5);
	}
	public void dump() {
		RobotMap._LeftClaw.set(.5);
		RobotMap._RightClaw.set(.5);
	}
	public void stop() {
		RobotMap._LeftClaw.set(0);
		RobotMap._RightClaw.set(0);
	}
	public boolean isSeen() {
		return RobotMap._LaserSensClaw.get();
	}
		public boolean isIn() {
			return RobotMap._LaserSensClaw.get();
	}
}
