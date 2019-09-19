/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.robot.Robot;

/**
 * This class rotates the robot to the specified angle (in degrees) using a Gyro sensor.
 * It uses a PID controller to accomplish this behavior.
 * 
 * NOTE: Through careful testing, it has been determined that the proportional
 * gain for the PID controller should be set to 0.1, the integral gain should be
 * set to 0.05, and the derivative gain should be set to 0.08.
 * 
 * @author hrl
 */
public class TurnToAngleGyro {
    private static double kP = 0.1, kI = 0.05, kD = 0.08; // PID controller constants
    private PIDController pid;
    private PIDSource pidSource;
    private PIDOutput pidOutput;

    public TurnToAngleGyro(int angle) {
        // initialize sources
        pidSource = new PIDSource() {
            @Override
            public void setPIDSourceType(PIDSourceType pidSource) {
                // Should not be used
            }
        
            @Override
            public double pidGet() {
                return Robot.gyro.getAngle();
            }
        
            @Override
            public PIDSourceType getPIDSourceType() {
                return PIDSourceType.kDisplacement;
            }
        };

        pidOutput = new PIDOutput() {
            @Override
            public void pidWrite(double output) {
                Robot.drivetrain.setSpeed(output, -output); // point turning, assumes proper inversion
            }
        };

        pid = new PIDController(kP, kI, kD, pidSource, pidOutput);
        pid.setAbsoluteTolerance(1.5); // the tolerable error, not %

        run(angle);
    }

    /**
     * Turns the robot to the specified angle (in degrees).
     * @param angle the angle to turn to
     */
    public void run(int angle) {
        if (!pid.isEnabled()) {
            start();
        }

        Robot.gyro.reset(); // should clear gyro every time before running for pidGet()

        pid.setSetpoint(angle);
    }

    /**
     * Starts the PID controller manually.
     * Should never need this.
     */
    public void start() {
        pid.enable();
    }

    /**
     * Stops the PID controller manually.
     * Should never need this.
     */
    public void stop() {
        pid.disable();
    }
}
