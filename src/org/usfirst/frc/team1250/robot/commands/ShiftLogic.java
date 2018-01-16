package org.usfirst.frc.team1250.robot.commands;
import org.usfirst.frc.team1250.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftLogic extends Command {
	
	static int LeftVelocity=0;
	static int RightVelocity = 0;
	
	
    public ShiftLogic() {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.m_drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//RightVelocity = Robot.m_drivetrain.getRightRPM();
    	//LeftVelocity = Robot.m_drivetrain.getLeftRPM();
    	
    	
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
