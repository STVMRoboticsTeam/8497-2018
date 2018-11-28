package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "GetSpinnened")
public class GetSpinnened extends LinearOpMode {
	private CRServo s1;
	private CRServo s2;


	@Override
	public void runOpMode() {
		s1 = hardwareMap.crservo.get("s1");
		s2 = hardwareMap.crservo.get("s2");
		waitForStart();
		while(opModeIsActive()) {
			s1.setPower(0.3);
			s2.setPower(0.3);
		}
	}
}
