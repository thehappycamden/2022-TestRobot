package com.spartronics4915.frc2022.subsystems;

import com.spartronics4915.frc2022.Constants;
import com.spartronics4915.lib.hardware.motors.SpartronicsFalcon;
import com.spartronics4915.lib.hardware.motors.SpartronicsMotor;
import com.spartronics4915.lib.subsystems.SpartronicsSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.REVLibError;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class JoystickMotor extends SpartronicsSubsystem
{
    private static JoystickMotor sInstance = null;
    private static SpartronicsMotor mMotor;
    private static Joystick mJoystick;

    public JoystickMotor()
    {
        boolean success = true;
        try
        {
            mMotor = SpartronicsFalcon.makeMotor(Constants.kTestMotorId);
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
        mMotor.setVelocity(speed);
    

    public Joystick getJoystick()
    {
        return mJoystick;
    }
}
