package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SuckConstants;

public class SuckSubsystem extends SubsystemBase {

    TalonSRX switchMotor = new TalonSRX(SuckConstants.switchMotorID);

    public SuckSubsystem() {}

    /*
     * Start the shooter
     * 
     * @param speed - Switch Motor drive percentage [-1.0, 1.0]
     */
    public void suck(double speed) {
        switchMotor.set(TalonSRXControlMode.PercentOutput, -speed);
    }

    // Period function on field, called every 20ms
    @Override
    public void periodic() {}

    // Periodic function during simulation, called every 20ms
    @Override
    public void simulationPeriodic() {}

}