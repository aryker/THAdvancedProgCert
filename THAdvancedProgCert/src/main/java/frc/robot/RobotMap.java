package frc.robot;

/**
 * This is the RobotMap class, which stores constants for use throughout the project.
 * These constants include motor controller constants, controller mappings, etc.
 * @author dri
 */


 /* IMPORTANT:
    Once a constant has been tested, switch the comment to "tested"
    If you change/add a constant, label it "untested"
 */
public class RobotMap {
    public static int PCM = 0;

    public static class Drivetrain {
        public static final int LEFT_PRIMARY = 23; // untested
        public static final int LEFT_SECONDARY = 24; // untested
        public static final int LEFT_TERTIARY = 25; // untested

        public static final int RIGHT_PRIMARY = 10; // untested
        public static final int RIGHT_SECONDARY = 11; // untested
        public static final int RIGHT_TERTIARY = 12; // untested
    }

    public static class Sensors {
        public static final int GYRO = 1; // untested
    }

    public static class Controllers {
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;

        public static final int A = 1;
        public static final int B = 2;
        public static final int X = 3;
        public static final int Y = 4;
        public static final int RB = 6;
        public static final int LB = 5;
        public static final int RSTK = 10;
        public static final int LSTK = 9;
        public static final int START = 8;
        public static final int MENU = 7;

        public static final int LX = 0;
        public static final int LY = 1; // Arcade drive
        public static final int RX = 4; // Arcade drive
        public static final int RY = 5;
        public static final int LT = 2;
        public static final int RT = 3;
    }
}