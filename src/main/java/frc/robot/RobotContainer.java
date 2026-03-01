// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ComputerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.SuckConstants;
import frc.robot.commands.Intake;
import frc.robot.commands.RevShoot;
import frc.robot.commands.Shoot;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SuckSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // Controller
  private final CommandXboxController primary = new CommandXboxController(ComputerConstants.primaryControllerPort);
  private final CommandXboxController secondary = new CommandXboxController(ComputerConstants.secondaryControllerPort);

  // Subsystems
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  SuckSubsystem suckSubsystem = new SuckSubsystem();
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  // The start of robot container used to configure bindings and any initializing settup
  public RobotContainer() {
    configureBindings();
  }

  // Set bindings for controllers / other set triggers
  private void configureBindings() {

    /* Driving - Left & Right Sticks */
    driveSubsystem.setDefaultCommand(
        new TankDrive(driveSubsystem, () -> -primary.getLeftY() * DriveConstants.mainDriveModifier, () -> primary.getRightY() * DriveConstants.mainDriveModifier)
    );


    /* Shooting */

    // Shoot - Right Trigger
    secondary.rightTrigger(ShooterConstants.shooterTriggerThreshold).whileTrue(
      new RevShoot(shooterSubsystem, suckSubsystem, ShooterConstants.shooterSpeedForward, SuckConstants.suckSpeedForwawrd, () -> secondary.leftBumper().getAsBoolean())
    );

    // Reverse Shoot - Left Trigger
    secondary.a().whileTrue(
      Commands.parallel(
        new Shoot(shooterSubsystem, ShooterConstants.shooterSpeedReverse),
        new InstantCommand(() -> suckSubsystem.suck(SuckConstants.suckSpeedReverse))
      )
    );


    /* Intaking */

    // Intake - Left Trigger
    secondary.leftTrigger(IntakeConstants.intakeTriggerThreshold).whileTrue(
      new Intake(intakeSubsystem, IntakeConstants.groundIntakeSpeedForward, IntakeConstants.switchMotorSpeedForward)
    );

    // Reverse intake - B
    secondary.b().whileTrue(
      new Intake(intakeSubsystem, IntakeConstants.groundIntakeSpeedReverse, IntakeConstants.switchMotorSpeedReverse)
    );

  }

  // Ran periodicly (called in Robot.java)
  public void periodic() {

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
