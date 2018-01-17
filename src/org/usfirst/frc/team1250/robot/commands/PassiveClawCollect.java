package org.usfirst.frc.team1250.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;


public class PassiveClawCollect extends Command {

    public PassiveClawCollect() {

    }

    protected void initialize() {
    	//Running Left Wheels
    	if (!Robot.m_claw.isSeenLeft()){
    		Robot.m_claw.leftCollect();
    	}
    		//Stopping Left Wheels
    		else Robot.m_claw.stopleftCollect();
    	//Running Right Wheels
    	if (!Robot.m_claw.isSeenRight()){
    		Robot.m_claw.rightCollect();
    	}
    		//Stopping Right Wheels
    		else Robot.m_claw.stoprightCollect();
    	//Runs Both Left And Right Side //Pinches The Box
    	if (!Robot.m_claw.isSeenRight() & !Robot.m_claw.isSeenLeft()){
    		Robot.m_claw.collect();
    		Robot.m_claw.pinch();
    	}
    		//Stopping all //Unpinching All
    		else 
    		Robot.m_claw.stop();
    		Robot.m_claw.unpinch();
    	//Pinching For Tower
    	if (!Robot.m_claw.isIn()) {
    		Robot.m_claw.soloLiftPinch();		
    	}
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
