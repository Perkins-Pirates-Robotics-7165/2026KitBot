package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {

    private final IntakeSubsystem intakeSubsystem;
    private final double speed;
    private final double speedSwitch;

    /**
     * Starts the intake motors to intake balls
     * 
     * @param intakeSubsystem - The subsystem for intaking
     * @param speed - Intake & switch motor speeds. 
     */
    public Intake(IntakeSubsystem intakeSubsystem, double speed) {

        // Set the subsystem
        this.intakeSubsystem = intakeSubsystem;

        // Saves the two supplier functions
        this.speed = speed;
        this.speedSwitch = speed;

        // Adds the requirement of the intake subsystem so two commands can't use it at once
        addRequirements(intakeSubsystem);
    }

    /**
     * Starts the intake motors to intake balls
     * 
     * @param intakeSubsystem - The subsystem for intaking
     * @param speed - Intake motor speeds. 
     * @param speedSwitch - Switch motor speed
     */
    public Intake(IntakeSubsystem intakeSubsystem, double speed, double speedSwitch) {

        // Set the subsystem
        this.intakeSubsystem = intakeSubsystem;

        // Saves the two supplier functions
        this.speed = speed;
        this.speedSwitch = speedSwitch;

        // Adds the requirement of the intake subsystem so two commands can't use it at once
        addRequirements(intakeSubsystem);
    }

    // Runs once when initialized
    @Override
    public void initialize() {}

    // Runs while the command is 'sceduled' (aka. while the button is pressed on with a .whileTrue)
    @Override
    public void execute() {
        // Start the intake motors with the givin speed
        intakeSubsystem.intake(speed, speedSwitch); // Todo: FINI
    }

    // When the command is finished
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.intake(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}