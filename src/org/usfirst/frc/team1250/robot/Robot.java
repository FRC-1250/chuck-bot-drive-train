//Def mine code :)
package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Robot extends IterativeRobot {
	private DifferentialDrive m_myRobot;
	private Joystick m_leftStick;
	private Joystick m_rightStick;
	
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
		
		m_myRobot = new DifferentialDrive(right, left);
		m_leftStick = new Joystick(0);
		m_rightStick = new Joystick(1);
	}

	@Override
	public void teleopPeriodic() {
		m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
	}
}
