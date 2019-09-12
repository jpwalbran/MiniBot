package org.minutebots.frc2019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

Spark leftmotor = new Spark(0); //Declaring motor. "Spark" is how the code refers to the motor controllers that drive motors.
Spark rightmotor = new Spark (1); //Declaring second motor with a different port. Port is an integer that is required by a constructor.
Joystick joystick = new Joystick (0); //Declaring our joystick so we can drive our robot. Port is an integer that is required by a constructor.
DifferentialDrive drivetrain = new DifferentialDrive(leftmotor, rightmotor); //DifferentialDrive is a controller that translates joystick input into robot movement.
//The constructor requires 2 SpeedControllers, and Spark is a type of SpeedController so it is able to be passed in.
private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
private boolean buttonIsPressed = false;
  @Override
  public void teleopPeriodic() { //Code in the brackets gets executed every 20ms.
    
    if(joystick.getRawButtonPressed(2) && !buttonIsPressed){
      saneDrive.setSetpoint(gyro.getAngle());
      buttonIsPressed = true;
    }
    if(joystick.getRawButtonReleased(2))
      buttonIsPressed = false;

    if(joystick.getRawButton(2)){
      drivetrain.arcadeDrive(joystick.getY(), getOutput());
    }
    else
      drivetrain.curvatureDrive(joystick.getY(), joystick.getX(), joystick.getRawButton(1));
    //We're passing in input into the this method, it needs it to be able to execute and move the motors.
  }

  @Override
  public void testPeriodic() {
    SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());  
  }

  @Override
  public void robotInit() {
    saneDrive.enable();
    gyro.calibrate();
    SmartDashboard.putData(leftmotor);
    SmartDashboard.putData(rightmotor);
    SmartDashboard.putData(drivetrain);
    SmartDashboard.putData(saneDrive);
  }

  private double Kp = .05;
  private double Ki = 0;
  private double Kd = 0;
  double output = 0;
  PIDOutput putout = new PIDOutput(){
    @Override
    public void pidWrite(double input) {
      output = input;
    }
  };  
  public double getOutput(){
    return output;
  }
  PIDController saneDrive = new PIDController(Kp, Ki, Kd, gyro, putout);

}
