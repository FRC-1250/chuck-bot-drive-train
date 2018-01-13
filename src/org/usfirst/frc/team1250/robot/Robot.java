
package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team1250.robot.RobotMap;

import org.usfirst.frc.team1250.robot.subsystems.DriveTraine;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command m_autonomousCommand;
	
	public static RobotMap rb;
	public static DriveTraine m_drivetrain;
	public static OI m_oi;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	rb = new RobotMap();
    	m_drivetrain = new DriveTraine();
    	m_oi = new OI();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
		log();

    }
    
    
	private void log() {
		m_drivetrain.log();
	}
}
