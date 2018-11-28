package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.*;

public class ChassisControl {

    private DcMotor left;
    private DcMotor right;

    private DcMotor armPivot;
    private DcMotor armExtend;

    private DcMotor liftArm;

    private CRServo spinnerServo1;
    private CRServo spinnerServo2;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private OpMode opMode;
    private Telemetry telemetry;

    private float spinDir;

    public ChassisControl(OpMode opMode) {
        this.opMode = opMode;
        this.telemetry = opMode.telemetry;
    }

    public void init(boolean auto) {
        left = opMode.hardwareMap.dcMotor.get("left");
        right = opMode.hardwareMap.dcMotor.get("right");
        armPivot = opMode.hardwareMap.dcMotor.get("armPivot");
        armExtend = opMode.hardwareMap.dcMotor.get("armExtend");
        liftArm = opMode.hardwareMap.dcMotor.get("liftArm");
        spinnerServo1 = opMode.hardwareMap.crservo.get("spinServo1");
        spinnerServo2 = opMode.hardwareMap.crservo.get("spinServo2");
        if (!auto) gamepad1 = opMode.gamepad1;
        if (!auto) gamepad2 = opMode.gamepad2;
    }

    public void loop() {
        float ly = gamepad1.left_stick_y;
        float rx = gamepad1.right_stick_x;
        telemetry.addData("left y", ly);
        telemetry.addData("Right x", rx);

        if(abs(ly) > 0.05f) {
            left.setPower(ly*ly*ly);
            right.setPower(ly*ly*ly);
        } else if(abs(rx) > 0.05f) {
            left.setPower(-(rx*rx*rx));
            right.setPower(rx*rx*rx);
        } else {
            left.setPower(0);
            right.setPower(0);
        }

        float lx2 = gamepad2.left_stick_x;
        telemetry.addData("left2 x", lx2);
        if(abs(lx2) > 0.05f) {
            armPivot.setPower(lx2 / 4);
        } else {
            armPivot.setPower(0);
        }

        float ry2 = gamepad2.right_stick_y;
        telemetry.addData("right2 y", ry2);
        if(abs(ry2) > 0.05f) {
            armExtend.setPower(ry2);
        } else {
            armExtend.setPower(0);
        }

        if(gamepad2.b) {
            liftArm.setPower(0.2);
        } else if (gamepad2.x) {
            liftArm.setPower(0.2);
        } else liftArm.setPower(0);

		if(gamepad2.right_trigger > 0.05f) {
			enableSpinning(false);
		} else if(gamepad2.left_trigger > 0.05f) {
			enableSpinning(true);
		} else {
			disableSpinning();
		}
    }

	/**
	 *
	 * @return float containing the spin direction. negative for inward, 0 for disabled, positive for outward.
	 */
	public float isSpinningEnabled() {
    	return spinDir;
	}

    public void liftSpeed(double speeeeeeeeeeeeeeeeeed) {
        liftArm.setPower(speeeeeeeeeeeeeeeeeed);
    }

	/**
	 * Enables spinServo1 and spinServo2 if not already
	 */
	public void enableSpinning(boolean outward) {
		spinnerServo1.setPower(outward ? -0.7 : 0.7);
		spinnerServo2.setPower(outward ? 0.7 : -0.7);
		spinDir = outward ? -1 : 1;
	}

	/**
	 * Disables spinServo1 and spinServo2 if not already
	 */
	public void disableSpinning() {
		spinnerServo1.setPower(0);
		spinnerServo2.setPower(0);
		spinDir = 0;
	}
}
