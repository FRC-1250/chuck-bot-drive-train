package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team1250.robot.RobotMap;
import org.usfirst.frc.team1250.robot.commands.DriveTankWithJoystick;
/**
 *
 */
public class DriveTraine extends Subsystem {

	WPI_TalonSRX fLeftMotor = new WPI_TalonSRX(RobotMap._frontLeftMotor);
	WPI_TalonSRX bLeftMotor = new WPI_TalonSRX(RobotMap._backLeftMotor);
	WPI_TalonSRX fRightMotor = new WPI_TalonSRX(RobotMap._frontRightMotor);
	WPI_TalonSRX bRightMotor = new WPI_TalonSRX(RobotMap._backRightMotor);
	
	
	private SpeedController m_leftMotor
	= new SpeedControllerGroup(fLeftMotor, bLeftMotor);
	
	private SpeedController m_rightMotor
	= new SpeedControllerGroup(fRightMotor, bRightMotor);
	
	private DifferentialDrive m_drive
	= new DifferentialDrive(m_leftMotor, m_rightMotor);
	
	 private Solenoid Solenoid0 = new Solenoid(1);


	 private Solenoid Solenoid1 = new Solenoid(2);

	
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
	
	public void setShift(boolean shift_bool) {

		if (shift_bool) {
			
			Solenoid0.set(true);
			Solenoid1.set(true);	
		}			
		else{
			Solenoid0.set(false);
			Solenoid1.set(false);
		}
	}
	
	public void toggleShift() {
		boolean curr_state = Solenoid0.get();
		
		Solenoid0.set(!curr_state);
		Solenoid1.set(!curr_state);
		
	}
	
	public boolean getShift() {
		return Solenoid0.get();
	}
	
	public void log() {
		
	}
	
	public int getRightRPM() {
		int velocity;
		velocity = fRightMotor.getSelectedSensorVelocity(0);
		return velocity;
	}
	
	public int getLeftRPM() {
		int velocity;
		velocity = fLeftMotor.getSelectedSensorVelocity(0);
		return velocity;
	}
}

