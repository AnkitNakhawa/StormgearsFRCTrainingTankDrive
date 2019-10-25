





        /*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

        import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
        import edu.wpi.first.wpilibj.SpeedControllerGroup;
        import edu.wpi.first.wpilibj.command.Subsystem;
        import edu.wpi.first.wpilibj.drive.DifferentialDrive;
        import frc.robot.commands.JoyDrive;


public class Drive extends Subsystem {
  private WPI_TalonSRX backRight;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX frontRight;

  //VEER CORRECTION
  //see line 50 for comments
  private SpeedControllerGroup leftSide;
  private SpeedControllerGroup rightSide;

  private DifferentialDrive differentialDrive;


  public Drive() {
    frontLeft = new WPI_TalonSRX(3);
    frontRight = new WPI_TalonSRX(2);
    backLeft = new WPI_TalonSRX(1);
    backRight = new WPI_TalonSRX(0);

    leftSide = new SpeedControllerGroup(frontLeft, backLeft);
    rightSide = new SpeedControllerGroup(frontRight, backRight);

    //Ankit's Line
    //differentialDrive = new DifferentialDrive(frontLeft, frontRight);

    //VEER CORRECTION:
    //Here you have the line, differentialDrive = new DifferentialDrive(frontLeft, frontRight);
    //The problem is that you only are passing in two of the variables, 'frontLeft', and 'frontRight'
    //So with this code backLeft and backRight will not move at all
    //There are a few ways to fix this issue, either you can set the backLeft to be a slave of the frontLeft and the same with the right side
    //Or you can made a speed controller for the left side and a speed controller for the right side, this is what I will be doing

    differentialDrive = new DifferentialDrive(leftSide, rightSide);




  }

  //VEER CORRECTION:
  //Not that tank drive is wrong, I think arcadeDrive is more suitable. This way we can just give it an x, and a rotation speed
  public void drive(double leftPower, double rightPower){
    differentialDrive.arcadeDrive(leftPower, rightPower);
}

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new JoyDrive());
  }

}
