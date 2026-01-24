package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    TalonSRX groundIntakeMotor = new TalonSRX(4);
    TalonSRX switchIntakeMotor = new TalonSRX(5);

    public IntakeSubsystem() {}

    /*
     * Drive the robot
     * 
     * @param left - Left drive percentage [-1.0, 1.0]
     * @param right - Right drive percentage [-1.0, 1.0]
     */
    public void intake(double speed) {
        groundIntakeMotor.set(TalonSRXControlMode.PercentOutput, speed);
        switchIntakeMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    // Period function on field, called every 20ms
    @Override
    public void periodic() {}

    // Periodic function during simulation, called every 20ms
    @Override
    public void simulationPeriodic() {}

}