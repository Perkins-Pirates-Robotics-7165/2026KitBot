package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class RevShoot extends Command {

    private final ShooterSubsystem shooterSubsystem;
    private final double speed;
    private final Supplier<Boolean> startGroundIntake;

    /**
     * Shoots balls with the shooter
     * 
     * @param shooterSubsystem - The subsystem for shooting
     * @param speed - Intake motors' speeds. 
     */
    public RevShoot(ShooterSubsystem shooterSubsystem, double speed, Supplier<Boolean> startGroundIntake) {

        // Set the subsystem
        this.shooterSubsystem = shooterSubsystem;

        // Saves the two supplier functions
        this.speed = speed;
        this.startGroundIntake = startGroundIntake;

        // Adds the requirement of the shooter subsystem so two commands can't use it at once
        addRequirements(shooterSubsystem);
    }

    // Runs once when initialized
    @Override
    public void initialize() {}

    // Runs while the command is 'sceduled' (aka. while the button is pressed on with a .whileTrue)
    @Override
    public void execute() {
        // Shoot the balls with the set speed
        shooterSubsystem.revShoot(speed, startGroundIntake);
    }

    // When the command is finished
    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.revShoot(0.0, () -> true);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}