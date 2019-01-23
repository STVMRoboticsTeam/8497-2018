package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.*;


/**
 * Advanced Chassis Control for 2019 FTC Robot (Team 8497)
 *
 * Copyright* Cameron Feezel, 2019
 * All Rights Reserved.
 */
public class ChassisControl extends Chassis2Motor {

    // Add new motors/servos here.

    public ChassisControl(OpMode opMode) {
        super(opMode);
    }

    public void init(boolean auto) {
        super.init(auto);
    }


}
