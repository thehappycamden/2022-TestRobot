package com.spartronics4915.frc2022.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

import com.spartronics4915.frc2022.Constants;
import com.spartronics4915.frc2022.Constants.*;
import com.spartronics4915.frc2022.subsystems.JoystickMotor;

public class JoystickMotorCommand extends CommandBase
{
    private final JoystickMotor mJoystickMotor;
    private final Joystick mJoystick;
    private boolean mInverted;
    private boolean mSlow;

    public JoystickMotorCommand(JoystickMotor motor)
    {
        mJoystickMotor = motor;
        mJoystick = motor.getJoystick();
        mInverted = false;
        mSlow = false;
        addRequirements(mJoystickMotor);
    }

    @Override
    public void execute()
    {
        double y = -1 * mJoystick.getY();

        if (mSlow)
        {
            y *= JoystickMotorConstants.kMotorSlowSpeed;
        }

        if (mInverted)
        {
            y *= -1;
        }

        mJoystickMotor.set(applyResponseCurve(applyDeadzone(y, Constants.JoystickMotorConstants.kJoystickDeadzone), Constants.JoystickMotorConstants.kJoystickResponseCurve));
    }

    // also copied from ir2020
    private double applyDeadzone(double val, double deadzone)
    {
        if (Math.abs(val) < deadzone)
        {
            return 0.0;
        }
        return val;
    }

    /** Takes an input x and raises it power a.
     * Copies the sign of the original to ensure that the curve is an odd function.
     * Takes absolute value of original to ensure that there are no issues with raising negative numbers to weird powers.
     * Demonstration at https://www.desmos.com/calculator/bodonb3nbh
     */
    private double applyResponseCurve(double x, double a)
    {
        // copied from 2020-InfiniteRecharge, no idea how it works (magic)
        return Math.copySign(Math.pow(Math.abs(x), a), x); // apply response curve
    }
}
