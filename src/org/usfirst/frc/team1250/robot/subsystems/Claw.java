package org.usfirst.frc.team1250.robot.subsystems;

import org.usfirst.frc.team1250.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Claw extends Subsystem {

	private WPI_VictorSPX LeftClaw = new WPI_VictorSPX(RobotMap._LeftClaw);
	private WPI_VictorSPX RightClaw = new WPI_VictorSPX(RobotMap._RightClaw);
	private Solenoid SoloRight = new Solenoid(RobotMap._SoloRight);
	private Solenoid SoloLeft = new Solenoid(RobotMap._SoloLeft);
	private Solenoid SoloLift = new Solenoid(RobotMap._SoloLift);
	private DigitalInput LightSens = new DigitalInput(RobotMap._LightSensClaw);
	private DigitalInput LaserSens = new DigitalInput(RobotMap._LaserSensClaw);
	
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
	public boolean isSeen() {
		return LaserSens.get();
	}
	public boolean isIn() {
		return LightSens.get();
	}
	public void soloLiftPinch() {
		SoloLift.set(true);
	}
	public void soloLiftUnPinch() {
		SoloLift.set(false);
	}
	

		@Override
		protected void initDefaultCommand() {

			
		}
}
