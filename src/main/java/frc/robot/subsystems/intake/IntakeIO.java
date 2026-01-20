// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeIO extends SubsystemBase {

  private SparkMax motor = new SparkMax(IntakeConstants.motorID, MotorType.kBrushless);
  private SparkMaxConfig motorConfig = new SparkMaxConfig();

  /** Creates a new Intake. */
  public IntakeIO() {}

  /**
   * Runs the intake at specified speed.
   * _ intakes, _ reverses.
   * @param speed
   */
  public void runIntake(double speed) {
    motor.set(speed);
  }

  /**
   * Actual intake command for the intake.
   * @return command
   */
  public Command runIntakeCommand() {
    return this.run(() -> runIntake(.5));
  }

  /**
   * If for some reason you need to reverse the intake.
   * @return reverse command
   */
  public Command reverseIntakeCommand() {
    return this.run(() -> runIntake(-.5));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("Intake Motor Speed", motor.get());
    SmartDashboard.putNumber("Intake Motor Volts", motor.getBusVoltage());
  }
}
