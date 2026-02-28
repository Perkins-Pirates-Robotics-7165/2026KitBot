package frc.robot.subsystems;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    TalonSRX groundIntakeMotor = new TalonSRX(4);
    TalonSRX switchIntakeMotor = new TalonSRX(5);
    SparkFlex shooterMotor = new SparkFlex(9, MotorType.kBrushless);

    public ShooterSubsystem() {}

    /*
     * Start the shooter
     * 
     * @param speed - Switch Motor drive percentage [-1.0, 1.0]
     */
    public void shoot(double speed) {
        shooterMotor.set(speed);
        switchIntakeMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void revShoot(double speed, Supplier<Boolean> startGroundIntake) {
        shooterMotor.set(speed);

        if (startGroundIntake.get()) {
            switchIntakeMotor.set(TalonSRXControlMode.PercentOutput, speed);
        } else {
            switchIntakeMotor.set(TalonSRXControlMode.PercentOutput, 0.0);
        }
    }

    // Period function on field, called every 20ms
    @Override
    public void periodic() {}

    // Periodic function during simulation, called every 20ms
    @Override
    public void simulationPeriodic() {}

}