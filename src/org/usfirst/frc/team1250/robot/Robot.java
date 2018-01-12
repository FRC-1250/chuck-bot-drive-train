//Def mine code :)
package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.RobotDrive;

public class Robot extends IterativeRobot {

	Joystick RightStick = new Joystick(0);
	Joystick LeftStick = new Joystick(1);
	
	RobotDrive RobotDrive;
	
	WPI_TalonSRX FrontRight;
	WPI_TalonSRX FrontLeft;
	WPI_TalonSRX BackRight;
	WPI_TalonSRX BackLeft;
		
	
	@Override
	public void robotInit() {
		
		FrontRight = new WPI_TalonSRX(10);
		BackLeft = new WPI_TalonSRX(11);
		SpeedControllerGroup right = new SpeedControllerGroup(FrontRight, BackRight);
		FrontLeft = new WPI_TalonSRX(12);
		BackLeft = new WPI_TalonSRX(13);
		SpeedControllerGroup left = new SpeedControllerGroup(FrontLeft, BackLeft);
		RobotDrive = new RobotDrive(right,left);

	}

	@Override
	public void teleopPeriodic() {
		RobotDrive.tankDrive(LeftStick.getY(), RightStick.getY());
		//RobotDrive.tankDrive(RightStick, LeftStick);
	}
}
