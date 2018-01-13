package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
public class Claw {
	

	public void collect() {
		new WPI_VictorSPX(RobotMap._LeftClaw).set(-.5);
		new WPI_VictorSPX(RobotMap._RightClaw).set(.5);
	}
	public void dump() {
		new WPI_VictorSPX(RobotMap._LeftClaw).set(-.5);
		new WPI_VictorSPX(RobotMap._RightClaw).set(.5);
	}
	public void stop() {
		new WPI_VictorSPX(RobotMap._LeftClaw).set(0);
		new WPI_VictorSPX(RobotMap._RightClaw).set(0);
	}
	public boolean isSeen() {
		return new DigitalInput(RobotMap._LaserSensClaw).get();
	}
		public boolean isIn() {
		return new DigitalInput(RobotMap._LightSensClaw).get();
	}
}
