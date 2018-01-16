package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1250.robot.Robot;

/**
 *
 */
public class Pinch extends Command {

    public Pinch() {
    }

    protected void initialize() {
    }

    protected void execute() {
//		Robot.m_claw.pinch();
			


    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	if (!Robot.m_claw.CheckSoloClaw())
    		Robot.m_claw.pinch();
    	else
    		Robot.m_claw.unpinch();
    		
    			
    }

    protected void interrupted() {
    }
}
