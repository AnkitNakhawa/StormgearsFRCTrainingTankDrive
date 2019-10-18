/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
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
        leftTrigVal = stick.getTriggerAxis(GenericHID.Hand.kLeft);
        rightTrigVal = stick.getTriggerAxis(GenericHID.Hand.kRight);
        leftStickXVal = stick.getX(GenericHID.Hand.kLeft);

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
