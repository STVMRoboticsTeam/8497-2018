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
    private DcMotor outwardsArm;
    private DcMotor liftArm;
    private DcMotor mineralArm;

    private Servo mineralServo;
    private Servo claimServo;
    private CRServo mineralPivotServo;
    private CRServo mineralSuccServo;

    public ChassisControl(OpMode opMode) {
        super(opMode);
        outwardsArm = opMode.hardwareMap.dcMotor.get("outwardsArm");
        liftArm = opMode.hardwareMap.dcMotor.get("liftArm");
        mineralArm = opMode.hardwareMap.dcMotor.get("mineralArm");

        mineralServo = opMode.hardwareMap.servo.get("mineralServo");
        claimServo = opMode.hardwareMap.servo.get("claimServo");
        mineralPivotServo = opMode.hardwareMap.crservo.get("mineralPivotServo");
        mineralSuccServo = opMode.hardwareMap.crservo.get("mineralSuccServo");
    }

    public void init(boolean auto) {
        super.init(auto);
    }

    public void moveOutwardsArm(float power) {
        outwardsArm.setPower(power);
    }

    public void stopOutwardsArm() {
        outwardsArm.setPower(0);
    }

    public long getOutwardsArm() {
        return outwardsArm.getCurrentPosition();
    }

    public void moveLiftArm(float power) {
        liftArm.setPower(power);
    }

    public void stopLiftArm() {
        liftArm.setPower(0);
    }

    public long getLiftArm() {
        return liftArm.getCurrentPosition();
    }

    public void moveMineralArm(float power) {
        mineralArm.setPower(power);
    }

    public long getMineralArm() {
        return mineralArm.getCurrentPosition();
    }

    public void stopMineralArm() {
        mineralArm.setPower(0);
    }

    public void moveMineralServo(double deg) {
        mineralServo.setPosition(deg);
    }

    public double getMineralServoPos() {
        return mineralServo.getPosition();
    }

    public void moveClaimServo(double deg) {
        claimServo.setPosition(deg);
    }

    public double getClaimServoPos() {
        return claimServo.getPosition();
    }

    public void moveMineralPivotServo(double power) {
        mineralPivotServo.setPower(power);
    }

    public void stopMineralPivotServo() {
    	mineralPivotServo.setPower(0f);
	}

    public void moveMineralSuccServo(double power) {
    	mineralSuccServo.setPower(power);
	}

	public void stopMineralSuccServo() {
    	mineralSuccServo.setPower(0f);
	}
}
