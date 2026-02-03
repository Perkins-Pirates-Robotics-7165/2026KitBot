package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    TalonSRX groundIntakeMotor = new TalonSRX(4);
    TalonSRX switchIntakeMotor = new TalonSRX(5);

    public ShooterSubsystem() {}

    /*
     * Start the shooter
     * 
     * @param speed - Switch Motor drive percentage [-1.0, 1.0]
     */
    public void shoot(double speed) {
        groundIntakeMotor.set(TalonSRXControlMode.PercentOutput, speed);
        switchIntakeMotor.set(TalonSRXControlMode.PercentOutput, -speed);
    }

    public void revShoot(double speed, Supplier<Boolean> startGroundIntake) {
        groundIntakeMotor.set(TalonSRXControlMode.PercentOutput, speed);

        if (startGroundIntake.get()) {
            switchIntakeMotor.set(TalonSRXControlMode.PercentOutput, -speed);
        }
    }

    // Period function on field, called every 20ms
    @Override
    public void periodic() {}

    // Periodic function during simulation, called every 20ms
    @Override
    public void simulationPeriodic() {}

}