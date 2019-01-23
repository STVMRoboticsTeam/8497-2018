package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "GetSpinnened")
public class GetSpinnened extends LinearOpMode {

	private ChassisControl cc = new ChassisControl(this);

	@Override
	public void runOpMode() {
		cc.init(false);
		waitForStart();
		while(opModeIsActive()) {
			if(Math.abs(gamepad1.left_stick_y) > 0.04f) {
				float ly3 = gamepad1.left_stick_y * gamepad1.left_stick_y * gamepad1.left_stick_y;
				telemetry.addData("LY", gamepad1.left_stick_y);
				telemetry.addData("LY^3", ly3);
				cc.drive(ly3);
			} else cc.stopDrive();
		}
	}
}
