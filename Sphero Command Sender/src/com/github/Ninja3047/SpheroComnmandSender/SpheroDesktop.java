package com.github.Ninja3047.SpheroComnmandSender;

import java.util.Scanner;

import se.nicklasgavelin.bluetooth.Bluetooth;
import se.nicklasgavelin.bluetooth.BluetoothDevice;
import se.nicklasgavelin.sphero.Robot;
import se.nicklasgavelin.sphero.exception.InvalidRobotAddressException;
import se.nicklasgavelin.sphero.exception.RobotBluetoothException;

public class SpheroDesktop
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String input;
		
		System.out.println("Welcome to Sphero Desktop Command Sender");
		System.out.println("Version 1.0a");
		System.out.println("By William Tan");
		
		System.out.println();
		
		System.out.print("Enter Bluetooth Id: ");
		String bid = keyboard.nextLine();
		
		Bluetooth bt = new Bluetooth( Bluetooth.SERIAL_COM );
		BluetoothDevice btd = new BluetoothDevice(bt, "btspp://" + bid + ":1;authenticate=true;encrypt=false;master=false");

		try
		{
			Robot r = new Robot( btd );
		    Parser parser = new Parser(r);
			do
			{
				System.out.print(">> ");
				input = keyboard.nextLine();
				parser.parse(input);
					
			} while(input != "exit");
		}
		catch (InvalidRobotAddressException e)
		{
			System.err.println("Invalid Robot Address Exception!");
		}
		catch (RobotBluetoothException e)
		{
			System.err.println("Robot Bluetooth Exception");
		} catch (Exception e)
		{
			System.err.println("Other Error");
		}
		keyboard.close();
	}
}
 