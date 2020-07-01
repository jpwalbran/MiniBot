package org.minutebots.frc2019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    Spark leftmotor = new Spark(0); // Declaring motor. "Spark" is how the code refers to the motor controllers that drive motors.
    Spark rightmotor = new Spark (1); // Declaring second motor with a different port. Port is an integer that is required by a constructor.
    //Joystick joystick = new Joystick (0); // Declaring our joystick so we can drive our robot. Port is an integer that is required by a constructor.
    XboxController controller = new XboxController(0); //Declaring the Controller for the control input (rather than a joystick), port is the same as the joystick, in that it is an integer
    DifferentialDrive drivetrain = new DifferentialDrive(leftmotor, rightmotor); // DifferentialDrive is a controller that translates joystick input into robot movement.
    
  @Override
  public void teleopInit() {
  }
  
  @Override
  public void teleopPeriodic() { //Code in the brackets gets executed every 20ms.
    // The following line tells the robot to move based on the joystick input, and it takes in 3 arguments, the X-component of the joystick, the Y-component of the joystick, and a third axis for rotational acceleration (how fast do we want it to turn)
      drivetrain.curvatureDrive(-controller.getY(GenericHID.Hand.kLeft), controller.getX(GenericHID.Hand.kLeft), controller.getTriggerAxis(GenericHID.Hand.kRight)); 
  }

  @Override
  public void testInit() { // This adds all the motors to a user interface called Smart Dashboard (we use Shuffleboard, which is compatible), so we can control each motor manually.
      SmartDashboard.putData(leftmotor);
      SmartDashboard.putData(rightmotor);
      SmartDashboard.putData(drivetrain);
  }
}
