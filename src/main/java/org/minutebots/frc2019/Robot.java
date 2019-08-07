package org.minutebots.frc2019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  Joystick stick = new Joystick(0);
  Spark leftMotor = new Spark(0),
        rightMotor = new Spark(1),
        literallyUselessMotor = new Spark(2);
  DifferentialDrive driveTrain = new DifferentialDrive(leftMotor, rightMotor);

  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    driveTrain.curvatureDrive(-stick.getY(), stick.getX(), stick.getTrigger());
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
