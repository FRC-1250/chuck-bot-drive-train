//This is a claw command , OP uses this to manually stop the claw
package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClawStop extends Command {

    public ClawStop() {
    		requires(Robot.m_claw);
    	}

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }


    protected void end() {
    	Robot.m_claw.stop();
    }


    protected void interrupted() {
    }
}
