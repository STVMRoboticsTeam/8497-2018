package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.*;

public class ChassisControl {

    private DcMotor left;
    private DcMotor right;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private OpMode opMode;
    private Telemetry telemetry;

    public ChassisControl(OpMode opMode) {
        this.opMode = opMode;
        this.telemetry = opMode.telemetry;
    }

    public void init(boolean auto) {
        left = opMode.hardwareMap.dcMotor.get("left");
        right = opMode.hardwareMap.dcMotor.get("right");
        if (!auto) gamepad1 = opMode.gamepad1;
        if (!auto) gamepad2 = opMode.gamepad2;

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
