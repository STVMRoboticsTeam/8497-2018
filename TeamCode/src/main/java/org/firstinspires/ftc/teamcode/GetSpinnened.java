package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "GetSpinnened")
public class GetSpinnened extends LinearOpMode {
        private Servo s1;
        private Servo s2;


        @Override
        public void runOpMode() {
            s1 = hardwareMap.servo.get("s1");
            s2 = hardwareMap.servo.get("s2");
            waitForStart();
            while(opModeIsActive()) {
                s1.setPosition(0.4);
                s2.setPosition(0.6);
            }
        }
    }

}
