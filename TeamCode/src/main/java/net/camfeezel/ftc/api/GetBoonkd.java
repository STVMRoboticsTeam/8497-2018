package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
            chassisControl.loop();
        }


    }
}
