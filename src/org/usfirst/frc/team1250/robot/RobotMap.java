/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static WPI_TalonSRX _frontLeftMotor;
	public static WPI_TalonSRX _frontRightMotor;
	public static WPI_TalonSRX _backLeftMotor;
	public static WPI_TalonSRX _backRightMotor;
	public static WPI_VictorSPX _LeftClaw;
	public static WPI_VictorSPX _RightClaw;
	public static DigitalInput _LightSensClaw;
	public static DigitalInput _LaserSensClaw;
	
	public static void init() {
		
		_frontLeftMotor = new WPI_TalonSRX(14);
		_frontRightMotor = new WPI_TalonSRX(15);
		_backLeftMotor = new WPI_TalonSRX(10);
		_backRightMotor = new WPI_TalonSRX(13);
		_LeftClaw = new WPI_VictorSPX(10);
		_RightClaw = new WPI_VictorSPX(11);
		_LightSensClaw = new DigitalInput(1);
		_LaserSensClaw = new DigitalInput(2);
		 
	}

}



///* talons for arcade drive */
//WPI_TalonSRX _frontLeftMotor = new WPI_TalonSRX(14); 		/* device IDs here (1 of 2) */
//WPI_TalonSRX _frontRightMotor = new WPI_TalonSRX(15);
//
///* extra talons for six motor drives */
//WPI_TalonSRX _leftSlave1 = new WPI_TalonSRX(10);
//WPI_TalonSRX _rightSlave1 = new WPI_TalonSRX(13);
