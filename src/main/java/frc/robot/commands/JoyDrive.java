/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class JoyDrive extends Command {
    private XboxController stick;
    double leftTrigVal;
    double rightTrigVal;
    double leftStickXVal;


    public JoyDrive() {
        requires(Robot.driveSubsystem);
        stick = Robot.oi.getJoystick();


        //ANKIT I THINK YOU NEED TO WRITE THIS CODE SOMEWHERE ELSE BECAUSE ALL OF IT IS IN THE CONSTRUCTOR
        leftTrigVal = stick.getTriggerAxis(GenericHID.Hand.kLeft);
        rightTrigVal = stick.getTriggerAxis(GenericHID.Hand.kRight);

        //VEER CORRECTION:
        // You would want the y axis of the left joystick, just think about it
        leftStickXVal = stick.getY(GenericHID.Hand.kLeft);


        //Explain this logic to me in person alright, becuase I am not sure that I follow here. -Veer
            Robot.driveSubsystem.drive(rightTrigVal - leftTrigVal, rightTrigVal - leftTrigVal);

            while (rightTrigVal >= .025 && leftStickXVal >= .025){
            Robot.driveSubsystem.drive(rightTrigVal, 0);
            break;
        }
        while (leftTrigVal >= .025 && leftStickXVal >= .025){
            Robot.driveSubsystem.drive(leftTrigVal, -leftStickXVal);
            break;
        }
        while (leftTrigVal >= .025 && leftStickXVal <= -.025){
            Robot.driveSubsystem.drive(-leftStickXVal, leftTrigVal);
            break;
        }
        while (rightTrigVal >= .025 && leftStickXVal <= -.025){
            Robot.driveSubsystem.drive(0, rightTrigVal);
            break;
        }
    }



    protected void initialize() {
        // You may want to enstantiate your variables here

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
