package net.camfeezel.ftc.api;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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
