/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.JoyDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drive extends Subsystem {
  private WPI_TalonSRX backRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;

  private MecanumDrive mecanumDrive;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Drive() {
    frontLeft = new WPI_TalonSRX(0);
    frontRight = new WPI_TalonSRX(1);
    backLeft = new WPI_TalonSRX(2);
    backRight = new WPI_TalonSRX(3);

    mecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
  }

  public void drive(double x, double y, double z, double rate) {
    mecanumDrive.driveCartesian(x * rate, y * rate, z * rate);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoyDrive());
  }
}
