package org.usfirst.frc.team1250.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.*;
import org.usfirst.frc.team1250.robot.RobotMap;
/**
 *
 */
public class DriveTraine extends Subsystem {


	WPI_TalonSRX _frontLeftMotor  = RobotMap._frontLeftMotor;
	WPI_TalonSRX _frontRightMotor = RobotMap._frontRightMotor;
	WPI_TalonSRX _backLeftMotor   = RobotMap._backLeftMotor;
	WPI_TalonSRX _backRightMotor  = RobotMap._backRightMotor;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

