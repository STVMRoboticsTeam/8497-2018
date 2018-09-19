package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import static java.lang.Math.*;

public class ChassisControl {

    private DcMotor left;
    private DcMotor right;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    private OpMode opMode;

    public ChassisControl(OpMode opMode) {
        this.opMode = opMode;
    }

    public void init() {
        left = opMode.hardwareMap.dcMotor.get("left");
        right = opMode.hardwareMap.dcMotor.get("right");
    }

    public void loop() {
        float ly = gamepad1.left_stick_y;
        float rx = gamepad1.right_stick_x;
        if(abs(ly) > 0.05f) {
            left.setPower(ly);
            right.setPower(ly);
            if(abs(rx) > 0.05f) {

            }
        } else if(abs(rx) > 0.05f) {
            left.setPower(-rx);
            right.setPower(rx);
        } else {
            left.setPower(0);
            right.setPower(0);
        }
    }


}
