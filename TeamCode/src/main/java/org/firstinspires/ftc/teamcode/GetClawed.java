package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by CST on 9/5/2018.
 */
@Autonomous(name = "GetClawed")
public class GetClawed extends LinearOpMode {

    private ChassisControl chassisControl;

    @Override
    public void runOpMode() {
        chassisControl = new ChassisControl(this);
        chassisControl.init(true);
        waitForStart();
        while(opModeIsActive()) {
            chassisControl.loop();
        }


    }
}
