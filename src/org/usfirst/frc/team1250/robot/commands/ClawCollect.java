package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;



public class ClawCollect extends Command {

    public ClawCollect() {
    	requires(Robot.m_claw);
    }


	protected void initialize() {
	}
	

    protected void execute() {
    	Robot.m_claw.collect();
    	
    		
    	}
    		    		   
        protected boolean isFinished() {
        	if (!Robot.m_claw.isIn()){
        		return true; }
        	else {	
        		return false;
        	
        	}
        	}
        

    protected void end() {
    	Robot.m_claw.stop();
    }

            protected void interrupted() {
    }
}
