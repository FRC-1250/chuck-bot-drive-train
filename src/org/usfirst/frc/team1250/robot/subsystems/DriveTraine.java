package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.commands.DriveTankWithJoystick;
/**
 *
 */
public class DriveTraine extends Subsystem {


	WPI_TalonSRX _frontLeftMotor  = RobotMap._frontLeftMotor;
	WPI_TalonSRX _frontRightMotor = RobotMap._frontRightMotor;
	WPI_TalonSRX _backLeftMotor   = RobotMap._backLeftMotor;
	WPI_TalonSRX _backRightMotor  = RobotMap._backRightMotor;
	
	private SpeedController m_leftMotor
	= new SpeedControllerGroup(_frontLeftMotor, _backLeftMotor);
	
	private SpeedController m_rightMotor
	= new SpeedControllerGroup(_frontRightMotor, _backRightMotor);
	
	private DifferentialDrive m_drive
	= new DifferentialDrive(m_leftMotor, m_rightMotor);

	
	public DriveTraine() {
		// Extends Subsystem class
		super();
	}
	
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveTankWithJoystick());
    }
    
    /**
	 * Tank style driving for the DriveTrain.
	 *
	 * @param left
	 *            Speed in range [-1,1]
	 * @param right
	 *            Speed in range [-1,1]
	 */
	public void drive(double left, double right) {
		m_drive.tankDrive(left, right);
	}

	/**
	 * Tank style driving for the DriveTrain.
	 *
	 * @param joy The ps3 style joystick to use to drive tank style.
	 */
	public void drive(Joystick joy) {
		drive(-joy.getY(), -joy.getThrottle());
	}
	
	
	public void log() {
		
	}
	
}

