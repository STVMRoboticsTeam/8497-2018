package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.*;

/**
 * Barebones Chassis Control for FTC Robots (Team 8497)
 *
 * For 2-Motor drive Chassis.
 *
 * Copyright* Cameron Feezel, 2019
 * All Rights Reserved.
 */
public abstract class Chassis2Motor {

    protected static final String CCVER = "v3";

    protected DcMotor left;
    protected DcMotor right;

    protected Gamepad gamepad1;
    protected Gamepad gamepad2;

    protected OpMode opMode;
    protected Telemetry telemetry;

    public Chassis2Motor(OpMode opMode) {
        this.opMode = opMode;
        this.telemetry = opMode.telemetry;
    }

    public void init(boolean auto) {
        left = opMode.hardwareMap.dcMotor.get("left");
        right = opMode.hardwareMap.dcMotor.get("right");
        if (!auto) gamepad1 = opMode.gamepad1;
        if (!auto) gamepad2 = opMode.gamepad2;
        telemetry.addLine("Chassis Control " + CCVER + " initialized in " + (auto ? "Autonomous" : "TeleOp") + " mode (2-Motor).");
        telemetry.update();
    }

    public void drive(double power){
        left.setPower(power);
        right.setPower(power);
    }

    /**
     * positive turns right
     * @param power
     */
    public void turn(double power) {
        left.setPower(power);
        right.setPower(-power);
    }

    public void stopDrive() {
        left.setPower(0);
        right.setPower(0);
    }


}

