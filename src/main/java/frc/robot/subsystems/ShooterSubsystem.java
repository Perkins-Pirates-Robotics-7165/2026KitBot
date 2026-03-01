package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

    SparkFlex shooterMotor = new SparkFlex(ShooterConstants.shooterMotorID, MotorType.kBrushless);

    public ShooterSubsystem() {

        // Create a configurator for the spark flex, and invert the motor
        SparkFlexConfig sparkFlexConfig = new SparkFlexConfig();
        sparkFlexConfig.encoder.inverted(true);

        // Set the configuration
        shooterMotor.configure(sparkFlexConfig, ResetMode.kNoResetSafeParameters, PersistMode.kPersistParameters);

    }

    /*
     * Start the shooter
     * 
     * @param speed - Switch Motor drive percentage [-1.0, 1.0]
     */
    public void shoot(double speed) {
        shooterMotor.set(speed);
    }

    // Period function on field, called every 20ms
    @Override
    public void periodic() {}

    // Periodic function during simulation, called every 20ms
    @Override
    public void simulationPeriodic() {}

}