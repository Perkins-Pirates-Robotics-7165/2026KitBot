package frc.robot;

public class Constants {

    public static class ComputerConstants {
        public static final int primaryControllerPort = 0;
        public static final int secondaryControllerPort = 1;
    }
  
    public static class DriveConstants {

        public static final double mainDriveModifier = 0.3;

        public static final int frontLeftDriveMotorID = 0;
        public static final int frontLeftFollowerMotorID = 1;

        public static final int frontRightDriveMotorID = 2;
        public static final int frontRightFollowerMotorID = 3;
    }

    public static class ShooterConstants {

        public static final double shooterTriggerThreshold = 0.1;

        public static final double shooterSpeedForward = 0.70;
        public static final double shooterSpeedReverse = -0.70;

        
        public static final int shooterMotorID = 9;
    }

    public static class SuckConstants {

        public static final int switchMotorID = 5;

        public static final double suckSpeedForwawrd = 0.65;
        public static final double suckSpeedReverse = -0.65;
    }

    public static class IntakeConstants {

        public static final double intakeTriggerThreshold = 0.1;

        public static final double groundIntakeSpeedForward = 0.7;
        public static final double switchMotorSpeedForward = 1.0;


        public static final double groundIntakeSpeedReverse = -0.7;
        public static final double switchMotorSpeedReverse = -1.0;

        public static final int groundIntakeMotorID = 4;
        public static final int switchMotorID = 5;
    }

}
