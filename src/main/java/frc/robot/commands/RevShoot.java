package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SuckSubsystem;

public class RevShoot extends Command {

    private final ShooterSubsystem shooterSubsystem;
    private final SuckSubsystem suckSubsystem;

    private final double shooterSpeed;

    private final double suckSpeed;
    private final Supplier<Boolean> startGroundIntake;

    /**
     * Shoots balls with the shooter
     * 
     * @param shooterSubsystem - The subsystem for shooting
     * @param speed - Intake motors' speeds. 
     */
    public RevShoot(ShooterSubsystem shooterSubsystem, SuckSubsystem suckSubsystem, double shooterSpeed, double suckSpeed, Supplier<Boolean> startGroundIntake) {

        // Set the subsystem
        this.shooterSubsystem = shooterSubsystem;
        this.suckSubsystem = suckSubsystem;

        // Saves the two supplier functions
        this.shooterSpeed = shooterSpeed;

        this.suckSpeed = suckSpeed;
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
        shooterSubsystem.shoot(shooterSpeed);

        if (startGroundIntake.get()) {
            suckSubsystem.suck(suckSpeed);
        } else {
            suckSubsystem.suck(0.0);
        }
    }

    // When the command is finished
    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.shoot(0.0);
        suckSubsystem.suck(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}