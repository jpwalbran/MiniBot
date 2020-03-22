package org.minutebots.frc2019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    Spark leftmotor = new Spark(0); // Declaring motor. "Spark" is how the code refers to the motor controllers that drive motors.
    Spark rightmotor = new Spark (1); // Declaring second motor with a different port. Port is an integer that is required by a constructor.
    Joystick joystick = new Joystick (0); // Declaring our joystick so we can drive our robot. Port is an integer that is required by a constructor.
    DifferentialDrive drivetrain = new DifferentialDrive(leftmotor, rightmotor); // DifferentialDrive is a controller that translates joystick input into robot movement.
    
  @Override
  public void teleopInit() {
  }
  
  @Override
  public void teleopPeriodic() { //Code in the brackets gets executed every 20ms.
      drivetrain.curvatureDrive(-joystick.getY(), joystick.getX(), joystick.getRawButton(1)); // We're passing in input into the this method, it needs it to be able to execute and move the motors.
  }

  @Override
  public void testInit() { // This adds all the motors to a user interface called Smart Dashboard (we use Shuffleboard, which is compatible), so we can control each motor manually.
      SmartDashboard.putData(leftmotor);
      SmartDashboard.putData(rightmotor);
      SmartDashboard.putData(drivetrain);
  }
}
