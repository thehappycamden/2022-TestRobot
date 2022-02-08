package com.spartronics4915.frc2022.subsystems;

import com.spartronics4915.frc2022.Constants;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.REVLibError;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class JoystickMotor extends SpartronicsSubsystem
{
    private static JoystickMotor sInstance = null;
    private static TalonFX mMotor;
    private static Joystick mJoystick;

    public JoystickMotor()
    {
        boolean success = true;
        try
        {
            mMotor = new TalonFX(Constants.kTestMotorId);
            mJoystick = new Joystick(Constants.OI.kJoystickId);
        }
        catch (Exception exception)
        {
            logException("Could not construct hardware: ", exception);
            success = false;
        }
        logInitialized(success);
    }

    public static JoystickMotor getInstance()
    {
        if (sInstance == null) {
            sInstance = new JoystickMotor();
        }
        return sInstance;
    }

    public void set(double speed)
    {
        SmartDashboard.putString("Motor","Setting Speed");
        mMotor.set(ControlMode.PercentOutput,speed);
        SmartDashboard.putNumber("Speed",mMotor.getSelectedSensorVelocity());
    }

    public double getSpeed()
    {
        SmartDashboard.putString("Motor","Getting Speed");
        return mMotor.getSelectedSensorVelocity();
    }

    public Joystick getJoystick()
    {
        return mJoystick;
    }
}
