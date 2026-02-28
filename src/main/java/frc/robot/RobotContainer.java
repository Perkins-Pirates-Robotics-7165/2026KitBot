// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.Intake;
import frc.robot.commands.RevShoot;
import frc.robot.commands.Shoot;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  DriveSubsystem driveSubsystem = new DriveSubsystem();

  // Controller
  private final CommandXboxController primary = new CommandXboxController(0);
  private final CommandXboxController secondary = new CommandXboxController(1);

  // The start of robot container used to configure bindings and any initializing settup
  public RobotContainer() {
    configureBindings();
  }

  // Set bindings for controllers / other set triggers
  private void configureBindings() {

    /* Driving - Left & Right Sticks */
    driveSubsystem.setDefaultCommand(
        new TankDrive(driveSubsystem, () -> -primary.getLeftY() * 0.3, () -> primary.getRightY() * 0.3)
    );
    
    /* Intaking */

    // Intake - Left Trigger
    secondary.leftTrigger(0.1).whileTrue(
      new Intake(intakeSubsystem, 0.7, 1.0)
    );

    // Reverse intake - B
    secondary.b().whileTrue(
      new Intake(intakeSubsystem, -0.7, -1.0)
    );


    /* Shooting */

    // Shoot - Right Trigger
    secondary.rightTrigger(0.1).whileTrue(
      new RevShoot(shooterSubsystem, -0.65, () -> secondary.leftBumper().getAsBoolean())
    );

    // Reverse Shoot - Left Trigger
    secondary.a().whileTrue(
      new Shoot(shooterSubsystem, 0.7)
    );

  }

  // Ran periodicly (called in Robot.java)
  public void periodic() {

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
