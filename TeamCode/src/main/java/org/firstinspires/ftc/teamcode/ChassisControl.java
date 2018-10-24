package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static java.lang.Math.*;

public class ChassisControl {

    private DcMotor left;
    private DcMotor right;

    private DcMotor armPivot;
    private DcMotor armExtend;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private OpMode opMode;
    private Telemetry telemetry;

    public ChassisControl(OpMode opMode) {
        this.opMode = opMode;
        this.telemetry = opMode.telemetry;
    }

    public void init() {
        left = opMode.hardwareMap.dcMotor.get("left");
        right = opMode.hardwareMap.dcMotor.get("right");
        armPivot = opMode.hardwareMap.dcMotor.get("armPivot");
        armExtend = opMode.hardwareMap.dcMotor.get("armExtend");
        gamepad1 = opMode.gamepad1;
        gamepad2 = opMode.gamepad2;

        telemetry.addLine("Arm-Pivot: Starting Position? (A)");
        telemetry.update();
        while(!(gamepad1.a || gamepad2.a));
        while(gamepad1.a || gamepad2.a);
        telemetry.addLine("Arm-Extender: Lowest Position? (Adjust: B) (Done: A)");
        telemetry.update();
        while(!(gamepad1.a || gamepad2.a)) {
            if(gamepad2.b) armExtend.setPower(0.5f);
            else armExtend.setPower(0f);
        }
        telemetry.addLine("Initialization Finished.");
        telemetry.update();
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

        
    }


}
