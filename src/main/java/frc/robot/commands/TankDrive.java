package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class TankDrive extends Command {

    private final DriveSubsystem driveSubsystem;
    private final Supplier<Double> leftSpeed;
    private final Supplier<Double> rightSpeed;

    /**
     * Drives the robot using tank drive
     * 
     * @param driveSubsystem - The subsystem for driving
     * @param leftSpeed - Left motor speeds. Needs to use (() -> *speed*) for it to work
     * @param rightSpeed - Right motor speeds. Needs to use (() -> *speed*) for it to work
     */
    public TankDrive(DriveSubsystem driveSubsystem, Supplier<Double> leftSpeed, Supplier<Double> rightSpeed) {

        // Set the subsystem
        this.driveSubsystem = driveSubsystem;

        // Saves the two supplier functions
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;

        // Adds the requirement of the drive subsystem so two commands can't use it at once
        addRequirements(driveSubsystem);
    }

    // Runs once when initialized
    @Override
    public void initialize() {}

    // Runs while the command is 'sceduled' (aka. while the button is pressed on with a .whileTrue)
    @Override
    public void execute() {
        // Drive the robot with the givin suppliers
        driveSubsystem.tankDrive(leftSpeed.get(), rightSpeed.get());
    }

    // When the command is finished
    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}