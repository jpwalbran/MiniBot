package org.minutebots.frc2019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

Spark leftmotor = new Spark(0);
Spark rightmotor = new Spark (1);
Joystick joystick = new Joystick (0);
DifferentialDrive drivetrain = new DifferentialDrive(leftmotor, rightmotor);


  @Override
  public void teleopPeriodic() {
    drivetrain.curvatureDrive(-joystick.getY(), joystick.getX(),joystick.getRawButton(1));
  }

  @Override
  public void testInit() {
    LiveWindow.add(leftmotor);
    LiveWindow.add(rightmotor);
    LiveWindow.add(drivetrain);
  }

  @Override
  public void testPeriodic() {
  }

}
