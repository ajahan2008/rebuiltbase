// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.shooter.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class StopAllCommand extends InstantCommand {

  private ShooterSubsystem shooterIO;

  /**
   * Stops all subsystems.
   * @param shooterIO - Shooter subsystem
   */
  public StopAllCommand(ShooterSubsystem shooterIO) {
    this.shooterIO = shooterIO;

    addRequirements(shooterIO);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterIO.stop();
  }
}
