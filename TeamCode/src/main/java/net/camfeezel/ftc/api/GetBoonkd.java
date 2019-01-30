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

    private boolean b;
    private boolean bHold;

    @Override

    public void runOpMode() {
        chassisControl = new ChassisControl(this);
        chassisControl.init(false);
		telemetry.addLine("If either of the arms aren't at the bottom you fucked up");
        waitForStart();
        while(opModeIsActive()) {
			float ly = gamepad1.left_stick_y;
			float rx = gamepad1.right_stick_x;
			float rt = gamepad1.right_trigger;
			float lt = gamepad1.left_trigger;
			float ly2 = gamepad2.left_stick_y;
			telemetry.addData("left y", ly);
            telemetry.addData("Right x", rx);
			telemetry.addData("left y2", ly2);
			telemetry.addData("Outwards", chassisControl.getOutwardsArm());
			telemetry.addData("Lift", chassisControl.getLiftArm());

			/* GamePad1
			Andrew's Controls

			Left Y: Drive
			Right X: Turn
			Y: Outwards Out
			A: Outwards In
			Right T: Mineral Pivot Out
			Left T: Mineral Pivot In
			 */
			if(abs(ly) > 0.05f) {
				float inrange = (abs(ly) * 0.5f) + 0.5f;
				inrange *= Math.signum(ly);
				chassisControl.drive(inrange*inrange*inrange);
			} else if(abs(rx) > 0.05f) {
				chassisControl.turn(rx*rx*rx);
			} else {
				chassisControl.stopDrive();
			}

			if(gamepad1.y && !gamepad1.a) {
				if(chassisControl.getOutwardsArm() < 4400) {
					chassisControl.moveOutwardsArm(-0.3f);
				} else {
					chassisControl.stopOutwardsArm();
				}
            } else if(gamepad1.a && !gamepad1.y) {
				if(chassisControl.getOutwardsArm() > 0) {
					chassisControl.moveOutwardsArm(0.3f);
				} else {
					chassisControl.stopOutwardsArm();
				}
			} else {
				chassisControl.stopOutwardsArm();
			}

			/* GamePad2
			Matthew's Controls

			Y: Lift Up
			A: Lift Down
			B: Mineral Servo

			Left y: Mineral Lift
			 */

			if(gamepad2.y) {
				if(chassisControl.getLiftArm() < 16000) {
					chassisControl.moveLiftArm(0.7f);
				} else {
					chassisControl.stopLiftArm();
				}
			} else if(gamepad2.a) {
				if(chassisControl.getLiftArm() > 0) {
					chassisControl.moveLiftArm(-0.7f);
				} else {
					chassisControl.stopLiftArm();
				}
			} else {
				chassisControl.stopLiftArm();
			}

			if(abs(ly2) > 0.05f) {
				if(ly2 > 0) {
					if(chassisControl.getMineralArm() > 0) {
						chassisControl.moveMineralArm(ly2);
					} else {
						chassisControl.stopMineralArm();
					}
				} else {
					if(chassisControl.getMineralArm() < 3000) {
						chassisControl.moveMineralArm(ly2);
					} else {
						chassisControl.stopMineralArm();
					}
				}
			}

			if(gamepad2.b && !bHold) {
				if (!b) chassisControl.moveMineralServo(60);
				else chassisControl.moveMineralServo(170);
				bHold = true;
				b = !b;
			}
			if(!gamepad2.b && bHold) bHold = false;
			oh fuck hes got airpods in oh god oh fuck


			telemetry.update();
        }


    }
}
