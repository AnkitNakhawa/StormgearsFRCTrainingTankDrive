





        /*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.JoyDrive;


public class Drive extends Subsystem {
  private WPI_TalonSRX backRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;

  public DifferentialDrive differentialDrive;


  public Drive() {
    frontLeft = new WPI_TalonSRX(3);
    frontRight = new WPI_TalonSRX(2);
    backLeft = new WPI_TalonSRX(1);
    backRight = new WPI_TalonSRX(0);

    differentialDrive = new DifferentialDrive(frontLeft, frontRight);

  }


  public void drive(double leftPower, double rightPower){
  differentialDrive.tankDrive(leftPower, rightPower);
}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoyDrive());
  }

}
