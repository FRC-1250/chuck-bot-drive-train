package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import org.usfirst.frc.team1250.robot.commands.PassiveClawCollect;;

public class Claw extends Subsystem {
//All components defined (Numbers from robot map)
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
	//Runs motors on claw to collect
	public void collect() {
		LeftClaw.set(-.5);
		RightClaw.set(.5);
	}
	//Runs motors on claw to dump
	public void dump() {
		LeftClaw.set(-.5);
		RightClaw.set(.5);
	}
	//Runs motors on left side to collect
	public void leftCollect() {
		LeftClaw.set(.5);
	}
	//Runs motors on right side to collect
	public void rightCollect() {
		RightClaw.set(-.5);
	}
	//Stops motors on left side
	public void stopleftCollect() {
		LeftClaw.set(0);
	}
	//Stops motors on right side
	public void stoprightCollect() {
		RightClaw.set(0);
	}
	//Stops the claw motors
	public void stop() {
		LeftClaw.set(0);
		RightClaw.set(0);	
	}
	//Activates the solenoids to pinch
	public void pinch() {
		SoloLeft.set(true);
		SoloRight.set(true);
	}
	//Deactivates solenoids to unpinch
	public void unpinch() {
		SoloLeft.set(false);
		SoloRight.set(false);
	}
	//Checks solenoid state (Return Bool)
	public boolean CheckSoloClaw() {
		return SoloLeft.get();
	}
	//Checks sensor state (Return Bool)
	public boolean isIn() {
		return LaserSens.get();
	}
	//Checks sensor state (Return Bool)
	public boolean isSeenLeft() {
		return LightSens.get();
	}
	//Checks sensor state (Return Bool)
	public boolean isSeenRight() {
		return LightSensTwo.get();
	}
	//Pinches lift solenoid
	public void soloLiftPinch() {
		SoloLift.set(true);
	}
	//Unpinches lift solenoid
	public void soloLiftUnPinch() {
		SoloLift.set(false);
	}
	//Test
	public void Spin() {
		Test.set(.3);
	}
	//Test
	public void statusUpdate() {
		Test.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		System.out.println("Percent");
		System.out.println(Test.getMotorOutputPercent());
		System.out.println("Velocity");
		System.out.println(Test.getSelectedSensorVelocity(0));
	}
	

		@Override
		protected void initDefaultCommand() {
			setDefaultCommand(new PassiveClawCollect());
		}
}
