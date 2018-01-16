package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;


public class Claw extends Subsystem {

	private WPI_VictorSPX LeftClaw = new WPI_VictorSPX(RobotMap._LeftClaw);
	private WPI_VictorSPX RightClaw = new WPI_VictorSPX(RobotMap._RightClaw);
	private Solenoid SoloRight = new Solenoid(RobotMap._SoloRight);
	private Solenoid SoloLeft = new Solenoid(RobotMap._SoloLeft);
	private Solenoid SoloLift = new Solenoid(RobotMap._SoloLift);
	private DigitalInput LightSens = new DigitalInput(RobotMap._LightSensClaw);
	private DigitalInput LaserSens = new DigitalInput(RobotMap._LaserSensClaw);
	private WPI_TalonSRX Test = new WPI_TalonSRX(RobotMap._Test);
	private DigitalInput LightSensTwo = new DigitalInput(RobotMap._LightSensClawTwo);
	
public Claw() {
	
}
	
	public void collect() {
		LeftClaw.set(-.5);
		RightClaw.set(.5);
	}
	public void dump() {
		LeftClaw.set(-.5);
		RightClaw.set(.5);
	}
	public void leftCollect() {
		LeftClaw.set(.5);
	}
	public void rightCollect() {
		RightClaw.set(-.5);
	}
	public void stopleftCollect() {
		LeftClaw.set(0);
	}
	public void stoprightCollect() {
		RightClaw.set(0);
	}
	public void stop() {
		LeftClaw.set(0);
		RightClaw.set(0);	
	}
	public void pinch() {
		SoloLeft.set(true);
		SoloRight.set(true);
	}
	public void unpinch() {
		SoloLeft.set(false);
		SoloRight.set(false);
	}
	public boolean CheckSoloClaw() {
		return SoloLeft.get();
	}
	public boolean isIn() {
		return LaserSens.get();
	}
	public boolean isSeenLeft() {
		return LightSens.get();
	}
	public boolean isSeenRight() {
		return LightSensTwo.get();
	}
	public void soloLiftPinch() {
		SoloLift.set(true);
	}
	public void soloLiftUnPinch() {
		SoloLift.set(false);
	}
	public void Spin() {
		Test.set(.3);
	}
	public void statusUpdate() {
		Test.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		System.out.println("Percent");
		System.out.println(Test.getMotorOutputPercent());
		System.out.println("Velocity");
		System.out.println(Test.getSelectedSensorVelocity(0));
	}
	

		@Override
		protected void initDefaultCommand() {
			
		}
}
