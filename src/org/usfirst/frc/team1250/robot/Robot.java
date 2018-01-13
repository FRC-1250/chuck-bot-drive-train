
package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team1250.robot.RobotMap;

import org.usfirst.frc.team1250.robot.subsystems.DriveTraine;


public class Robot extends IterativeRobot {

	Command m_autonomousCommand;

	
	public static RobotMap rb;
	public static DriveTraine m_drivetrain;
	public static OI m_oi;
	

    public void robotInit() {
    	rb = new RobotMap();
    	m_drivetrain = new DriveTraine();
    	m_oi = new OI();
    }


    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
		log();

    }
    
    
	private void log() {
		m_drivetrain.log();
	}
}
