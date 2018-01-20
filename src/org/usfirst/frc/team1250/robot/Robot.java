
package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1250.robot.RobotMap;

import org.usfirst.frc.team1250.robot.subsystems.DriveTraine;
import org.usfirst.frc.team1250.robot.subsystems.Claw;

public class Robot extends IterativeRobot {

	Command m_autonomousCommand;
	public static RobotMap rb;
	public static DriveTraine m_drivetrain;
	public static Claw m_claw;
	public static OI m_oi;
	
	
//OI ALWAYS LAST !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public void robotInit() {
//    	
//    	SmartDashboard.putData(m_drivetrain);
//    	SmartDashboard.putData(m_claw);
    	CameraServer.getInstance().startAutomaticCapture();
    	rb = new RobotMap();
    	m_drivetrain = new DriveTraine();
    	m_claw = new Claw();
    	m_oi = new OI();
    	SmartDashboard.putData(m_drivetrain);
    	SmartDashboard.putData(m_claw);
    }


    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
		log();

    }
    
    
	private void log() {
		m_drivetrain.log();
	}
}
