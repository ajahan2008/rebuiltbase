// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterIO extends SubsystemBase {

  // motors
  private TalonFX shooterMotor = new TalonFX(ShooterConstants.shooterID);
  private TalonFX indexerMotor = new TalonFX(ShooterConstants.indexerID);

  // configurators
  private TalonFXConfigurator shootConfigurator = shooterMotor.getConfigurator();
  private TalonFXConfigurator indexerConfigurator = indexerMotor.getConfigurator();

  // configs
  private CurrentLimitsConfigs limitsConfigs = new CurrentLimitsConfigs();

  /** Creates a new Shooter. */
  public ShooterIO() {
    
    limitsConfigs.StatorCurrentLimit = 60;
    limitsConfigs.StatorCurrentLimitEnable = true;
    limitsConfigs.SupplyCurrentLimit = 60;
    limitsConfigs.SupplyCurrentLimitEnable = true;

    shootConfigurator.apply(limitsConfigs);
    indexerConfigurator.apply(limitsConfigs);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("Shoot Applied Output V", shooterMotor.getMotorVoltage().getValueAsDouble());
    SmartDashboard.putNumber("Indexer Applied Output V", indexerMotor.getMotorVoltage().getValueAsDouble());

  }

  /**
   * just the shoot (top/main/flywheel)
   * @param speed to move the shoot motor at
   */
  public void shoot(double speed) {
    shooterMotor.set(speed);
  }

  /**
   * just the throughput (bottom/secondary/torque)
   * @param speed to move the shoot motor at
   */
  public void index(double speed) {
    indexerMotor.set(speed);
  }

  public void stop() {
    shooterMotor.stopMotor();
    indexerMotor.stopMotor();
  }

}
