package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;


public class PassiveClawCollect extends Command {

    public PassiveClawCollect() {

    }

    protected void initialize() {
    	if (!Robot.m_claw.isSeenLeft()){
    		Robot.m_claw.leftCollect();
    	}
    		else Robot.m_claw.stopleftCollect();
    	if (!Robot.m_claw.isSeenRight()){
    		Robot.m_claw.rightCollect();
    	}
    	else Robot.m_claw.stoprightCollect();
    	if (!Robot.m_claw.isSeenRight() & !Robot.m_claw.isSeenLeft()){
    		Robot.m_claw.collect();
    		Robot.m_claw.pinch();
    	}
    		else 
    		Robot.m_claw.stop();
    		Robot.m_claw.unpinch();
    		
    }

        protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
