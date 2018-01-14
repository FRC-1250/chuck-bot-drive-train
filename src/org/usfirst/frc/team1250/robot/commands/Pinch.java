package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1250.robot.Robot;
import org.usfirst.frc.team1250.robot.subsystems.Claw;;

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
    	if (Robot.m_claw.CheckSoloClaw())
    		Robot.m_claw.unpinch();
    	else
    		Robot.m_claw.unpinch();
    		
    			
    }

    protected void interrupted() {
    }
}
