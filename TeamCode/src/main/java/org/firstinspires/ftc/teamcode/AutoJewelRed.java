package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

/**
 * Created by Aniketh on 11/18/2017.
 */
@Autonomous
public class AutoJewelRed extends LinearOpMode {
    /**
     * Created by Aniketh on 11/16/2017.
     */
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo jewelArm;
    ColorSensor color;
    GyroSensor gyro;

    private ElapsedTime runtime = new ElapsedTime();


    public final static double JEWEL_UP = 0.0; //smallest servo value(0)
    public final static double JEWEL_DOWN = 0.75;// largest servo value(135)
    public int gyroHeading = 0;


    @Override
    public void runOpMode() throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        jewelArm = hardwareMap.servo.get("servo2");
        color = hardwareMap.colorSensor.get("sensor0");
        gyro = hardwareMap.gyroSensor.get("sensor1");


        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        jewelArm.setPosition(JEWEL_UP);

        gyro.calibrate();
        waitForStart();

        jewelArm.setPosition(JEWEL_DOWN);

        if (color.red() < color.blue()){
            while(opModeIsActive() && gyroHeading < 45){
                frontLeft.setPower(-0.25);
                backLeft.setPower(-0.25);
                frontRight.setPower(0.25);
                backRight.setPower(0.25);
                if (gyro.getHeading() < 180){
                    gyroHeading = gyro.getHeading();
                }
                else{
                    gyroHeading = gyro.getHeading() - 360;
                }
            }

        }
        else {
            while(opModeIsActive() && gyroHeading < -45){
                frontLeft.setPower(0.25);
                backLeft.setPower(0.25);
                frontRight.setPower(-0.25);
                backRight.setPower(-0.25);
                if (gyro.getHeading() < 180){
                    gyroHeading = gyro.getHeading();
                }
                else{
                    gyroHeading = gyro.getHeading() - 360;
                }
            }

        }


    }
}

