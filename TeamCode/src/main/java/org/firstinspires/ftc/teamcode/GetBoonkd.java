package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by CST on 9/5/2018.
 */
@TeleOp(name = "GetBoonkd")
public class GetBoonkd extends LinearOpMode {

    private ChassisControl chassisControl;

    @Override
    public void runOpMode() {
        chassisControl = new ChassisControl(this);
        chassisControl.init();
        waitForStart();
        while(opModeIsActive()) {
            chassisControl.loop();
        }


    }
}
