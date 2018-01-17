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

import java.lang.Math;
/**
 *
 */
public class DriveTraine extends Subsystem {

	WPI_TalonSRX fLeftMotor = new WPI_TalonSRX(RobotMap._frontLeftMotor);
	WPI_TalonSRX bLeftMotor = new WPI_TalonSRX(RobotMap._backLeftMotor);
	WPI_TalonSRX fRightMotor = new WPI_TalonSRX(RobotMap._frontRightMotor);
	WPI_TalonSRX bRightMotor = new WPI_TalonSRX(RobotMap._backRightMotor);
	
///	
	private SpeedController m_leftMotor
	= new SpeedControllerGroup(fLeftMotor, bLeftMotor);
	
	private SpeedController m_rightMotor
	= new SpeedControllerGroup(fRightMotor, bRightMotor);
	
	private DifferentialDrive m_drive
	= new DifferentialDrive(m_leftMotor, m_rightMotor);
	
	 private Solenoid Solenoid0 = new Solenoid(1);
	 private Solenoid Solenoid1 = new Solenoid(2);

 ///
	 
	 private static char kShiftState = 'l';
	 private final int kHighRPMThresh= 1000;
	 private final int kLowRPMThresh = 500;

	private int rRPM = 0;
	private int lRPM =  0;
	private float lJoy = 0;
	private float rJoy = 0;
	private static boolean joyCompare = false;
	private static boolean rpmCompare = false;
	
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
	
	private int getRightRPM() {
		int velocity;
		velocity = fRightMotor.getSelectedSensorVelocity(0);
		return velocity;
	}
	
	private int getLeftRPM() {
		int velocity;
		velocity = fLeftMotor.getSelectedSensorVelocity(0);
		return velocity;
	}
	
	public char getState(Joystick joy, char state) {
		
		rRPM = getRightRPM();
		lRPM =  getLeftRPM();
		lJoy = (float)-joy.getY();
		rJoy = (float)-joy.getThrottle();
		
		
		// Signs of the inputs
		//int lJoySign = (int)Math.signum(lJoy);
		//int rJoySign = (int)Math.signum(rJoy);
//		int lRPMSign = (int)Math.signum(lRPM);
//		int rRPMSign = (int)Math.signum(rRPM);
		
		
		// Check for joystick direction change and RPM Change
		joyCompare = ((int)Math.signum(lJoy) != (int)Math.signum(rJoy));
		rpmCompare = ((int)Math.signum(lRPM) != (int)Math.signum(rRPM));
		
		if (joyCompare || rpmCompare) {	
			return 'l';		
		}
		else if(state == 'h' && (rRPM< kLowRPMThresh || lRPM<kLowRPMThresh )) {
			return 'l';
		}
		else if (rRPM > kHighRPMThresh && lRPM > kHighRPMThresh && state == 'l') {
			return 'h';
		}
		 else  {
			return state;
		} 
		
		
		
	}
	
}

