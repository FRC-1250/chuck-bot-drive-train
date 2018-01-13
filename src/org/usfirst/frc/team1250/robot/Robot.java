
package org.usfirst.frc.team1250.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Command;


public class Robot extends IterativeRobot {


	WPI_TalonSRX _frontLeftMotor = new WPI_TalonSRX(14); 		
	WPI_TalonSRX _frontRightMotor = new WPI_TalonSRX(15);

	WPI_TalonSRX _leftSlave1 = new WPI_TalonSRX(10);
	WPI_TalonSRX _rightSlave1 = new WPI_TalonSRX(13);
	
	
	DifferentialDrive _drive = new DifferentialDrive(_frontLeftMotor, _frontRightMotor);
	
	Joystick _joy = new Joystick(0);

    public void robotInit() {

    }


    public void teleopPeriodic() {
    	double LeftStick = _joy.getY();
    	double RightStick = _joy.getThrottle(); 
    	_drive.tankDrive(LeftStick, RightStick);
    }
}
