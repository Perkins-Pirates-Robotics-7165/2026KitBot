package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

    TalonSRX frontLeftDrive = new TalonSRX(0);
    TalonSRX leftDriveFollower = new TalonSRX(1);

    TalonSRX frontRightDrive = new TalonSRX(2);
    TalonSRX rightDriveFollower = new TalonSRX(3);

    public DriveSubsystem() {
        leftDriveFollower.follow(frontLeftDrive);

        rightDriveFollower.follow(frontRightDrive);
    }

    /*
     * Drive the robot
     * 
     * @param left - Left drive percentage [-1.0, 1.0]
     * @param right - Right drive percentage [-1.0, 1.0]
     */
    public void tankDrive(double left, double right) {
        frontLeftDrive.set(TalonSRXControlMode.PercentOutput, left);
        frontRightDrive.set(TalonSRXControlMode.PercentOutput, right);
    }

    // Period function on field, called every 20ms
    @Override
    public void periodic() {}

    // Periodic function during simulation, called every 20ms
    @Override
    public void simulationPeriodic() {}

}