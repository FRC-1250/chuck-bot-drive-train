//The pinching command
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

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    //The toggle command for the OP to pinch the box
    	if (!Robot.m_claw.CheckSoloClaw())
    		Robot.m_claw.pinch();
    	else
    		Robot.m_claw.unpinch();
    		
    			
    }

    protected void interrupted() {
    }
}
