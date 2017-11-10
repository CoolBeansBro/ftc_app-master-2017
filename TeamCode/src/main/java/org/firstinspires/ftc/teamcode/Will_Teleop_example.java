package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Will on 3/15/2016.
 */
public class Will_Teleop_example extends OpMode {
    // Creates all the motor variables the program uses
    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor arm;

    // redefines the init sequence - what happens when you press 'init' on the driver station
    @Override
    public void init() {
        // assigns motor variables to motors
        leftDrive = hardwareMap.dcMotor.get("motor2");
        rightDrive = hardwareMap.dcMotor.get("motor1");


        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        arm = hardwareMap.dcMotor.get("motor3");

    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        leftDrive.setPower(leftY);
        rightDrive.setPower(rightY);

        if (gamepad2.a) {
            arm.setPower(0.5);
        } else {
            arm.setPower(0);
        }

        if (gamepad2.y) {
            arm.setPower(-0.5);
        } else {
            arm.setPower(0);
        }
    }
}
