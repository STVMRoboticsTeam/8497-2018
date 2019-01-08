package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static java.lang.Math.abs;

/**
 * Created by CST on 9/5/2018.
 */
@TeleOp(name = "GetBoonkd")
public class GetBoonkd extends LinearOpMode {

    private ChassisControl chassisControl;

    @Override

    public void runOpMode() {
        chassisControl = new ChassisControl(this);
        chassisControl.init(false);
        waitForStart();
        while(opModeIsActive()) {
			float ly = gamepad1.left_stick_y;
			float rx = gamepad1.right_stick_x;
			telemetry.addData("left y", ly);
			telemetry.addData("Right x", rx);

			if(abs(ly) > 0.05f) {
				chassisControl.drive(ly*ly*ly);
			} else if(abs(rx) > 0.05f) {
				chassisControl.turn(rx*rx*rx);
			} else {
				chassisControl.stopDrive();
			}


			telemetry.update();
        }


    }
}
