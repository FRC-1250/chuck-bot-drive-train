
package org.usfirst.frc.team1250.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	/* talons for arcade drive */
	WPI_TalonSRX _frontLeftMotor = new WPI_TalonSRX(14); 		/* device IDs here (1 of 2) */
	WPI_TalonSRX _frontRightMotor = new WPI_TalonSRX(15);

	/* extra talons for six motor drives */
	WPI_TalonSRX _leftSlave1 = new WPI_TalonSRX(10);
	WPI_TalonSRX _rightSlave1 = new WPI_TalonSRX(13);
	
	
	DifferentialDrive _drive = new DifferentialDrive(_frontLeftMotor, _frontRightMotor);
	
	Joystick _joy = new Joystick(0);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	double LeftStick = _joy.getY();
    	double RightStick = _joy.getThrottle(); 
    	_drive.tankDrive(LeftStick, RightStick);
    }
}
