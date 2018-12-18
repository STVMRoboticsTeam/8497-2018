package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class GetThrowned extends LinearOpMode {

	private Servo serrrrrvrrvrro;

	@Override
	public void runOpMode() {
		serrrrrvrrvrro = hardwareMap.servo.get("servo");
		waitForStart();
		serrrrrvrrvrro.setPosition(90);
	}
}
